package com.zq.ssm.model;

import java.util.Date;



public class Runbike {

    private Bike bike;

    private Areamanager areamanager;

    private Integer runBikeId;

    private Integer bikeId;

    private Integer userId;

    private String userName;

    private String runAddressStart;

    private String runAddressEnd;

    private Date runTimeStart;

    private Date runTimeEnd;
    /**
     * 支付金额
     */
    private Float runPay;
    /**
     * 是否支付
     */
    private Boolean orpay;

    public Integer getRunBikeId() {
        return runBikeId;
    }

    public void setRunBikeId(Integer runBikeId) {
        this.runBikeId = runBikeId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
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

    public String getRunAddressStart() {
        return runAddressStart;
    }

    public void setRunAddressStart(String runAddressStart) {
        this.runAddressStart = runAddressStart == null ? null : runAddressStart.trim();
    }

    public String getRunAddressEnd() {
        return runAddressEnd;
    }

    public void setRunAddressEnd(String runAddressEnd) {
        this.runAddressEnd = runAddressEnd == null ? null : runAddressEnd.trim();
    }

    public Date getRunTimeStart() {
        return runTimeStart;
    }

    public void setRunTimeStart(Date runTimeStart) {
        this.runTimeStart = runTimeStart;
    }

    public Date getRunTimeEnd() {
        return runTimeEnd;
    }

    public void setRunTimeEnd(Date runTimeEnd) {
        this.runTimeEnd = runTimeEnd;
    }

    public Float getRunPay() {
        return runPay;
    }

    public void setRunPay(Float runPay) {
        this.runPay = runPay;
    }

    public Boolean getOrpay() {
        return orpay;
    }

    public void setOrpay(Boolean orpay) {
        this.orpay = orpay;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return "Runbike{" +
                "bike=" + bike +
                ", areamanager=" + areamanager +
                ", runBikeId=" + runBikeId +
                ", bikeId=" + bikeId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", runAddressStart='" + runAddressStart + '\'' +
                ", runAddressEnd='" + runAddressEnd + '\'' +
                ", runTimeStart=" + runTimeStart +
                ", runTimeEnd=" + runTimeEnd +
                ", runPay=" + runPay +
                ", orpay=" + orpay +
                '}';
    }

    public Areamanager getAreamanager() {
        return areamanager;
    }

    public void setAreamanager(Areamanager areamanager) {
        this.areamanager = areamanager;
    }

}