package br.com.jansoftinfo.apiteste.domain.exceptions;

import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class HandlerAdviceException {
    @Generated
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerAnyException(Exception ex) {
        return handlerException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorDTO.builder()
                .message(ex.getMessage())
                .build(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorDTO> errors = new ArrayList<>();
        ex.getAllErrors().forEach(e -> {
            errors.add(ErrorDTO.builder()
                    .message(e.getDefaultMessage())
                    .build());
        });
        return handlerException(HttpStatus.BAD_REQUEST, null, errors);
    }

    private ResponseEntity<?> handlerException(HttpStatus httpStatus, ErrorDTO error, List<ErrorDTO> errors) {
        return ResponseEntity
                .status(httpStatus)
                .body(Objects.isNull(error) ? errors : error);
    }
}