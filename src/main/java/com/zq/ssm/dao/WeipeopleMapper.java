package com.zq.ssm.dao;

import com.zq.ssm.model.Weipeople;

import java.util.List;

public interface WeipeopleMapper {
    int deleteByPrimaryKey(Integer weiId);

    int insert(Weipeople record);

    int insertSelective(Weipeople record);

    Weipeople selectByPrimaryKey(Integer weiId);

    List<Weipeople> selectAll();

    int updateByPrimaryKeySelective(Weipeople record);

    int updateByPrimaryKey(Weipeople record);
}