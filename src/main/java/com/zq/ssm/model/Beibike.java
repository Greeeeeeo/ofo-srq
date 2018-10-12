package com.zq.ssm.model;

public class Beibike {
    private Integer bikeId;

    private String two;

    private String openPsw;

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
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
}