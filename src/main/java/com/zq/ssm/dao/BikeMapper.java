package com.zq.ssm.dao;

import com.zq.ssm.model.Bike;
import com.zq.ssm.model.Black;

import java.util.List;

public interface BikeMapper {
    int deleteByPrimaryKey(Integer bikeId);

    int insert(Bike record);

    int insertSelective(Bike record);

    Bike selectByPrimaryKey(Integer bikeId);

    List<Bike> selectAllBike();

    List<Bike> selectBikeByState(Bike bike);


    int updateByPrimaryKeySelective(Bike record);

    int updateByPrimaryKey(Bike record);
}