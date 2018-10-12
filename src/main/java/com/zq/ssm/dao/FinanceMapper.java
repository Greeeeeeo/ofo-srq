package com.zq.ssm.dao;

import com.zq.ssm.model.Finance;

import java.util.List;

public interface FinanceMapper {
    int deleteByPrimaryKey(String moneyId);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(String moneyId);
    List<Finance>  selectByPrimaryKeyAndMohu(String moneyId);
    List<Finance> selectallfinance();
    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);


}