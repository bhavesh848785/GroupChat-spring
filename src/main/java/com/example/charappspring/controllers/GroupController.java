package com.example.charappspring.controllers;

import com.example.charappspring.entities.ChatRoomEntity;
import com.example.charappspring.entities.GroupEntity;
import com.example.charappspring.repositories.ChatRoomRepository;
import com.example.charappspring.services.ChatRoomService;
import com.example.charappspring.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import java.security.SecureRandom;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomService chatRoomService;

    public static String generateRandomHash(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder hash = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            hash.append(characters.charAt(randomIndex));
        }
        return hash.toString();
    }

    @Autowired
    public GroupController(GroupService groupService, ChatRoomRepository chatRoomRepository, ChatRoomService chatRoomService) {
        this.groupService = groupService;
        this.chatRoomRepository = chatRoomRepository;
        this.chatRoomService = chatRoomService;
    }

    @GetMapping
    public List<GroupEntity> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping
    public GroupEntity createGroup(@RequestBody GroupEntity group) {

        ChatRoomEntity chatRoom = new ChatRoomEntity();
        GroupEntity groupSaved = groupService.saveGroup(group);
        Long groupId = group.getId();
        chatRoom.setGroupId(groupId);
        chatRoom.setRoom_id(generateRandomHash(30));
        chatRoom = chatRoomService.saveChatRoom(chatRoom);
        return groupSaved;
    }

}
