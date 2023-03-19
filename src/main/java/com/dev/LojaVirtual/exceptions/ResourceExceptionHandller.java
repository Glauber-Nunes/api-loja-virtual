package com.dev.LojaVirtual.exceptions;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandller {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFound entityNotFound, HttpServletRequest httpServletRequest) {

        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setError("ENTITY NOT FOUND");
        standardError.setMessenger(entityNotFound.getMessage());
        standardError.setPath(httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(CodigoNotFound.class)
    public ResponseEntity<StandardError> codigoNotFound(CodigoNotFound codigoNotFound, HttpServletRequest httpServletRequest) {

        StandardError standardError = StandardError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .Error("Codido Not Found")
                .messenger(codigoNotFound.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}
