package com.zq.ssm.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zq.ssm.dao.AreabikeMapper;
import com.zq.ssm.dao.SupermanagerMapper;
import com.zq.ssm.model.Areabike;
import com.zq.ssm.model.Areamanager;
import com.zq.ssm.model.Supermanager;
import com.zq.ssm.service.AreaManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RequestMapping("/areaManager")
@Controller
public class AreaManagerController {

    @Resource
    private AreaManagerService areaManagerService;

    @Autowired
    private AreabikeMapper areabikeMapper;

    @Autowired
    private SupermanagerMapper supermanagerMapper;
/*
    @Autowired
    private Areamanager areamanager;*/

    @RequestMapping("/areaManager/selectAll.do")
    public String SelectAreaManager(Model model) {
        List<Areamanager> areamanagersList = areaManagerService.SelectAllAreaManager();
        List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
        model.addAttribute("areamanagersList", areamanagersList);
        model.addAttribute("areabikeList", areabikeList);
        model.addAttribute("listsize", areamanagersList.size());
        System.out.println(areamanagersList);
        return "view/areaManager/ManagerView/manager-list";
    }

    @RequestMapping("/areaManager/addAreaManager.do")
    @ResponseBody
    public String AddAreaManager(Areamanager areamanager) {
        Areabike areabike = areabikeMapper.selectByPrimaryKey(Integer.valueOf(areamanager.getAreaName()));
        areamanager.setAreaName(areabike.getAreaName());
        areamanager.setAreaId(areabike.getAreaId());
        int addType = areaManagerService.addAreaManager(areamanager);

        Supermanager supermanager = new Supermanager();
        supermanager.setManagerName(areamanager.getManagerName());
        supermanager.setManagerPassword(areamanager.getManagerpassword());
        supermanager.setManagerType(1);
        supermanager.setManagerMark1(areamanager.getAreaName());
        int i = supermanagerMapper.insertSelective(supermanager);


        return "{\"code\":\""+addType+"\"}";
    }

    @RequestMapping("/areaManager/toaddAreaManager.do")
    public String toAddAreaManager(Model model) {
        List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
        model.addAttribute("areabikeList", areabikeList);

        return "view/areaManager/ManagerView/manager-add";
    }

    /*删除areamanager*/
    @RequestMapping("/areaManager/deleteAreaManager.do")
    public String deleteAreaManager(int id, Model model) {
        int deleteAreaManager = areaManagerService.deleteAreaManager(id);
        if (deleteAreaManager != 0) {
            model.addAttribute("msg", "fail");
        } else {
            model.addAttribute("msg", "success");
        }
        return "redirect:/areaManager/selectAll.do";
    }

    /* to Updateareamanager*/
    @RequestMapping("/areaManager/toupdateAreaManager.do")
    public String toupdateAreaManager(int id, Model model) {
        Areamanager areaManagerById = areaManagerService.findAreaManagerById(id);
        model.addAttribute("areaManager", areaManagerById);
        List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
        model.addAttribute("areabikeList", areabikeList);
        return "view/areaManager/ManagerView/manager-revise";
    }

    @RequestMapping("/areaManager/updateAreaManager.do")
    public String updateAreaManager(Areamanager areamanager, Model model) {
        int updateAreaManager = areaManagerService.updateAreaManager(areamanager);

        Supermanager supermanager = new Supermanager();
        supermanager.setManagerName(areamanager.getManagerName());
        supermanager.setManagerPassword(areamanager.getManagerpassword());
        supermanager.setManagerType(1);
        supermanager.setManagerMark1(areamanager.getAreaName());
        int i = supermanagerMapper.insertSelective(supermanager);

        if (updateAreaManager != 0) {
            model.addAttribute("msg", "fail");
        } else {
            model.addAttribute("msg", "success");
        }
        return "redirect:/areaManager/selectAll.do";
    }

    /*模糊查询*/
    @RequestMapping("/areaManager/SelectAreaManagerForAreaNameOrAreaManagerName.do")
    public String SelectAreaManagerForAreaNameOrAreaManagerName(Areamanager areamanager, Model model) {

        if (areamanager.getAreaName().equals("区域名字")) {
            areamanager.setAreaName(null);
        }
        List<Areamanager> areamanagersList = areaManagerService.SelectAreaManagerForAreaNameOrAreaManagerName(areamanager);
        List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
        model.addAttribute("areamanagersList", areamanagersList);
        model.addAttribute("areabikeList", areabikeList);
        model.addAttribute("listsize", areamanagersList.size());
        System.out.println(areamanagersList + "=============");
        System.out.println("=====++++++++++++++++++++++++++++++++");
        return "view/areaManager/ManagerView/manager-list";
    }

    /*批量删除*/
    @RequestMapping("/areaManager/batchdeleteAreaManager.do")
    public String batchdeleteAreaManager(HttpServletRequest request, Model model) {
        String items = request.getParameter("delitems");// System.out.println(items);
        String[] strs = items.split(",");

        for (int i = 0; i < strs.length; i++) {
            try {
                int a = Integer.parseInt(strs[i]);
                int deleteAreaManager = areaManagerService.deleteAreaManager(a);

            } catch (Exception e) {
            }
        }
        return "redirect:/areaManager/selectAll.do";
    }


    /*ajax 判断用户是否存在*/
    @RequestMapping("/areaManager/ajaxAreaMansger.do")
    private void ajaxAreaMansger(HttpServletRequest request, Model model, HttpServletResponse response) {
        String managerid = request.getParameter("managerid");
        Areamanager areamanager = areaManagerService.selectAreaManagerById(Integer.valueOf(managerid));
        try {
            if (areamanager == null) {
                //model.addAttribute("result","no");
                response.getWriter().write("0");
            } else {
                response.getWriter().write("1");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
