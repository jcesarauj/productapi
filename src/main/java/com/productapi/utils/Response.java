package com.productapi.utils;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

public class Response<T> {
    private boolean _success;
    private List<Message> _messages;
    private T _data;

    public Response(boolean success, String message, T data) {
        if (_messages == null && message != "") {
            _messages = new ArrayList<Message>(asList(new Message(1, message)));
        }
        _success = success;
        _data = data;
    }

    public boolean isSuccess() {
        return _success;
    }

    public List<Message> getMessages() {
        return _messages;
    }

    public T getData() {
        return _data;
    }
}
