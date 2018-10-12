package com.zq.ssm.service.serviceimpl;

import com.zq.ssm.dao.BikeMapper;
import com.zq.ssm.dao.FeedbackMapper;
import com.zq.ssm.dao.UserMapper;
import com.zq.ssm.model.Bike;
import com.zq.ssm.model.Feedback;
import com.zq.ssm.model.User;
import com.zq.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  BikeMapper bikeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public Bike selectBikeForId(int id) {
        return bikeMapper.selectByPrimaryKey(id);

    }

    @Override
    public User selectUserById(int id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectUserByPhone(String phone) {
        return userMapper.selectUserByPhone(phone);
    }

    @Override
    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<Bike> selectAllBike() {
        return bikeMapper.selectAllBike();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int insertUserBackId(User user) {
        return userMapper.insertUserBackId(user);
    }

    @Override
    public int insertFeedBack(Feedback feedback) {
        return feedbackMapper.insertSelective(feedback);
    }


}
