package com.edu.springboot.bittertwitter.service;

import com.edu.springboot.bittertwitter.entity.Message;
import com.edu.springboot.bittertwitter.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    public Message save(Message message){
        return messageRepo.save(message);
    }

    public Iterable<Message> findAll(){
        return messageRepo.findAll();
    }
}
