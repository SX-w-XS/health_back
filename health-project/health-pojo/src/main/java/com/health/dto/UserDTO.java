package com.health.dto;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 表名：h_user
 * 表注释：用户表
 */
@Getter
@Table(name = "h_user")
public class UserDTO {
    /**
     * 用户ID
     * -- GETTER --
     *  获取用户ID
     *
     * @return userId - 用户ID

     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户昵称
     * -- GETTER --
     *  获取用户昵称
     *
     * @return nickname - 用户昵称

     */
    private String nickname;

    /**
     * 用户头像
     * -- GETTER --
     *  获取用户头像
     *
     * @return userImg - 用户头像

     */
    @Column(name = "user_img")
    private String userImg;

    /**
     * 密码
     * -- GETTER --
     *  获取密码
     *
     * @return password - 密码

     */
    private String password;

    /**
     * 用户身份证号
     * -- GETTER --
     *  获取用户身份证号
     *
     * @return userNumber - 用户身份证号

     */
    @Column(name = "user_number")
    private Integer userNumber;

    /**
     * 身份
     * -- GETTER --
     *  获取身份
     *
     * @return role - 身份

     */
    private Integer role;

    /**
     * 邮箱
     * -- GETTER --
     *  获取邮箱
     *
     * @return email - 邮箱

     */
    private String email;

    /**
     * 电话号码
     * -- GETTER --
     *  获取电话号码
     *
     * @return phone - 电话号码

     */
    private Integer phone;

    /**
     * 注册日期
     * -- GETTER --
     *  获取注册日期
     *
     * @return registrationDate - 注册日期

     */
    @Column(name = "registration_date")
    private Date registrationDate;

    /**
     * 用户姓名
     * -- GETTER --
     *  获取用户姓名
     *
     * @return username - 用户姓名

     */
    private String username;

    /**
     * 用户性别
     * -- GETTER --
     *  获取用户性别
     *
     * @return userSex - 用户性别

     */
    @Column(name = "user_sex")
    private Integer userSex;

    /**
     * 用户年龄
     * -- GETTER --
     *  获取用户年龄
     *
     * @return userAge - 用户年龄

     */
    @Column(name = "user_age")
    private Integer userAge;

    /**
     * 用户状态
     * -- GETTER --
     *  获取用户状态
     *
     * @return status - 用户状态

     */
    private Integer status;

    /**
     * -- GETTER --
     *
     * @return diseaseId
     */
    @Column(name = "disease_id")
    private Integer diseaseId;

    /**
     * -- GETTER --
     *
     * @return doctorId
     */
    @Column(name = "doctor_id")
    private String doctorId;

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 设置用户头像
     *
     * @param userImg 用户头像
     */
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 设置用户身份证号
     *
     * @param userNumber 用户身份证号
     */
    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * 设置身份
     *
     * @param role 身份
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * 设置注册日期
     *
     * @param registrationDate 注册日期
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * 设置用户姓名
     *
     * @param username 用户姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 设置用户性别
     *
     * @param userSex 用户性别
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 设置用户年龄
     *
     * @param userAge 用户年龄
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * 设置用户状态
     *
     * @param status 用户状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @param diseaseId
     */
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * @param doctorId
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}