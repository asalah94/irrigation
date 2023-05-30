package gov.irrigation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiExceptionDto {
    private String message;
    private String arMessage;
    private HttpStatus httpStatus;
    private String zonedDateTime;

}
