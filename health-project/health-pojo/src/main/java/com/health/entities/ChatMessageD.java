package com.health.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.entities
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageD {
    private MessageType type;
    private String content;
    private String sender;
    private LocalDateTime timestamp;

    public enum MessageType {
        JOIN, LEAVE, CHAT
    }

}