package gov.irrigation.service;

import gov.irrigation.model.Plot;
import gov.irrigation.model.TimeSlot;
import gov.irrigation.repository.TimeSlotRepository;
import gov.irrigation.service.impl.TimeSlotServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TimeSlotServiceImplTest {

    @Mock
    private TimeSlotRepository timeSlotRepository;

    @Mock
    private PlotService plotService;

    private TimeSlotServiceImpl timeSlotService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        timeSlotService = new TimeSlotServiceImpl(timeSlotRepository, plotService);
    }

    @Test
    void testConfigureTimeSlot() {
        Long plotId = 1L;
        Plot plot = new Plot();
        TimeSlot timeSlot = new TimeSlot();

        when(plotService.getPlotById(plotId)).thenReturn(plot);
        when(timeSlotRepository.save(timeSlot)).thenReturn(timeSlot);

        TimeSlot result = timeSlotService.configureTimeSlot(plotId, timeSlot);

        assertSame(timeSlot, result);
        assertSame(plot, timeSlot.getPlot());
        assertEquals("configured", timeSlot.getStatus());

        verify(plotService).getPlotById(plotId);
        verify(timeSlotRepository).save(timeSlot);
    }

    @Test
    void testUpdateTimeSlotStatus() {
        Long timeslotId = 1L;
        String status = "new status";
        TimeSlot timeSlot = new TimeSlot();

        when(timeSlotRepository.findById(timeslotId)).thenReturn(java.util.Optional.of(timeSlot));
        when(timeSlotRepository.save(timeSlot)).thenReturn(timeSlot);

        TimeSlot result = timeSlotService.updateTimeSlotStatus(timeslotId, status);

        assertSame(timeSlot, result);
        assertEquals(status, timeSlot.getStatus());

        verify(timeSlotRepository).findById(timeslotId);
        verify(timeSlotRepository).save(timeSlot);
    }

    @Test
    void testUpdateTimeSlotStatus_ThrowsEntityNotFoundException() {
        Long timeslotId = 1L;
        String status = "new status";

        when(timeSlotRepository.findById(timeslotId)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            timeSlotService.updateTimeSlotStatus(timeslotId, status);
        });

        verify(timeSlotRepository).findById(timeslotId);
        verify(timeSlotRepository, never()).save(Mockito.any(TimeSlot.class));
    }
}

