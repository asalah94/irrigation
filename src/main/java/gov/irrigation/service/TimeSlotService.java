package gov.irrigation.service;

import gov.irrigation.model.TimeSlot;

public interface TimeSlotService {
    TimeSlot configureTimeSlot(Long plotId, TimeSlot timeSlot);
    TimeSlot updateTimeSlotStatus(Long timeslotId, String status);
}
