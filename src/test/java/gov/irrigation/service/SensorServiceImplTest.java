package gov.irrigation.service;

import gov.irrigation.model.Plot;
import gov.irrigation.service.impl.SensorServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SensorServiceImplTest {

    private SensorServiceImpl sensorService = new SensorServiceImpl();

    @Test
    void testSendIrrigationRequest() {
        Plot plot = new Plot();

        String result = sensorService.sendIrrigationRequest(plot);

        assertEquals("irrigation request sent", result);
    }

    @Test
    void testInitiateRetry() {
        Plot plot = new Plot();

        String result = sensorService.initiateRetry(plot);

        assertEquals("initiate retry simulation", result);
    }
}
