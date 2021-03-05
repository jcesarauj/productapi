package com.productapi.domain.models.core;

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

    public Response(boolean success, String message) {
        if (_messages == null && message != "") {
            _messages = new ArrayList<Message>(asList(new Message(1, message)));
        }
        _success = success;
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

    public void AddMessage(Message message) {
        if (_messages == null) {
            _messages = new ArrayList<Message>();
        }
        _messages.add(message);
    }
}
