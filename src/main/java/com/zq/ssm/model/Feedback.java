package com.zq.ssm.model;

public class Feedback {
    private Integer remarkId;

    private Integer userId;

    private Integer bikeId;

    private Integer managerId;

    private String userName;

    private String remarkType;

    private String remark;

    private String bikePicture;

    private String userAddress;

    private String reply;

    private Integer orReply;

    @Override
    public String toString() {
        return "Feedback{" +
                "remarkId=" + remarkId +
                ", userId=" + userId +
                ", bikeId=" + bikeId +
                ", managerId=" + managerId +
                ", userName='" + userName + '\'' +
                ", remarkType='" + remarkType + '\'' +
                ", remark='" + remark + '\'' +
                ", bikePicture='" + bikePicture + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", reply='" + reply + '\'' +
                ", orReply=" + orReply +
                '}';
    }

    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRemarkType() {
        return remarkType;
    }

    public void setRemarkType(String remarkType) {
        this.remarkType = remarkType == null ? null : remarkType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBikePicture() {
        return bikePicture;
    }

    public void setBikePicture(String bikePicture) {
        this.bikePicture = bikePicture == null ? null : bikePicture.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public Integer getOrReply() {
        return orReply;
    }

    public void setOrReply(Integer orReply) {
        this.orReply = orReply;
    }
}