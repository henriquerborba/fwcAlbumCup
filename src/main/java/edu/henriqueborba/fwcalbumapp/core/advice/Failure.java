package edu.henriqueborba.fwcalbumapp.core.advice;

public class Failure extends RuntimeException {
    public Failure(String message) {
        super(message);
    }

    public Failure(String message, Throwable cause) {
        super(message, cause);
    }
}

