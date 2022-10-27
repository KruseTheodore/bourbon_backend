package com.maven.bourbon_backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    private Message message;

    @BeforeEach
    void setUp(){
        message = new Message("testID", "user1", "user2", "Test Message.");
    }

    @Test
    void getUserNameTo() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        String name = message.getUserNameTo();
        //then
        assertThat(name).isEqualTo("user1");
    }

    @Test
    void setUserNameTo() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setUserNameTo("newUser");
        //then
        assertThat(message.getUserNameTo()).isEqualTo("newUser");
    }

    @Test
    void getUserNameFrom() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        String name = message.getUserNameFrom();
        //then
        assertThat(name).isEqualTo("user2");
    }

    @Test
    void setUserNameFrom() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setUserNameFrom("newUser");
        //then
        assertThat(message.getUserNameFrom()).isEqualTo("newUser");
    }

    @Test
    void getId() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        String name = message.getId();
        //then
        assertThat(name).isEqualTo("testID");
    }

    @Test
    void setId() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setId("newUser");
        //then
        assertThat(message.getId()).isEqualTo("newUser");
    }

    @Test
    void getMessage() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        String name = message.getMessage();
        //then
        assertThat(name).isEqualTo("Test Message.");
    }

    @Test
    void setMessage() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setMessage("newUser");
        //then
        assertThat(message.getMessage()).isEqualTo("newUser");
    }

    @Test
    void getTimeStamp() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setTimeStamp(341234);
        //then
        assertThat(message.getTimeStamp()).isEqualTo(341234);
    }

    @Test
    void setTimeStamp() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setTimeStamp(341234);
        //then
        assertThat(message.getTimeStamp()).isEqualTo(341234);
    }
}