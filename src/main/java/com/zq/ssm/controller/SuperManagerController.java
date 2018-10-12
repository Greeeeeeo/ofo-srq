package com.zq.ssm.controller;

import com.zq.ssm.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/manager")
public class SuperManagerController {


    /*跳转到管理员首页*/
    @RequestMapping("/tomanager.do")
    public String tomanager() {
        return "view/areaManager/Managerlogin";
    }




}
