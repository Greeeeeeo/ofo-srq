package com.zq.ssm.model;

public class Bikepoint {
    private Integer bikepointId;

    private Integer managerId;

    private String pointName;

    private String areaName;

    private Double pointRow;

    private Double pointCol;

    public Integer getBikepointId() {
        return bikepointId;
    }

    public void setBikepointId(Integer bikepointId) {
        this.bikepointId = bikepointId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName == null ? null : pointName.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Double getPointRow() {
        return pointRow;
    }

    public void setPointRow(Double pointRow) {
        this.pointRow = pointRow;
    }

    public Double getPointCol() {
        return pointCol;
    }

    public void setPointCol(Double pointCol) {
        this.pointCol = pointCol;
    }
}