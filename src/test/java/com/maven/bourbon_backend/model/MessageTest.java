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
    void canGetUserNameTo() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        String name = message.getUserNameTo();
        //then
        assertThat(name).isEqualTo("user1");
    }

    @Test
    void canSetUserNameTo() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setUserNameTo("newUser");
        //then
        assertThat(message.getUserNameTo()).isEqualTo("newUser");
    }

    @Test
    void canGetUserNameFrom() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        String name = message.getUserNameFrom();
        //then
        assertThat(name).isEqualTo("user2");
    }

    @Test
    void canSetUserNameFrom() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setUserNameFrom("newUser");
        //then
        assertThat(message.getUserNameFrom()).isEqualTo("newUser");
    }

    @Test
    void canGetId() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        String name = message.getId();
        //then
        assertThat(name).isEqualTo("testID");
    }

    @Test
    void canSetId() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setId("newUser");
        //then
        assertThat(message.getId()).isEqualTo("newUser");
    }

    @Test
    void canGetMessage() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        String name = message.getMessage();
        //then
        assertThat(name).isEqualTo("Test Message.");
    }

    @Test
    void canSetMessage() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setMessage("newUser");
        //then
        assertThat(message.getMessage()).isEqualTo("newUser");
    }

    @Test
    void canGetTimeStamp() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setTimeStamp(341234);
        //then
        assertThat(message.getTimeStamp()).isEqualTo(341234);
    }

    @Test
    void canSetTimeStamp() {
        //given message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        message.setTimeStamp(341234);
        //then
        assertThat(message.getTimeStamp()).isEqualTo(341234);
    }
}