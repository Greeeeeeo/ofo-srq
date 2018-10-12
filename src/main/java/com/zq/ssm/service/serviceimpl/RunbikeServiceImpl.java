package com.zq.ssm.service.serviceimpl;

import com.zq.ssm.dao.RunbikeMapper;
import com.zq.ssm.model.Bike;
import com.zq.ssm.model.Runbike;
import com.zq.ssm.service.RunbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RunbikeServiceImpl implements RunbikeService {

    @Autowired
    private RunbikeMapper runbikeMapper;

    @Override
    public int insertRunbike(Runbike runbike) {
        return runbikeMapper.insertSelective(runbike);
    }

    @Override
    public int insertRunbikeBackId(Runbike runbike) {
        return runbikeMapper.insertBackId(runbike);
    }

    @Override
    public int updateRunbike(Runbike runbike, Bike bike) {
        runbike.setRunTimeEnd(new Date());
        runbike.setAreamanager(bike.getAreaManager());
        runbike.setOrpay(false);
        System.out.println("------------------runBike----------------"+runbike);
        return runbikeMapper.updateByPrimaryKeySelective(runbike);
    }


}
