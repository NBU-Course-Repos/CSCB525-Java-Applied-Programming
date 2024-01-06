package com.example.transportcompany.reports;

/**
 * An {@link Exception} thrown when attempting to generate an invalid {@link Report}
 */
public class InvalidReportRequestException extends Exception {
    public InvalidReportRequestException(String message) {
        super(message);
    }
}
