package com.zq.ssm.model;

import java.util.Date;

public class Weipeople {
    private Integer weiId;

    private String weiName;

    private String weiSex;

    private Integer weiAge;

    private String weiTel;

    private String weiPassword;

    private String weiState;

    private Integer managerId;

    private String weiConfirm;

    private String weiConfirm1;

    private Date weiDate;

    public Integer getWeiId() {
        return weiId;
    }

    public void setWeiId(Integer weiId) {
        this.weiId = weiId;
    }

    public String getWeiName() {
        return weiName;
    }

    public void setWeiName(String weiName) {
        this.weiName = weiName == null ? null : weiName.trim();
    }

    public String getWeiSex() {
        return weiSex;
    }

    public void setWeiSex(String weiSex) {
        this.weiSex = weiSex == null ? null : weiSex.trim();
    }

    public Integer getWeiAge() {
        return weiAge;
    }

    public void setWeiAge(Integer weiAge) {
        this.weiAge = weiAge;
    }

    public String getWeiTel() {
        return weiTel;
    }

    public void setWeiTel(String weiTel) {
        this.weiTel = weiTel == null ? null : weiTel.trim();
    }

    public String getWeiPassword() {
        return weiPassword;
    }

    public void setWeiPassword(String weiPassword) {
        this.weiPassword = weiPassword == null ? null : weiPassword.trim();
    }

    public String getWeiState() {
        return weiState;
    }

    public void setWeiState(String weiState) {
        this.weiState = weiState == null ? null : weiState.trim();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getWeiConfirm() {
        return weiConfirm;
    }

    public void setWeiConfirm(String weiConfirm) {
        this.weiConfirm = weiConfirm == null ? null : weiConfirm.trim();
    }

    public String getWeiConfirm1() {
        return weiConfirm1;
    }

    public void setWeiConfirm1(String weiConfirm1) {
        this.weiConfirm1 = weiConfirm1 == null ? null : weiConfirm1.trim();
    }

    public Date getWeiDate() {
        return weiDate;
    }

    public void setWeiDate(Date weiDate) {
        this.weiDate = weiDate;
    }
}