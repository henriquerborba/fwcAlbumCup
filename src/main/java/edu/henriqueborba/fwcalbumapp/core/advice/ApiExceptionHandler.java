package edu.henriqueborba.fwcalbumapp.core.advice;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ApiException apiException = ApiException.builder()
                .message(e.getMessage())
                .throwable(e)
                .httpStatus(badRequest)
                .timestamp(ZonedDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, badRequest);

    }

    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException e) {
        final HttpStatus unauthorized = HttpStatus.UNAUTHORIZED;

        final ApiException apiException = ApiException.builder()
                .message(e.getMessage())
                .httpStatus(unauthorized)
                .timestamp(ZonedDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, unauthorized);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception e) {
        final HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        final ApiException apiException = ApiException.builder()
                .message(e.getMessage())
                .throwable(e)
                .httpStatus(internalServerError)
                .timestamp(ZonedDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, internalServerError);
    }

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<Object> handleBusinessException(BusinessException e) {
        final HttpStatus httpStatus = e.getHttpStatus();

        final ApiException apiException = ApiException.builder()
                .message(e.getMessage())
                .throwable(e)
                .httpStatus(httpStatus)
                .timestamp(ZonedDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, httpStatus);
    }
}
