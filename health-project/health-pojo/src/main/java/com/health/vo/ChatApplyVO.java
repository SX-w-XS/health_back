package com.health.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class ChatApplyVO {
    private Integer chatId;
    private Integer applyId;
    private Integer recevieId;
    private String content;
    private Integer status;
    private String img;
    private String bickname;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBickname() {
        return bickname;
    }

    public void setBickname(String bickname) {
        this.bickname = bickname;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getRecevieId() {
        return recevieId;
    }

    public void setRecevieId(Integer recevieId) {
        this.recevieId = recevieId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }
}
