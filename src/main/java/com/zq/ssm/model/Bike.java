package com.zq.ssm.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Bike {
    private Integer bikeId;

    private String bikeAddress;


    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date bikeTime;

    private String bikeState;

    private String two;

    private String openPsw;

    private Integer managerId;

    private Double bikeRow;

    private Double bikeCol;

    //负责人管理员
    private Areamanager areaManager;

    @Override
    public String toString() {
        return "Bike{" +
                "bikeId=" + bikeId +
                ", bikeAddress='" + bikeAddress + '\'' +
                ", bikeTime=" + bikeTime +
                ", bikeState='" + bikeState + '\'' +
                ", two='" + two + '\'' +
                ", openPsw='" + openPsw + '\'' +
                ", managerId=" + managerId +
                ", bikeRow=" + bikeRow +
                ", bikeCol=" + bikeCol +
                ", areaManager=" + areaManager +
                '}';
    }

    public Areamanager getAreaManager() {
        return areaManager;
    }

    public void setAreaManager(Areamanager areaManager) {
        this.areaManager = areaManager;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeAddress() {
        return bikeAddress;
    }

    public void setBikeAddress(String bikeAddress) {
        this.bikeAddress = bikeAddress == null ? null : bikeAddress.trim();
    }

    public Date getBikeTime() {
        return bikeTime;
    }

    public void setBikeTime(Date bikeTime) {
        this.bikeTime = bikeTime;
    }

    public String getBikeState() {
        return bikeState;
    }

    public void setBikeState(String bikeState) {
        this.bikeState = bikeState == null ? null : bikeState.trim();
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two == null ? null : two.trim();
    }

    public String getOpenPsw() {
        return openPsw;
    }

    public void setOpenPsw(String openPsw) {
        this.openPsw = openPsw == null ? null : openPsw.trim();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Double getBikeRow() {
        return bikeRow;
    }

    public void setBikeRow(Double bikeRow) {
        this.bikeRow = bikeRow;
    }

    public Double getBikeCol() {
        return bikeCol;
    }

    public void setBikeCol(Double bikeCol) {
        this.bikeCol = bikeCol;
    }
}