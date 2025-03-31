package com.health.service.impl;

import com.health.entities.ChatMessage;
import com.health.entities.ChatMessageD;
import com.health.mapper.ChatMessageMapper;
import com.health.service.ChatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service.impl
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    ChatMessageMapper chatMessageMapper;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @Override
    public List<ChatMessage> getRecentMessages(int limit) {
       //10条历史最新消息
        return  chatMessageMapper.selectRecentMessages(limit);

    }




    public void saveAndSendMessage(ChatMessageD message) {
        message.setTimestamp(LocalDateTime.now());
        ChatMessage chatMessage=new ChatMessage();
        BeanUtils.copyProperties(message,chatMessage);
        chatMessageMapper.insert(chatMessage);
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
