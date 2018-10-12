package com.zq.ssm.service.serviceimpl;

import com.zq.ssm.dao.SupermanagerMapper;
import com.zq.ssm.model.Supermanager;
import com.zq.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl  implements LoginService {

    @Autowired
    private SupermanagerMapper supermanagerMapper;

    @Override
    public List<Supermanager> selectAllSuperManager() {
        return supermanagerMapper.selectSuperManager();
    }
}
