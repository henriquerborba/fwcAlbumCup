package edu.henriqueborba.fwcalbumapp.core.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException {
    private HttpStatus httpStatus = HttpStatus.CONFLICT;
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, HttpStatus status, Object ... params) {
        super(String.format(message, params));
        this.httpStatus = httpStatus;
    }

    public BusinessException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

