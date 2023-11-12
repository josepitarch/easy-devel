package com.easydevel.camper.domain.exception.exception;

public class NotFoundSectionException extends RuntimeException {
    public NotFoundSectionException(Long id) {
        super(String.format("Section not found with id %s", id.toString()));
    }
}
