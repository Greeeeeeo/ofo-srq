package com.zq.ssm.service;

import com.zq.ssm.model.Bike;

import java.util.List;

public interface BikeService {

    int updateBike(Bike bike);

    List<Bike> selectAllBike();

    List<Bike> selectBikeByState(Bike  bike);

    int deleteBike(int id);


}
