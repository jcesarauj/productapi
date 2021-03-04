package com.productapi.utils;

import java.util.List;

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
