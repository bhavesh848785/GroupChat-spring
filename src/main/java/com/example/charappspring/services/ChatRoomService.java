package com.example.charappspring.services;

import com.example.charappspring.entities.ChatRoomEntity;
import com.example.charappspring.entities.GroupEntity;
import com.example.charappspring.repositories.ChatRepository;
import com.example.charappspring.repositories.ChatRoomRepository;
import com.example.charappspring.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public List<ChatRoomEntity> getChatRoomsByGroupId(Long groupId) {
        return chatRoomRepository.findByGroupId(groupId);
    }

    public ChatRoomEntity saveChatRoom(ChatRoomEntity chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }
}