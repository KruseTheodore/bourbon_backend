package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.Message;
import com.maven.bourbon_backend.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;


    @Autowired
    public MessageService(@Qualifier("MongoMessage") MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }

    public void deleteMessageById(String id){
        messageRepository.deleteById(id);
    }

    public List<Message> getMessagesByUserTo(String userName){
        return messageRepository.findByuserNameTo(userName);
    }

    public List<Message> getMessagesByUserFrom(String userName){
        return messageRepository.findByuserNameFrom(userName);
    }


}
