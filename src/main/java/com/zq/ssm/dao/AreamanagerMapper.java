package com.zq.ssm.dao;

import com.zq.ssm.model.Areamanager;

import java.util.List;

public interface AreamanagerMapper {
    int deleteByPrimaryKey(Integer managerId);

    void batchDeleteAreamanager(List<Integer> ids);

    int insert(Areamanager record);

    int insertSelective(Areamanager record);

    Areamanager selectByPrimaryKey(Integer managerId);

    int updateByPrimaryKeySelective(Areamanager record);

    int updateByPrimaryKey(Areamanager record);

    List<Areamanager> SelectAllAreaManager();

    List<Areamanager> SelectAreaManagerForAreaNameOrAreaManagerName(Areamanager record);
}