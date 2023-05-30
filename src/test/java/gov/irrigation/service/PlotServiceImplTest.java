package gov.irrigation.service;

import gov.irrigation.model.Plot;
import gov.irrigation.repository.PlotRepository;
import gov.irrigation.service.impl.PlotServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlotServiceImplTest {

    private PlotServiceImpl plotService;

    @Mock
    private PlotRepository plotRepository;

    @Mock
    private SensorService sensorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        plotService = new PlotServiceImpl(plotRepository, sensorService);
    }

    @Test
    void testAddPlot() {
        Plot plot = new Plot();
        when(plotRepository.save(plot)).thenReturn(plot);

        Plot result = plotService.addPlot(plot);

        assertNotNull(result);
        assertEquals(plot, result);
        verify(plotRepository, times(1)).save(plot);
    }

    @Test
    void testUpdatePlot() {
        Long plotId = 1L;
        Plot existingPlot = new Plot();
        Plot updatedPlot = new Plot();

        when(plotRepository.findById(plotId)).thenReturn(Optional.of(existingPlot));
        when(plotRepository.save(existingPlot)).thenReturn(existingPlot);

        Plot result = plotService.updatePlot(plotId, updatedPlot);

        assertNotNull(result);
        assertEquals(existingPlot, result);
        verify(plotRepository, times(1)).findById(plotId);
        verify(plotRepository, times(1)).save(existingPlot);
    }

    @Test
    void testUpdatePlot_ThrowsEntityNotFoundException() {
        Long plotId = 1L;
        Plot updatedPlot = new Plot();

        when(plotRepository.findById(plotId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> plotService.updatePlot(plotId, updatedPlot));
        assertEquals("Plot not found with id: " + plotId, exception.getMessage());
        verify(plotRepository, times(1)).findById(plotId);
        verify(plotRepository, never()).save(any(Plot.class));
    }

    @Test
    void testGetAllPlots() {
        List<Plot> plots = new ArrayList<>();
        when(plotRepository.findAll()).thenReturn(plots);

        List<Plot> result = plotService.getAllPlots();

        assertNotNull(result);
        assertEquals(plots, result);
        verify(plotRepository, times(1)).findAll();
    }

    @Test
    void testIrrigatePlot() {
        Long plotId = 1L;
        Plot plot = new Plot();

        when(plotRepository.findById(plotId)).thenReturn(Optional.of(plot));

        plotService.irrigatePlot(plotId);

        verify(sensorService, times(1)).sendIrrigationRequest(plot);
    }

    @Test
    void testIrrigatePlot_ThrowsEntityNotFoundException() {
        Long plotId = 1L;

        when(plotRepository.findById(plotId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> plotService.irrigatePlot(plotId));
        assertEquals("Plot not found with id: " + plotId, exception.getMessage());
        verify(sensorService, never()).sendIrrigationRequest(any(Plot.class));
    }

    @Test
    void testRetrySensorDevice() {
        Long plotId = 1L;
        Plot plot = new Plot();

        when(plotRepository.findById(plotId)).thenReturn(Optional.of(plot));

        plotService.retrySensorDevice(plotId);

        verify(sensorService, times(1)).initiateRetry(plot);
    }

    @Test
    void testRetrySensorDevice_ThrowsEntityNotFoundException() {
        Long plotId = 1L;

        when(plotRepository.findById(plotId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> plotService.retrySensorDevice(plotId));
        assertEquals("Plot not found with id: " + plotId, exception.getMessage());
        verify(sensorService, never()).initiateRetry(any(Plot.class));
    }

    @Test
    void testGetPlotById() {
        Long plotId = 1L;
        Plot plot = new Plot();

        when(plotRepository.findById(plotId)).thenReturn(Optional.of(plot));

        Plot result = plotService.getPlotById(plotId);

        assertNotNull(result);
        assertEquals(plot, result);
        verify(plotRepository, times(1)).findById(plotId);
    }

    @Test
    void testGetPlotById_ThrowsEntityNotFoundException() {
        Long plotId = 1L;

        when(plotRepository.findById(plotId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> plotService.getPlotById(plotId));
        assertEquals("Plot not found with id: " + plotId, exception.getMessage());
        verify(plotRepository, times(1)).findById(plotId);
    }

    private Plot createTestPlot() {
        Plot plot = new Plot();
        plot.setId(1L);
        plot.setName("Test Plot");
        plot.setArea(100.0);
        plot.setCropType("Wheat");
        return plot;
    }
}

