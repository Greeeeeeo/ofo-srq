package com.zq.ssm.service;

import com.zq.ssm.model.Bike;
import com.zq.ssm.model.Runbike;

public interface RunbikeService {

    int insertRunbike(Runbike runbike);

    int insertRunbikeBackId(Runbike runbike);


    int updateRunbike(Runbike runbike, Bike bike);
}
