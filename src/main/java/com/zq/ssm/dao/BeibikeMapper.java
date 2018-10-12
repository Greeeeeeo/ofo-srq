package com.zq.ssm.dao;

import com.zq.ssm.model.Beibike;

public interface BeibikeMapper {
    int deleteByPrimaryKey(Integer bikeId);

    int insert(Beibike record);

    int insertSelective(Beibike record);

    Beibike selectByPrimaryKey(Integer bikeId);

    int updateByPrimaryKeySelective(Beibike record);

    int updateByPrimaryKey(Beibike record);
}