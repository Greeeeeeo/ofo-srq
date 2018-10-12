package com.zq.ssm.dao;

import com.zq.ssm.model.Feedback;

import java.util.List;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer remarkId);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer remarkId);

    List<Feedback> selectAllFeedBack();

    List<Feedback> selectAllweixiu(String weixiu);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}