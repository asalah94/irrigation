package gov.irrigation.service.impl;

import gov.irrigation.model.Plot;
import gov.irrigation.service.SensorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SensorServiceImpl implements SensorService {



    @Override
    public String sendIrrigationRequest(Plot plot) {
     return "irrigation request sent"  ;
    }

    @Override
    public String initiateRetry(Plot plot) {
        return "initiate retry simulation"  ;

    }
}
