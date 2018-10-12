package com.zq.ssm.service;

import com.zq.ssm.model.Areabike;
import com.zq.ssm.model.Areamanager;

import java.util.List;

public interface AreaManagerService {

    List<Areamanager> SelectAllAreaManager();

    int addAreaManager(Areamanager areamanager);

   List<Areabike> SelectforAreaForBike();

    int deleteAreaManager(int id);

    Areamanager selectAreaManagerById(int id);

    void beachDeleteAreaManager(List<Integer> ids);

    Areamanager findAreaManagerById(int id);

    int updateAreaManager (Areamanager areamanager);

    List<Areamanager> SelectAreaManagerForAreaNameOrAreaManagerName(Areamanager areamanager);
}
