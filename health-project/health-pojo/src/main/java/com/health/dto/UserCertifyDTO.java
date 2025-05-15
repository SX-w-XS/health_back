package com.health.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCertifyDTO implements Serializable{
    private String filer_id;
    private String title;
    private String content;
    private String createTime;
    private String img;
}
