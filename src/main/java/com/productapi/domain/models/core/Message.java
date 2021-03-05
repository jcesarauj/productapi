package com.productapi.domain.models.core;

public class Message{
    private int _number;
    private String _message;

    public Message(int number, String message) {
        _number = number;
        _message = message;
    }

    public int getNumber() {
        return _number;
    }

    public String getMessage() {
        return _message;
    }
}
