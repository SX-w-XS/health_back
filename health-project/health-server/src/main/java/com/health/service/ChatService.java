package com.health.service;

import com.health.entities.ChatMessage;
import com.health.entities.ChatMessageD;

import java.util.List;

public interface ChatService {

    public List<ChatMessage> getRecentMessages(int limit);

    void saveAndSendMessage(ChatMessageD message);
}
