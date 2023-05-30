package gov.irrigation.service.impl;

import gov.irrigation.model.Plot;
import gov.irrigation.repository.PlotRepository;
import gov.irrigation.service.PlotService;
import gov.irrigation.service.SensorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PlotServiceImpl implements PlotService {

    private final PlotRepository plotRepository;

    private final SensorService sensorService;

    public PlotServiceImpl(PlotRepository plotRepository, SensorService sensorService) {
        this.plotRepository = plotRepository;

        this.sensorService = sensorService;
    }

    @Override
    public Plot addPlot(Plot plot) {
        return plotRepository.save(plot);
    }

    @Override
    public Plot updatePlot(Long plotId, Plot updatedPlot) {
        Plot plot = getPlotById(plotId);
        updatePlotFields(plot, updatedPlot);
        return plotRepository.save(plot);
    }

    @Override
    public List<Plot> getAllPlots() {
        return plotRepository.findAll();
    }

    @Override
    public void irrigatePlot(Long plotId) {
        Plot plot = getPlotById(plotId);
        sensorService.sendIrrigationRequest(plot);
    }

    @Override
    public void retrySensorDevice(Long plotId) {
        Plot plot = getPlotById(plotId);
        sensorService.initiateRetry(plot);
    }

    public Plot getPlotById(Long plotId) {
        return plotRepository.findById(plotId)
                .orElseThrow(() -> new EntityNotFoundException("Plot not found with id: " + plotId));
    }

    private void updatePlotFields(Plot plot, Plot updatedPlot) {
        plot.setName(updatedPlot.getName());
        plot.setArea(updatedPlot.getArea());
        plot.setCropType(updatedPlot.getCropType());
    }
}
