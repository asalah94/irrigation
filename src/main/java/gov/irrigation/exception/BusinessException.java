package gov.irrigation.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private  final  String [] params;

    public BusinessException(String message, HttpStatus httpStatus, String [] params) {
        super(message);
        this.httpStatus = httpStatus;
        this.params = params;
    }

}
