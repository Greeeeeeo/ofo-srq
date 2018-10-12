package com.zq.ssm.dao;

import com.zq.ssm.model.SuperMoney;

public interface SuperMoneyMapper {
    int deleteByPrimaryKey(Integer superMoneyId);

    int insert(SuperMoney record);

    int insertSelective(SuperMoney record);

    SuperMoney selectByPrimaryKey(Integer superMoneyId);

    int updateByPrimaryKeySelective(SuperMoney record);

    int updateByPrimaryKey(SuperMoney record);
}