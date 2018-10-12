package com.zq.ssm.dao;

import com.zq.ssm.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertUserBackId(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAllUser();

    User selectUserByPhone(String phone);

    User selectUserByName(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}