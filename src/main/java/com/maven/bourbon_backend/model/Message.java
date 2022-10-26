package com.maven.bourbon_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Message {

    @Id
    private String id;

    @Field
    private String userNameTo;

    @Field
    private String userNameFrom;

    @Field
    private String message;

    @Field
    private long timeStamp;

    public Message(@JsonProperty("id") String id,
                   @JsonProperty("userNameTo") String userNameTo,
                   @JsonProperty("userNameFrom") String userNameFrom,
                   @JsonProperty("message") String message) {
        this.id = id;
        this.userNameTo = userNameTo;
        this.userNameFrom = userNameFrom;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getUserNameTo() {
        return userNameTo;
    }

    public void setUserNameTo(String userNameTo) {
        this.userNameTo = userNameTo;
    }

    public String getUserNameFrom() {
        return userNameFrom;
    }

    public void setUserNameFrom(String userNameFrom) {
        this.userNameFrom = userNameFrom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
