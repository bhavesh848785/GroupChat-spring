package com.example.charappspring.controllers;

import com.example.charappspring.entities.ChatRoomEntity;
import com.example.charappspring.repositories.ChatRoomRepository;
import com.example.charappspring.services.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService, ChatRoomRepository chatRoomRepository) {
        this.chatRoomService = chatRoomService;
        this.chatRoomRepository = chatRoomRepository;
    }

    @GetMapping("/group/{groupId}")
    public List<ChatRoomEntity> getChatRoomsByGroupId(@PathVariable Long groupId) {
        return chatRoomService.getChatRoomsByGroupId(groupId);
    }
}

