package com.maven.bourbon_backend.api;

import com.maven.bourbon_backend.model.Message;
import com.maven.bourbon_backend.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    @Mock
    private MessageService messageService;
    private  MessageController underTest;

    @BeforeEach
    void setUp(){
        underTest = new MessageController(messageService);
    }
    @Test
    void canAddMessage() {
        //given
        Message message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        underTest.addMessage(message);
        //then
        ArgumentCaptor<Message> messageArgumentCaptor = ArgumentCaptor.forClass(Message.class);
        verify(messageService).addMessage(messageArgumentCaptor.capture());
        Message capturedMessage = messageArgumentCaptor.getValue();
        assertThat(capturedMessage).isEqualTo(message);
    }

    @Test
    void canGetMessagesUserTo() {
        //given
        Message message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        underTest.getMessagesUserTo(message.getUserNameTo());
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(messageService).getMessagesByUserTo(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(message.getUserNameTo());

    }

    @Test
    void getConversation() {
        //given
        Message message = new Message("testID", "user1", "user2", "Test Message.");
        //when
        underTest.getConversation(message.getUserNameTo(), message.getUserNameFrom());
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(messageService, times(2)).getMessagesByUserTo(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(message.getUserNameFrom());
    }
}