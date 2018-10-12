package com.zq.ssm.dao;

import com.zq.ssm.model.Bikewei;

public interface BikeweiMapper {
    int deleteByPrimaryKey(Integer bikeWeiId);

    int insert(Bikewei record);

    int insertSelective(Bikewei record);

    Bikewei selectByPrimaryKey(Integer bikeWeiId);

    int updateByPrimaryKeySelective(Bikewei record);

    int updateByPrimaryKey(Bikewei record);
}