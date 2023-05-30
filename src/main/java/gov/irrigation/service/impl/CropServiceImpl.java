package gov.irrigation.service.impl;

import gov.irrigation.dto.PredictionResult;
import gov.irrigation.enums.SlotTime;
import gov.irrigation.model.Crop;
import gov.irrigation.repository.CropRepository;
import gov.irrigation.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;

    @Autowired
    public CropServiceImpl(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    @Override
    public PredictionResult predictSlotsAndWater(String cropType, Double cultivatedArea) {
        Crop crop = cropRepository.findByCropType(cropType);

        if (crop == null) {
            throw new IllegalArgumentException("Invalid crop type: " + cropType);
        }

        SlotTime recommendedSlotTime = crop.getRecommendedSlotTime();
        int recommendedWaterAmount = crop.getRecommendedWaterAmount();

        int calculatedWaterAmount = (int) (recommendedWaterAmount * cultivatedArea);
        String calculatedSlotTime = calculateSlotTime(recommendedSlotTime);

        PredictionResult predictionResult = new PredictionResult();
        predictionResult.setSlotTime(calculatedSlotTime);
        predictionResult.setWaterAmount(calculatedWaterAmount);

        return predictionResult;
    }

    private String calculateSlotTime(SlotTime recommendedSlotTime) {
        int calculatedSlotTimeHours;

        switch (recommendedSlotTime) {
            case MORNING:
                calculatedSlotTimeHours = 6;
                break;
            case AFTERNOON:
                calculatedSlotTimeHours = 4;
                break;
            case EVENING:
                calculatedSlotTimeHours = 8;
                break;
            default:
                calculatedSlotTimeHours = 0;
                break;
        }

        return calculatedSlotTimeHours + " hours";
    }

}

