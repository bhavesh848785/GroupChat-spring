package com.example.charappspring.models;

public class Message {
    private String identity;
    private String content;

    public Message(String name, String content) {
        this.identity = name;
        this.content = content;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
