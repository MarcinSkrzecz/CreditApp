package com.marcin.credit_application.domain.exceptions;

public class ValidationInputException extends Exception {
    public ValidationInputException(final String message) {
        super(message);
    }
}
