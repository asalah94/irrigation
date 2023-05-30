package gov.irrigation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PredictionResult {
    private String slotTime;
    private int waterAmount;

}

