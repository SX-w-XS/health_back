package com.health.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "conversation")
public class ChatApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id", nullable = false)
    private Integer id;

    @Column(name = "apply_id")
    private Integer applyId;

    @Column(name = "recevie_id")
    private Integer recevieId;

    @Size(max = 300)
    @Column(name = "content", length = 300)
    private String content;

    @Size(max = 100)
    @Column(name = "create_time", length = 100)
    private String createTime;

    @Column(name = "status")
    private Integer status;

}
