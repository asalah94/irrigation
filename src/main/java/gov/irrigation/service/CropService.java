package gov.irrigation.service;


import gov.irrigation.dto.PredictionResult;

public interface CropService {
    PredictionResult predictSlotsAndWater(String cropType, Double cultivatedArea);
}

