package com.example.decisionmap;

public class CustomException  extends RuntimeException {
    public CustomException() {
        super("Enter only 1 or 2");
    }

    public CustomException(String message) {
        super(message);
    }
}