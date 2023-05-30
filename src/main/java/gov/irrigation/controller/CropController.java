package gov.irrigation.controller;

import gov.irrigation.dto.PredictionResult;
import gov.irrigation.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crops")
public class CropController {

    private final CropService cropService;

    @Autowired
    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    /**
     * Endpoint to predict the slot time and water amount based on the given crop type and cultivated area.
     *
     * @param cropType       The type of crop
     * @param cultivatedArea The area of land where the crop is cultivated
     * @return ResponseEntity containing the predicted slot time and water amount
     */
    @GetMapping("/{cropType}/prediction/{cultivatedArea}")
    public ResponseEntity<PredictionResult> predictSlotsAndWater(@PathVariable String cropType, @PathVariable Double cultivatedArea) {
        PredictionResult predictionResult = cropService.predictSlotsAndWater(cropType, cultivatedArea);
        return ResponseEntity.ok(predictionResult);
    }
}
