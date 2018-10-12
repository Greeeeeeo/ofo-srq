package com.zq.ssm.model;

import java.util.Date;

public class SuperMoney {
    private Integer superMoneyId;

    private Float superMaoneyExpend;

    private Date superDate;

    private Float superMoneyIncome;

    private Float superMoneySurplus;

    public Integer getSuperMoneyId() {
        return superMoneyId;
    }

    public void setSuperMoneyId(Integer superMoneyId) {
        this.superMoneyId = superMoneyId;
    }

    public Float getSuperMaoneyExpend() {
        return superMaoneyExpend;
    }

    public void setSuperMaoneyExpend(Float superMaoneyExpend) {
        this.superMaoneyExpend = superMaoneyExpend;
    }

    public Date getSuperDate() {
        return superDate;
    }

    public void setSuperDate(Date superDate) {
        this.superDate = superDate;
    }

    public Float getSuperMoneyIncome() {
        return superMoneyIncome;
    }

    public void setSuperMoneyIncome(Float superMoneyIncome) {
        this.superMoneyIncome = superMoneyIncome;
    }

    public Float getSuperMoneySurplus() {
        return superMoneySurplus;
    }

    public void setSuperMoneySurplus(Float superMoneySurplus) {
        this.superMoneySurplus = superMoneySurplus;
    }
}