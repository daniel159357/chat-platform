package com.example.chatplatform.websocket;

import com.example.chatplatform.model.Message;
import com.example.chatplatform.repository.MessageRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessions = new ArrayList<>();
    private final MessageRepository messageRepository;

    public ChatWebSocketHandler(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        session.sendMessage(new TextMessage("Connected to chat!"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        String[] parts = payload.split(":", 2);
        String sender = parts.length > 1 ? parts[0] : "Anonymous";
        String content = parts.length > 1 ? parts[1] : payload;

        // Save message to database
        Message chatMessage = new Message();
        chatMessage.setSender(sender);
        chatMessage.setContent(content);
        chatMessage.setTimestamp(LocalDateTime.now());
        messageRepository.save(chatMessage);

        // Broadcast to all connected users
        String broadcastMessage = sender + ": " + content;
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(new TextMessage(broadcastMessage));
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }
}
