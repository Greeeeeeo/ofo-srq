package com.zq.ssm.dao;

import com.zq.ssm.model.Bikepoint;

import java.util.List;

public interface BikepointMapper {
    int deleteByPrimaryKey(Integer bikepointId);

    int insert(Bikepoint record);

    int insertSelective(Bikepoint record);

    Bikepoint selectByPrimaryKey(Integer bikepointId);

    int updateByPrimaryKeySelective(Bikepoint record);

    int updateByPrimaryKey(Bikepoint record);

    List<Bikepoint> selectAllBikepoint();
}