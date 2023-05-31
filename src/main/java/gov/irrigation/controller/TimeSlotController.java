package gov.irrigation.controller;

import gov.irrigation.model.TimeSlot;
import gov.irrigation.service.TimeSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }


    /**
     * Configure a time slot for a plot of land.
     * This method associates a time slot with a specific plot of land.
     */
    @PostMapping("/plots/{plotId}")
    public ResponseEntity<TimeSlot> configureTimeSlot(@PathVariable Long plotId, @RequestBody TimeSlot timeSlot) {
        TimeSlot configuredTimeSlot = timeSlotService.configureTimeSlot(plotId, timeSlot);
        return new ResponseEntity<>(configuredTimeSlot, HttpStatus.CREATED);
    }

    /**
     * Update the status of a time slot.
     * This method updates the status of a specific time slot identified by its ID.
     */
    @PutMapping("/{timeslotId}/status")
    public ResponseEntity<TimeSlot> updateTimeSlotStatus(@PathVariable Long timeslotId, @RequestParam String status) {
        TimeSlot updatedTimeSlot = timeSlotService.updateTimeSlotStatus(timeslotId, status);
        return new ResponseEntity<>(updatedTimeSlot, HttpStatus.OK);
    }

}

