package com.health.entities;

import javax.persistence.*;

/**
 * 表名：message
 * 表注释：新闻
*/
@Table(name = "message")
public class Message {
    /**
     * ID
     */
    @Id
    @Column(name = "MESSAGE_ID")
    private Integer messageId;

    /**
     * 标题
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 跳转url
     */
    @Column(name = "URL")
    private String url;

    /**
     * 类型
     */
    @Column(name = "KIND")
    private Integer kind;

    /**
     * 内容
     */
    @Column(name = "CONTENT")
    private String content;

    /**
     * 获取ID
     *
     * @return messageId - ID
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * 设置ID
     *
     * @param messageId ID
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取跳转url
     *
     * @return url - 跳转url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置跳转url
     *
     * @param url 跳转url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取类型
     *
     * @return kind - 类型
     */
    public Integer getKind() {
        return kind;
    }

    /**
     * 设置类型
     *
     * @param kind 类型
     */
    public void setKind(Integer kind) {
        this.kind = kind;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}