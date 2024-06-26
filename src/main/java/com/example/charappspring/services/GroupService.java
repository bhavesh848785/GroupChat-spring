package com.example.charappspring.services;

import com.example.charappspring.entities.GroupEntity;
import com.example.charappspring.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupEntity> getAllGroups() {
        return groupRepository.findAll();
    }

    public GroupEntity saveGroup(GroupEntity group) {
        return groupRepository.save(group);
    }

}
