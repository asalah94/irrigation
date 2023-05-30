package gov.irrigation.service.impl;

import gov.irrigation.model.Plot;
import gov.irrigation.repository.TimeSlotRepository;
import gov.irrigation.model.TimeSlot;
import gov.irrigation.service.PlotService;
import gov.irrigation.service.TimeSlotService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final PlotService plotService;

    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository, PlotService plotService) {
        this.timeSlotRepository = timeSlotRepository;
        this.plotService = plotService;
    }

    @Override
    public TimeSlot configureTimeSlot(Long plotId, TimeSlot timeSlot) {
        Plot plot = plotService.getPlotById(plotId);
        timeSlot.setPlot(plot);
        timeSlot.setStatus("configured");
        return timeSlotRepository.save(timeSlot);
    }

    @Override
    public TimeSlot updateTimeSlotStatus(Long timeslotId, String status) {
        TimeSlot timeSlot = getTimeSlotById(timeslotId);
        timeSlot.setStatus(status);
        return timeSlotRepository.save(timeSlot);
    }

    private TimeSlot getTimeSlotById(Long timeslotId) {
        return timeSlotRepository.findById(timeslotId)
                .orElseThrow(() -> new EntityNotFoundException("TimeSlot not found with id: " + timeslotId));
    }
}
