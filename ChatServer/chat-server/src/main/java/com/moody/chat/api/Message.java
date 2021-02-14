package com.moody.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private long id;
    private String sender;
    private String recipient;

    public Message() {
        // Empty constructor for serialization
    }

    public Message(long id, String sender, String recipient) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
    }

    @JsonProperty
    public String getSender() {
        return this.sender;
    }

    @JsonProperty
    public String getRecipient() {
        return this.recipient;
    }

    @JsonProperty
    public long getId() {
        return this.id;
    }
}
