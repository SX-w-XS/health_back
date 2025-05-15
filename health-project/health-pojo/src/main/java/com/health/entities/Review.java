package com.health.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "id")
    private Integer id;

    @Size(max = 400)
    @Column(name = "content", length = 400)
    private String content;

    @Size(max = 300)
    @NotNull
    @Column(name = "title", nullable = false, length = 300)
    private String title;

    @NotNull
    @Column(name = "status", nullable = false)
    private Integer status;

    @Size(max = 300)
    @Column(name = "note", length = 300)
    private String note;

    @Size(max = 100)
    @Column(name = "img", length = 100)
    private String img;

    @NotNull
    @Column(name = "create_time", nullable = false)
    private String createTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "filer_id")
    private Integer filerId;
}