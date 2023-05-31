package gov.irrigation.model;


import gov.irrigation.base.model.BaseEntity;
import gov.irrigation.enums.SlotTime;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "crop" , schema = "irrigation")
@Setter
@Getter
public class Crop extends BaseEntity<Long> {

    private String cropType;
    @Enumerated(EnumType.STRING)
    private SlotTime recommendedSlotTime;
    private int recommendedWaterAmount;

}

