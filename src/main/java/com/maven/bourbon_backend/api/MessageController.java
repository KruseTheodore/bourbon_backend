package com.maven.bourbon_backend.api;

import com.maven.bourbon_backend.model.Message;
import com.maven.bourbon_backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("BourbonCommunityReviews/message")
@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public void addMessage(@RequestBody Message message){
        messageService.addMessage(message);
    }

    @GetMapping(path = "{usernameto}")
    public List<Message> getMessagesUserTo(@PathVariable("usernameto")String name){
        return messageService.getMessagesByUserTo(name);
    }

    @GetMapping(path = "{usernameto}/{usernamefrom}")
    public List<Message> getConversation(@PathVariable("usernameto")String usernameto, @PathVariable("usernamefrom")String usernamefrom){
        List<Message> toRemove = new ArrayList<>();
        List<Message> conversationTo = messageService.getMessagesByUserTo(usernameto);
        conversationTo.forEach(message -> {
            if (!message.getUserNameFrom().equals(usernamefrom)){
                toRemove.add(message);
            }
        });

        conversationTo.removeAll(toRemove);
        toRemove.clear();

        List<Message> conversationFrom = messageService.getMessagesByUserTo(usernamefrom);
        conversationFrom.forEach(message -> {
            if (!message.getUserNameFrom().equals(usernameto)){
                toRemove.add(message);
            }
        });
        conversationFrom.removeAll(toRemove);

        conversationFrom.addAll(conversationTo);

        return conversationFrom;
    }

}
