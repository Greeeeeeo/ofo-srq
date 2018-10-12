package com.zq.ssm.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zq.ssm.dao.FinanceMapper;
import com.zq.ssm.model.*;
import com.zq.ssm.service.AreaManagerService;
import com.zq.ssm.service.UserService;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/char")
public class ECharController {


    @Autowired
    private UserService userService;

    @Autowired
    private FinanceMapper financeMapper;

    @Autowired
    private AreaManagerService areaManagerService;

    /*跳转到地图页面*/
    @RequestMapping("/map.do")
    public String toMap(Model model, HttpServletRequest request) {

        List<Bike> bikes = userService.selectAllBike();
        if (bikes == null) {
            model.addAttribute("msg", "@RequestMapping(\"/map.do\")  userService.selectAllBike(); bikes为空");
            return "view/error";
        }
        model.addAttribute("ob", bikes);
        return "view/areaManager/Map";
    }


    @RequestMapping("/pad.do")
    public String pad(Model model){
        List<Finance> selectallfinance = financeMapper.selectallfinance();
        List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
        for (Finance finance : selectallfinance) {
            Areamanager areamanager = areaManagerService.selectAreaManagerById(finance.getManagerId());
            finance.setMoneyDate(areamanager.getAreaName());
            finance.setMoneySurplus(finance.getMoneyIncome() - finance.getMoneyExpend());
        }

        model.addAttribute("finances", selectallfinance);

        return "view/areaManager/EcharView/chartspad";
    }
}



