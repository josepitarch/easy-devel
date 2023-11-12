package com.easydevel.camper.infrastructure.exception.handler;

import com.easydevel.camper.domain.exception.exception.BusinessException;
import com.easydevel.camper.domain.exception.exception.NotFoundSectionException;
import com.easydevel.camper.domain.exception.exception.UniqueSectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class ControllerHandlerException {
    @ExceptionHandler({ UniqueSectionException.class, BusinessException.class })
    public ResponseEntity<Map<String, String>> handleBadRequest(Exception ex) {
        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(NotFoundSectionException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(Exception ex) {
        return ResponseEntity
                .notFound()
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        final FieldError fieldError = Objects.requireNonNull(ex.getBindingResult().getFieldError());
        final String message = Objects.requireNonNull(fieldError).getDefaultMessage();

        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("error", message));
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleInternalServerError(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("error", "Ha ocurrido un error inesperado. Por favor, inténtelo de nuevo más tarde."));
    }
}
