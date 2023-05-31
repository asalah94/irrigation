package gov.irrigation.controller;

import gov.irrigation.model.Plot;
import gov.irrigation.service.AlertService;
import gov.irrigation.service.PlotService;
import gov.irrigation.service.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plots")
public class PlotController {
    private final PlotService plotService;
    private final SensorService sensorService;

    private final AlertService alertService;

    public PlotController(PlotService plotService, SensorService sensorService, AlertService alertService) {
        this.plotService = plotService;
        this.sensorService = sensorService;
        this.alertService = alertService;
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

    /**
     * Send a sensor not available alert for a specific plot.
     * This method triggers the alert service to send a sensor not available alert for the specified plot.
     */
    @PostMapping("/{plotId}/sensor-not-available")
    public ResponseEntity<Void> sendSensorNotAvailableAlert(@PathVariable Long plotId) {
        Plot plot = plotService.getPlotById(plotId);
        alertService.sendSensorNotAvailableAlert(plot);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Send a retry exceeded alert for a specific plot.
     * This method triggers the alert service to send a retry exceeded alert for the specified plot.
     */
    @PostMapping("/{plotId}/retry-exceeded")
    public ResponseEntity<Void> sendRetryExceededAlert(@PathVariable Long plotId) {
        Plot plot = plotService.getPlotById(plotId);
        alertService.sendRetryExceededAlert(plot);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

