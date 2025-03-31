package com.health.service;

import com.health.entities.ChatMessage;

import java.util.List;

public interface ChatService {

    public List<ChatMessage> getRecentMessages(int limit);

    void saveAndSendMessage(ChatMessage message);
}
