package com.zq.ssm.model;

public class Areabike {
    private Integer areaId;

    private String areaName;

    private Integer areaBikeMax;

    private Integer areaBikeMin;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Integer getAreaBikeMax() {
        return areaBikeMax;
    }

    public void setAreaBikeMax(Integer areaBikeMax) {
        this.areaBikeMax = areaBikeMax;
    }

    public Integer getAreaBikeMin() {
        return areaBikeMin;
    }

    public void setAreaBikeMin(Integer areaBikeMin) {
        this.areaBikeMin = areaBikeMin;
    }

    @Override
    public String toString() {
        return "Areabike{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", areaBikeMax=" + areaBikeMax +
                ", areaBikeMin=" + areaBikeMin +
                '}';
    }
}