package com.example.issamhamamid.demo.jwtsecurity.message;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessagesController {
    private MessagesRepository messagesRepository;
    public MessagesController(MessagesRepository messagesRepository){
        this.messagesRepository = messagesRepository;
    }

    @GetMapping("/messages")
    public List<Message> showMessages() {
        List<Message> messages = messagesRepository.findAll();
        return messages;
    }


    @PostMapping("/messages")
    public void addUser(@RequestBody Message message) {
        messagesRepository.save(message);

    }


    @DeleteMapping("/messages")
    public void clear(){
        messagesRepository.deleteAll();
    }





}
