package com.health.service;

import com.health.entities.ChatMessage;
import com.health.entities.ChatMessageD;
import com.health.vo.ChatMessageVO;

import java.util.List;

public interface ChatService {

    public List<ChatMessage> getRecentMessages(int limit);

    void saveAndSendMessage(ChatMessage message);

    //查询是否存在对话
    boolean checkChat(Integer applyId, Integer recevieId);

    //获取所有历史消息
    public List<ChatMessageVO> getHistoryMessage(Integer sendId, Integer receiveId);
}
