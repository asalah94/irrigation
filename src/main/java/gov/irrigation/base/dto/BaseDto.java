package gov.irrigation.base.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class BaseDto {

    private UUID id;
    private String name;

}
