package com.zq.ssm.model;

import java.util.Date;

public class Bikewei {
    private Integer bikeWeiId;

    private Integer bikeId;

    private Date weiDate;

    private Integer weiId;

    private String weiName;

    public Integer getBikeWeiId() {
        return bikeWeiId;
    }

    public void setBikeWeiId(Integer bikeWeiId) {
        this.bikeWeiId = bikeWeiId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Date getWeiDate() {
        return weiDate;
    }

    public void setWeiDate(Date weiDate) {
        this.weiDate = weiDate;
    }

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
}