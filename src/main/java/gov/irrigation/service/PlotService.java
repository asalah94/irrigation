package gov.irrigation.service;

import gov.irrigation.model.Plot;

import java.util.List;

public interface PlotService {
    Plot addPlot(Plot plot);
    Plot updatePlot(Long plotId, Plot updatedPlot);
    List<Plot> getAllPlots();
    void irrigatePlot(Long plotId);
    void retrySensorDevice(Long plotId);

    Plot getPlotById(Long plotId);


}
