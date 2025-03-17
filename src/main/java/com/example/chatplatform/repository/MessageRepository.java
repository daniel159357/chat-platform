package com.example.chatplatform.repository;

import com.example.chatplatform.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
