package com.health.websocket;

import com.health.entities.ChatMessage;
import com.health.entities.ChatMessageD;
import com.health.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * WebSocket服务
 */
@Controller
public class WebSocketChatController  {


    @Autowired
    private ChatService chatService;
    @MessageMapping("/chat.sendMessage")
    public void handleChatMessage(ChatMessageD message) {
        // 消息处理由ChatService完成
        chatService.saveAndSendMessage(message);
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/users")
    public ChatMessageD addUser(@Payload ChatMessageD message) {
        message.setType(ChatMessageD.MessageType.JOIN);
        message.setContent(message.getSender() + " 加入了聊天室!");
        return message;
    }
}
