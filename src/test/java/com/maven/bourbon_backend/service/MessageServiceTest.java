package com.maven.bourbon_backend.service;


import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.model.Message;
import com.maven.bourbon_backend.repositories.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;
    private MessageService underTest;

    @BeforeEach
    void setUp(){
        underTest = new MessageService(messageRepository);
    }

    @Test
    void canAddMessage() {
        //given
        Message message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        underTest.addMessage(message);
        //then
        ArgumentCaptor<Message> messageArgumentCaptor = ArgumentCaptor.forClass(Message.class);
        verify(messageRepository).save(messageArgumentCaptor.capture());
        Message capturedMessage = messageArgumentCaptor.getValue();
        assertThat(capturedMessage).isEqualTo(message);
    }

    @Test
    void canDeleteMessageById() {
        //given
        Message message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        underTest.deleteMessageById(message.getId());
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(messageRepository).deleteById(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(message.getId());
    }

    @Test
    void canGetMessagesByUserTo() {
        //given
        Message message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        underTest.getMessagesByUserTo(message.getUserNameTo());
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(messageRepository).findByuserNameTo(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(message.getUserNameTo());
    }

    @Test
    void getMessagesByUserFrom() {
        //given
        Message message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        underTest.getMessagesByUserFrom(message.getUserNameFrom());
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(messageRepository).findByuserNameFrom(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(message.getUserNameFrom());
    }
}