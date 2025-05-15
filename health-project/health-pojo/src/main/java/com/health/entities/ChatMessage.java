package com.health.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 表名：chat_message
 * 表注释：聊天表
*/
@Table(name = "chat_message")
public class ChatMessage {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

//    private String type;

    private Integer sender;


    private String content;


    private String timestamp;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return type
     */
//    public String getType() {
//        return type;
//    }
//
//    /**
//     * @param type
//     */
//    public void setType(String type) {
//        this.type = type;
//    }

    /**
     * @return sender
     */
    public Integer getSender() {
        return sender;
    }

    /**
     * @param sender
     */
    public void setSender(Integer sender) {
        this.sender = sender;
    }

    /**
     * @return timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}