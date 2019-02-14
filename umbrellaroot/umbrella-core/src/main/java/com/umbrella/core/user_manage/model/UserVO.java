package com.umbrella.core.user_manage.model;

import java.io.Serializable;

/**
 * @program: com.umbrella.armsmerchant.user_manage.model
 * @description:用户表
 * @author: liujinghui
 * @create: 2018-11-18 21:28
 **/
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userMobile;
    private String userStatus;
    private long userCreateTime;
    private String userSalt;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public long getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(long userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userCreateTime=" + userCreateTime +
                ", userSalt='" + userSalt + '\'' +
                '}';
    }
}
