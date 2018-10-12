package com.zq.ssm.dao;

import com.zq.ssm.model.Areabike;

import java.util.List;

public interface AreabikeMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Areabike record);

    int insertSelective(Areabike record);

    Areabike selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Areabike record);

    int updateByPrimaryKey(Areabike record);

    List<Areabike> SelectforAreaForBike();
}