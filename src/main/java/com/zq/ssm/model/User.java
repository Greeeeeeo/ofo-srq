package com.zq.ssm.model;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userPurse;

    private String userWeal;

    private String userConfirm;

    private Integer userCredit;

    private Float bond;

    private String userSex;

    private Integer userAge;

    private String userPhone;

    private Date register;

    private String userPortrait;

    //邮箱验证码
    private String registCode;


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPurse=" + userPurse +
                ", userWeal='" + userWeal + '\'' +
                ", userConfirm='" + userConfirm + '\'' +
                ", userCredit=" + userCredit +
                ", bond=" + bond +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userPhone='" + userPhone + '\'' +
                ", register=" + register +
                ", userPortrait='" + userPortrait + '\'' +
                ", registCode='" + registCode + '\'' +
                '}';
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserPurse() {
        return userPurse;
    }

    public void setUserPurse(Integer userPurse) {
        this.userPurse = userPurse;
    }

    public String getUserWeal() {
        return userWeal;
    }

    public void setUserWeal(String userWeal) {
        this.userWeal = userWeal == null ? null : userWeal.trim();
    }

    public String getUserConfirm() {
        return userConfirm;
    }

    public void setUserConfirm(String userConfirm) {
        this.userConfirm = userConfirm == null ? null : userConfirm.trim();
    }

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }

    public Float getBond() {
        return bond;
    }

    public void setBond(Float bond) {
        this.bond = bond;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait == null ? null : userPortrait.trim();
    }
}