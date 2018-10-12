package com.zq.ssm.dao;

import com.zq.ssm.model.Runbike;

public interface RunbikeMapper {
    int deleteByPrimaryKey(Integer runBikeId);

    int insert(Runbike record);

    int insertSelective(Runbike record);

    int insertSelectiveBackId(Runbike runbike);

    int insertBackId(Runbike runbike);

    Runbike selectByPrimaryKey(Integer runBikeId);

    int updateByPrimaryKeySelective(Runbike record);

    int updateByPrimaryKey(Runbike record);
}