package com.zq.ssm.service;

import com.zq.ssm.model.Bike;
import com.zq.ssm.model.Feedback;
import com.zq.ssm.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {

    Bike selectBikeForId(int id);

    User selectUserById(int id);

    User selectUserByPhone(String phone);

    User selectUserByName(String name);

     int updateUser(User user);

     List<User> selectAllUser();

     List<Bike> selectAllBike();

     int insertUser(User user);

     int insertUserBackId(User user);

     int insertFeedBack(Feedback feedback);
}
