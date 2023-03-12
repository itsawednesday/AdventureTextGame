package com.example.decisionmap;

public class EmptyException  extends RuntimeException{
    public EmptyException() {
        super("Option not found");
    }

    public EmptyException(String message) {
        super(message);
    }
}
