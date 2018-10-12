package com.zq.ssm.model;

public class Supermanager {
    private Integer managerId;

    private String managerName;

    private String managerPassword;

    private Integer managerType;

    private String managerMark1;


    /**作为验证码
     * */
    private String maragerMark2;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword == null ? null : managerPassword.trim();
    }

    public Integer getManagerType() {
        return managerType;
    }

    public void setManagerType(Integer managerType) {
        this.managerType = managerType;
    }

    public String getManagerMark1() {
        return managerMark1;
    }

    public void setManagerMark1(String managerMark1) {
        this.managerMark1 = managerMark1 == null ? null : managerMark1.trim();
    }

    public String getMaragerMark2() {
        return maragerMark2;
    }

    public void setMaragerMark2(String maragerMark2) {
        this.maragerMark2 = maragerMark2 == null ? null : maragerMark2.trim();
    }
}