package com.zq.ssm.model;

public class Finance {
    private String moneyId;

    private String moneyDate;

    private Float moneyExpend;

    private Float moneyIncome;

    private Float moneySurplus;

    private Integer managerId;

    public String getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(String moneyId) {
        this.moneyId = moneyId;
    }

    public String getMoneyDate() {
        return moneyDate;
    }

    public void setMoneyDate(String moneyDate) {
        this.moneyDate = moneyDate == null ? null : moneyDate.trim();
    }

    public Float getMoneyExpend() {
        return moneyExpend;
    }

    public void setMoneyExpend(Float moneyExpend) {
        this.moneyExpend = moneyExpend;
    }

    public Float getMoneyIncome() {
        return moneyIncome;
    }

    public void setMoneyIncome(Float moneyIncome) {
        this.moneyIncome = moneyIncome;
    }

    public Float getMoneySurplus() {
        return moneySurplus;
    }

    public void setMoneySurplus(Float moneySurplus) {
        this.moneySurplus = moneySurplus;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}