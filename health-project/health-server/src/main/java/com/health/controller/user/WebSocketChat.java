package com.health.controller.user;

import com.alibaba.fastjson.JSON;
import com.health.config.GetHttpSession;
import com.health.entities.ChatMessage;
import com.health.entities.ChatMessageD;
import com.health.service.ChatService;
import com.health.utils.MessageUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.controller.user
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@ServerEndpoint(value = "/chat",configurator = GetHttpSession.class)
@Component
public class WebSocketChat {
    private  static  final Map<String,Session> onlineUsers =new ConcurrentHashMap<>();
    private  HttpSession httpSession;

    @Resource
    ChatService chatService;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config)    {
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        String nickname = (String) httpSession.getAttribute("nickname");
        onlineUsers.put(nickname,session);

        String message = MessageUtils.getMessage(true, null, getAllOnlineUser());
        broadcastAllUser(message);
    }

    private Set getAllOnlineUser() {
        return onlineUsers.keySet();
    }

    private  void broadcastAllUser(String message){
        for (Map.Entry<String,Session> entry : onlineUsers.entrySet()) {
            try {
                entry.getValue().getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @OnMessage
    public void onMessage(String message)  {
        ChatMessage chatMessage= JSON.parseObject(message, ChatMessage.class);
        String sender = chatMessage.getSender();
        String content = chatMessage.getContent();
        String nickname = (String) httpSession.getAttribute("nickname");
        Session session = onlineUsers.get(sender);

        try {
            session.getBasicRemote().sendText(MessageUtils.getMessage(false, nickname, content));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ChatMessageD chatMessageD = new ChatMessageD();
        BeanUtils.copyProperties(chatMessage,chatMessageD);
        chatService.saveAndSendMessage(chatMessageD);
    }

    @OnClose
    public void onClose(Session session)  {
        String nickname = (String) httpSession.getAttribute("nickname");
        onlineUsers.remove(nickname);
        String message = MessageUtils.getMessage(true, nickname, getAllOnlineUser());
        broadcastAllUser(message);
    }

    }
