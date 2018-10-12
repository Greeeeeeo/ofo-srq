package com.zq.ssm.service.serviceimpl;

import com.zq.ssm.dao.BikeMapper;
import com.zq.ssm.model.Bike;
import com.zq.ssm.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {


    @Autowired
    private BikeMapper bikeMapper;

    @Override
    public int updateBike(Bike bike) {
        int updateByPrimaryKeySelective = bikeMapper.updateByPrimaryKeySelective(bike);
        return updateByPrimaryKeySelective;
    }

    @Override
    public List<Bike> selectAllBike() {
        return bikeMapper.selectAllBike();
    }

    @Override
    public List<Bike> selectBikeByState(Bike bike) {
        return bikeMapper.selectBikeByState(bike);
    }

    @Override
    public int deleteBike(int id) {
        return bikeMapper.deleteByPrimaryKey(id);
    }
}
