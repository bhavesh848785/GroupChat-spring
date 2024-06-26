package com.example.charappspring.controllers;

import com.example.charappspring.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @MessageMapping("/message/{roomId}")
    @SendTo("/topic/return-to/{roomId}")
    public Message getContent(@RequestBody Message message) {
        return message;
    }
}
