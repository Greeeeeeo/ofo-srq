package com.zq.ssm.controller;

import com.sun.mail.imap.protocol.ID;
import com.zq.ssm.dao.BikeMapper;
import com.zq.ssm.dao.BikepointMapper;
import com.zq.ssm.model.*;
import com.zq.ssm.service.BikeService;
import com.zq.ssm.util.CreateQRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @Autowired
    private BikepointMapper bikepointMapper;

    @Autowired
    private BikeMapper bikeMapper;


    @RequestMapping("/toselectAll.do")
    public String SelectBike(Model model, HttpServletRequest request) {
        List<Bike> bikes = bikeService.selectAllBike();
        model.addAttribute("bike", bikes);


        return "view/areaManager/bikeView/bike-list";
    }


    /*模糊查询*/
    @GetMapping("/Selectbikeforstate.do")
    public String Selectbikeforstate(Bike bike, Model model) {

        if (bike.getBikeState().equals("全部")) {
            bike.setBikeState(null);
        }

        List<Bike> bikes = bikeService.selectBikeByState(bike);
        model.addAttribute("bike", bikes);
        return "view/areaManager/bikeView/bike-list";
    }

    @RequestMapping("/deletebike.do")
    public String deletebike(String id, Model model) {
        int intid = Integer.valueOf(id);
        int deleteBike = bikeService.deleteBike(intid);
        if (deleteBike != 0) {
            model.addAttribute("msg", "fail");
        } else {
            model.addAttribute("msg", "success");
        }
        return "redirect:/bike/toselectAll.do";
    }

    @RequestMapping("/toaddbike.do")
    public String toaddbike(Model model) {
        List<Bikepoint> bikepoints = bikepointMapper.selectAllBikepoint();
        model.addAttribute("BikePointList", bikepoints);

        return "view/areaManager/bikeView/bike-add";
    }

    /*维修车辆 insert 和Update*/
    @RequestMapping(value = "/addbike.do", method = RequestMethod.POST)
    @ResponseBody
    public String addbike(Bike bike, Model model, HttpServletRequest request) {
        if (bike.getBikeId() == null) {
            System.out.println("----------------------------------------------------");
            bike.setBikeTime(new Date());
            Supermanager supermanager = (Supermanager) request.getSession().getAttribute("supermanager");

            double col = 38.019828;
            double row = 112.451472;
            double coll = ((Math.random()*0.01)+col);
            bike.setBikeCol(coll);
            bike.setBikeRow((Math.random()*0.01)+row);

            int i = bikeMapper.insertSelective(bike);
            return "{\"code\":\"" + i + "\"}";
        } else {
            int updateByPrimaryKeySelective = bikeMapper.updateByPrimaryKeySelective(bike);
            return "{\"code\":\"" + updateByPrimaryKeySelective + "\"}";
        }

    }

    /*生成二维码*/
    @RequestMapping("/createtwo.do")
    @ResponseBody
    public String createtwo(String psw, HttpServletRequest request) {
        CreateQRCode.createCode(psw, request);

        return "/image/" + psw + "Cd.jpg";
    }

    /*维修车辆*/
    @RequestMapping("/toupdatebike.do")
    public String toupdatebike(int id, Model model) {
        Bike bike = bikeMapper.selectByPrimaryKey(id);
        List<Bikepoint> bikepoints = bikepointMapper.selectAllBikepoint();
        model.addAttribute("BikePointList", bikepoints);
        model.addAttribute("bike", bike);
        return "view/areaManager/bikeView/bike-add";
    }


    /*batchdeletebike.do 批量删除*/

    /*批量删除*/
    @RequestMapping("/batchdeletebike.do")
    public String batchdeletebike(HttpServletRequest request, Model model) {
        String items = request.getParameter("delitems");// System.out.println(items);
        String[] strs = items.split(",");

        for (int i = 0; i < strs.length; i++) {
            try {
                int a = Integer.parseInt(strs[i]);
                int deleteAreaManager = bikeMapper.deleteByPrimaryKey(a);

            } catch (Exception e) {

            }
        }
        return "view/areaManager/bikeView/bike-list";
    }


}

