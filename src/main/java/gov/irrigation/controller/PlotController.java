package gov.irrigation.controller;

import gov.irrigation.dto.PredictionResult;
import gov.irrigation.model.Plot;
import gov.irrigation.model.TimeSlot;
import gov.irrigation.service.PlotService;
import gov.irrigation.service.SensorService;
import gov.irrigation.service.TimeSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/plots")
public class PlotController {
    private final PlotService plotService;
    private final TimeSlotService timeSlotService;
    private final SensorService sensorService;

    public PlotController(PlotService plotService, TimeSlotService timeSlotService, SensorService sensorService) {
        this.plotService = plotService;
        this.timeSlotService = timeSlotService;
        this.sensorService = sensorService;
    }

    /**
     * Add a new plot of land.
     * This method creates a new plot of land based on the provided data.
     */
    @PostMapping
    public ResponseEntity<Plot> addPlot(@RequestBody Plot plot) {
        Plot createdPlot = plotService.addPlot(plot);
        return new ResponseEntity<>(createdPlot, HttpStatus.CREATED);
    }

    /**
     * Update an existing plot of land.
     * This method updates the details of a specific plot identified by its ID.
     */
    @PutMapping("/{plotId}")
    public ResponseEntity<Plot> updatePlot(@PathVariable Long plotId, @RequestBody Plot updatedPlot) {
        Plot plot = plotService.updatePlot(plotId, updatedPlot);
        return new ResponseEntity<>(plot, HttpStatus.OK);
    }

    /**
     * Get all plots of land.
     * This method retrieves a list of all plots of land.
     */
    @GetMapping
    public ResponseEntity<List<Plot>> getAllPlots() {
        List<Plot> plots = plotService.getAllPlots();
        return new ResponseEntity<>(plots, HttpStatus.OK);
    }

    /**
     * Configure a time slot for a plot of land.
     * This method associates a time slot with a specific plot of land.
     */
    @PostMapping("/{plotId}/timeslots")
    public ResponseEntity<TimeSlot> configureTimeSlot(@PathVariable Long plotId, @RequestBody TimeSlot timeSlot) {
        TimeSlot configuredTimeSlot = timeSlotService.configureTimeSlot(plotId, timeSlot);
        return new ResponseEntity<>(configuredTimeSlot, HttpStatus.CREATED);
    }

    /**
     * Update the status of a time slot.
     * This method updates the status of a specific time slot identified by its ID.
     */
    @PutMapping("/timeslots/{timeslotId}/status")
    public ResponseEntity<TimeSlot> updateTimeSlotStatus(@PathVariable Long timeslotId, @RequestParam String status) {
        TimeSlot updatedTimeSlot = timeSlotService.updateTimeSlotStatus(timeslotId, status);
        return new ResponseEntity<>(updatedTimeSlot, HttpStatus.OK);
    }

    /**
     * Retry the sensor device for a plot of land.
     * This method initiates a retry for the sensor device associated with a specific plot.
     */
    @PostMapping("/{plotId}/retry")
    public ResponseEntity<Void> retrySensorDevice(@PathVariable Long plotId) {
        plotService.retrySensorDevice(plotId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Irrigate a plot of land.
     * This method sends an irrigation request to the sensor device for a specific plot.
     */
    @PostMapping("/{plotId}/irrigate")
    public ResponseEntity<Void> irrigatePlot(@PathVariable Long plotId) {
        Plot plot = plotService.getPlotById(plotId);
        sensorService.sendIrrigationRequest(plot);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

