package com.zq.ssm.dao;

import com.zq.ssm.model.Supermanager;

import java.util.List;

public interface SupermanagerMapper {
    int deleteByPrimaryKey(Integer managerId);

    int insert(Supermanager record);

    int insertSelective(Supermanager record);

    Supermanager selectByPrimaryKey(Integer managerId);

    int updateByPrimaryKeySelective(Supermanager record);

    int updateByPrimaryKey(Supermanager record);

    List<Supermanager> selectSuperManager();
}