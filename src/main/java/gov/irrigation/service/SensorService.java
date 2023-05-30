package gov.irrigation.service;

import gov.irrigation.model.Plot;

public interface SensorService {
    String sendIrrigationRequest(Plot plot);
    String initiateRetry(Plot plot);
}
