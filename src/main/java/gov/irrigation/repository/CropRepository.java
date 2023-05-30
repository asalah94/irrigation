package gov.irrigation.repository;


import gov.irrigation.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
    Crop findByCropType(String cropType);
}

