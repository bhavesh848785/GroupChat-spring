package com.example.charappspring.repositories;

import com.example.charappspring.entities.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity,Long> {
    List<ChatRoomEntity> findByGroupId(Long groupId);
}
