//package com.health.controller.user;
//
//import com.alibaba.fastjson.JSON;
//import com.health.config.GetHttpSession;
//import com.health.entities.ChatMessage;
//import com.health.entities.ChatMessageD;
//import com.health.service.ChatService;
//import com.health.utils.MessageUtils;
//import io.swagger.annotations.Api;
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @BelongsProject: sky_test
// * @BelongsPackage: com.health.controller.user
// * @Author: X_X
// * @Description: TODO
// * @Version: 1.0
// */
//@ServerEndpoint(value = "/chat",configurator = GetHttpSession.class)
//@Component
//public class WebSocketChat {
//    private  static  final Map<Integer,Session> onlineUsers =new ConcurrentHashMap<>();
//    private  HttpSession httpSession;
//
//    @Resource
//    ChatService chatService;
//
//    @OnOpen
//    public void onOpen(Session session, EndpointConfig config)    {
//        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        Integer userId = (Integer) httpSession.getAttribute("userId");
//        onlineUsers.put(userId,session);
//
//        String message = MessageUtils.getMessage(true, null, getAllOnlineUser());
//        broadcastAllUser(message);
//    }
//
//    private Set getAllOnlineUser() {
//        return onlineUsers.keySet();
//    }
//
//    private  void broadcastAllUser(String message){
//        for (Map.Entry<Integer,Session> entry : onlineUsers.entrySet()) {
//            try {
//                entry.getValue().getBasicRemote().sendText(message);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    @OnMessage
//    public void onMessage(String message)  {
//        ChatMessage chatMessage= JSON.parseObject(message, ChatMessage.class);
//        String sender = chatMessage.getSender();
//        String content = chatMessage.getContent();
//        Integer userId = (Integer) httpSession.getAttribute("userId");
//        Session session = onlineUsers.get(sender);
//
//        try {
//            session.getBasicRemote().sendText(MessageUtils.getMessage(false, userId, content));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        /*ChatMessageD chatMessageD = new ChatMessageD();
//        BeanUtils.copyProperties(chatMessage,chatMessageD);
//        chatService.saveAndSendMessage(chatMessageD);*/
//    }
//
//    @OnClose
//    public void onClose(Session session)  {
//        Integer userId = (Integer) httpSession.getAttribute("userId");
//        onlineUsers.remove(userId);
//        String message = MessageUtils.getMessage(true, userId, getAllOnlineUser());
//        broadcastAllUser(message);
//    }
//
//    }

package com.health.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.health.config.GetHttpSession;
import com.health.entities.ChatMessage;
import com.health.entities.ChatMessageD;
import com.health.service.ChatService;
import com.health.utils.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * WebSocket聊天控制器（修复依赖注入问题）
 */
@Slf4j
@ServerEndpoint(value = "/chat", configurator = GetHttpSession.class)
@Component
public class WebSocketChat implements ApplicationContextAware {
    private static final Logger LOGGER = Logger.getLogger(WebSocketChat.class.getName());
    private static final Map<Integer, Session> onlineUsers = new ConcurrentHashMap<>();
    private HttpSession httpSession;
    private Integer currentUserId;
    private static ApplicationContext applicationContext; // 用于手动获取Spring Bean

    // 移除@Resource注解，通过Spring上下文获取ChatService
    private ChatService chatService;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        try {
            this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
            this.currentUserId = (Integer) httpSession.getAttribute("userId");

            if (currentUserId == null) {
                LOGGER.warning("用户未登录，关闭WebSocket连接");
                session.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "未登录"));
                return;
            }

            onlineUsers.put(currentUserId, session);
            LOGGER.info("用户ID " + currentUserId + " 已连接");
            String message = MessageUtils.getMessage(true, null, getAllOnlineUser());
            broadcastAllUser(message);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "WebSocket连接建立失败", e);
            try {
                if (session != null && session.isOpen()) {
                    session.close(new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, "内部错误"));
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "关闭会话失败", ex);
            }
        }
    }

    private Set<Integer> getAllOnlineUser() {
        return onlineUsers.keySet();
    }

    private void broadcastAllUser(String message) {
        for (Map.Entry<Integer, Session> entry : onlineUsers.entrySet()) {
            Session recipient = entry.getValue();
//            if (recipient != null && recipient.isOpen()) {
//                try {
////                    recipient.getBasicRemote().sendText(message);
//                } catch (IOException e) {
//                    LOGGER.log(Level.WARNING, "向用户ID " + entry.getKey() + " 发送消息失败", e);
//                    onlineUsers.remove(entry.getKey());
//                }
//            }
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // 检查会话有效性
        if (session == null || !session.isOpen()) {
            LOGGER.warning("无效会话，忽略消息");
            return;
        }

        // 检查用户ID
        if (currentUserId == null) {
            LOGGER.warning("用户ID为空，无法处理消息");
            try {
                session.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "未认证"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "关闭会话失败", e);
            }
            return;
        }

        try {
            // 解析消息
            ChatMessage chatMessage = JSON.parseObject(message, ChatMessage.class);

            // 获取接收者ID（关键修正：假设消息中的接收者字段为receiverId，而非sender）
            Integer receiverId = chatMessage.getSender(); // 原代码错误使用sender，此处应改为接收者ID
            log.info("接收者ID: " + receiverId);
            if (receiverId == null) {
                LOGGER.warning("消息缺少接收者ID: " + message);
                return;
            }

            // 从Spring上下文获取ChatService（解决NullPointerException的关键）
            if (chatService == null) {
                chatService = applicationContext.getBean(ChatService.class);
            }
            // 保存消息到数据库
            saveChatMessage(chatMessage, receiverId);

            // 检查接收者是否在线
            Session receiverSession = onlineUsers.get(receiverId);
//            log.info("session:{}",session);
//            log.info("receiverSession:{}",receiverSession);
            if (receiverSession != null && receiverSession.isOpen()) {
                // 接收者在线，实时推送消息
                String response = MessageUtils.getMessage(false, chatMessage.getId(), chatMessage);
                receiverSession.getBasicRemote().sendText(response);
                LOGGER.info("消息从用户ID " + currentUserId + " 发送到用户ID " + receiverId);

                // 通知发送者消息已送达
//                session.getBasicRemote().sendText(
//                        MessageUtils.getMessage(false, null, "消息已送达")
//                );
            } else {
                // 接收者不在线，通知发送者
                LOGGER.info("用户ID " + receiverId + " 不在线，消息已保存");
//                session.getBasicRemote().sendText(
//                        MessageUtils.getMessage(false, null, "对方不在线，消息已保存")
//                );
            }
        } catch (JSONException e) {
            LOGGER.log(Level.SEVERE, "JSON解析错误: " + message, e);
            try {
                session.getBasicRemote().sendText(
                        MessageUtils.getMessage(false, null, "消息格式错误: " + e.getMessage())
                );
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "发送错误响应失败", ex);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "处理消息失败: " + message, e);
            try {
                session.getBasicRemote().sendText(
                        MessageUtils.getMessage(false, null, "处理消息失败: " + e.getMessage())
                );
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "发送错误响应失败", ex);
            }
        }
    }

    private void saveChatMessage(ChatMessage chatMessage, Integer receiverId) {
        try {
            ChatMessageD chatMessageD = new ChatMessageD();
            BeanUtils.copyProperties(chatMessage, chatMessageD);

            // 设置接收者ID和消息状态
//            chatMessageD.setSender(receiverId); // 明确接收者ID
            boolean isOnline = onlineUsers.containsKey(receiverId);
//            chatMessageD.setStatus(isOnline ? "已送达" : "未读");

            // 此处chatService通过Spring上下文获取，不再为null
            chatService.saveAndSendMessage(chatMessage);
            LOGGER.info("消息已保存到数据库: " + chatMessage.getContent());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "保存消息失败", e);
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        if (currentUserId != null) {
            onlineUsers.remove(currentUserId);
            LOGGER.info("用户ID " + currentUserId + " 已断开连接，原因: " + reason.getReasonPhrase());

            String message = MessageUtils.getMessage(true, currentUserId, getAllOnlineUser());
            broadcastAllUser(message);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        LOGGER.log(Level.SEVERE, "WebSocket错误: " + error.getMessage(), error);

        // 清理可能的无效会话
        if (session != null && session.isOpen()) {
            try {
                session.close(new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, "发生错误"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "关闭错误会话失败", e);
            }

            // 从在线用户中移除
            if (currentUserId != null) {
                onlineUsers.remove(currentUserId);
            }
        }
    }
}
