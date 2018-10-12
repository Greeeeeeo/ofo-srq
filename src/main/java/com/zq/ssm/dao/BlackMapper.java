package com.zq.ssm.dao;

import com.zq.ssm.model.Black;

public interface BlackMapper {
    int insert(Black record);

    int insertSelective(Black record);
}