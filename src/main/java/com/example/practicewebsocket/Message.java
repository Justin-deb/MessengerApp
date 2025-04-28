package com.example.practicewebsocket;

public class Message {
    private String user;
    private String message;

    public Message() {
    }

    public Message(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
