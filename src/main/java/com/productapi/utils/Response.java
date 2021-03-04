package com.productapi.utils;

public class Response<T> {
    private boolean _success;
    private String _message;
    private T _data;

    public Response(boolean success, String message, T data) {
        _success = success;
        _message = message;
        _data = data;
    }

    public boolean isSuccess() {
        return _success;
    }

    public String getMessage() {
        return _message;
    }

    public T getData() {
        return _data;
    }
}
