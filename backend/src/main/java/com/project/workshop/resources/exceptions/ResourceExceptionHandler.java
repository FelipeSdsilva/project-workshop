package com.project.workshop.resources.exceptions;

import com.project.workshop.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest http) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();
        error.setTimeStamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(http.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
