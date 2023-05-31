package gov.irrigation.service;


import gov.irrigation.model.Plot;

public interface AlertService {
    void sendSensorNotAvailableAlert(Plot plot);
    void sendRetryExceededAlert(Plot plot);
}

