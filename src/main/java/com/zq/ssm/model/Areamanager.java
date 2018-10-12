package com.zq.ssm.model;

public class Areamanager {
    private Integer managerId;

    private Integer areaId;

    private String areaName;

    private String managerName;

    private String managerSex;

    private Integer managerAge;

    private String managerTel;

    private String managerpassword;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerSex() {
        return managerSex;
    }

    public void setManagerSex(String managerSex) {
        this.managerSex = managerSex == null ? null : managerSex.trim();
    }

    public Integer getManagerAge() {
        return managerAge;
    }

    public void setManagerAge(Integer managerAge) {
        this.managerAge = managerAge;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel == null ? null : managerTel.trim();
    }

    public String getManagerpassword() {
        return managerpassword;
    }

    public void setManagerpassword(String managerpassword) {
        this.managerpassword = managerpassword == null ? null : managerpassword.trim();
    }

    @Override
    public String toString() {
        return "Areamanager{" +
                "managerId=" + managerId +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerSex='" + managerSex + '\'' +
                ", managerAge=" + managerAge +
                ", managerTel='" + managerTel + '\'' +
                ", managerpassword='" + managerpassword + '\'' +
                '}';
    }
}