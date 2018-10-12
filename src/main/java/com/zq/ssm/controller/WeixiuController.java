package com.zq.ssm.controller;

import com.zq.ssm.dao.SupermanagerMapper;
import com.zq.ssm.dao.WeipeopleMapper;
import com.zq.ssm.model.Areabike;
import com.zq.ssm.model.Areamanager;
import com.zq.ssm.model.Supermanager;
import com.zq.ssm.model.Weipeople;
import com.zq.ssm.service.AreaManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/weixiu")
public class WeixiuController {

    @Autowired
    private WeipeopleMapper weipeopleMapper;

    @Autowired
    private AreaManagerService areaManagerService;

    @Autowired
    private SupermanagerMapper supermanagerMapper;

    @RequestMapping("/selectAllWeixiu.do")
    public String selectAllWeixiu(Model model) {
        List<Weipeople> weipeople = weipeopleMapper.selectAll();
        model.addAttribute("weixiu", weipeople);

        return "view/weixiuView/weixiu-list";
    }

    @RequestMapping("/toupdateweixiu.do")
    public String toupdateweixiu(int id, Model model) {
        Weipeople weipeople = weipeopleMapper.selectByPrimaryKey(id);
        model.addAttribute("user", weipeople);

        List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
        model.addAttribute("areabikeList", areabikeList);
        return "view/weixiuView/weixiu-update";
    }

    @RequestMapping("/toinsertweixiu.do")
    public String toinsertweixiu(Model model) {
        List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
        model.addAttribute("areabikeList", areabikeList);

        return "view/weixiuView/weixiu-update";
    }

    @RequestMapping("/insertweiixu.do")
    public String insertweii(Weipeople weipeople, Model model) {
        if (weipeople.getWeiId() == null || "".equals(weipeople.getWeiId())) {
            weipeople.setWeiDate(new Date());
            int addType = weipeopleMapper.insertSelective(weipeople);

            Supermanager supermanager = new Supermanager();
            supermanager.setManagerName(weipeople.getWeiName());
            supermanager.setManagerPassword(weipeople.getWeiPassword());
            supermanager.setManagerType(2);
            supermanager.setManagerMark1(weipeople.getWeiConfirm());
            int i = supermanagerMapper.insertSelective(supermanager);

            return "redirect:/weixiu/selectAllWeixiu.do";
        } else {
            int updateByPrimaryKeySelective = weipeopleMapper.updateByPrimaryKeySelective(weipeople);
//            return "{return\"code\":\"" + updateByPrimaryKeySelective + "\"}";
            Supermanager supermanager = new Supermanager();
            supermanager.setManagerName(weipeople.getWeiName());
            supermanager.setManagerPassword(weipeople.getWeiPassword());
            supermanager.setManagerType(2);
            supermanager.setManagerMark1(weipeople.getWeiConfirm());
            int i = supermanagerMapper.insertSelective(supermanager);
            return "redirect:/weixiu/selectAllWeixiu.do";
//            List<Weipeople> weipeop = weipeopleMapper.selectAll();
//            model.addAttribute("weixiu", weipeop);
//
//            return "view/weixiuView/weixiu-list";
        }


    }


    @RequestMapping("/updateweixiu.do")
    public String updateweixiu(Weipeople weipeople, Model model) {
        int updateByPrimaryKeySelective = weipeopleMapper.updateByPrimaryKeySelective(weipeople);

        Supermanager supermanager = new Supermanager();
        supermanager.setManagerName(weipeople.getWeiName());
        supermanager.setManagerPassword(weipeople.getWeiPassword());
        supermanager.setManagerType(2);
        supermanager.setManagerMark1(weipeople.getWeiConfirm());
        int i = supermanagerMapper.insertSelective(supermanager);

        return "view/weixiuView/weixiu-list";
    }

    @RequestMapping("/deleteweixiu.do")
    public String deleteweixiu(int id, Model model) {

        int i = weipeopleMapper.deleteByPrimaryKey(id);
        return "redirect:/weixiu/selectAllWeixiu.do";
    }


    // 批量删除
    @RequestMapping("/batchdeleteweixiu.do")
    public String batchdeleteweixiu(HttpServletRequest request, Model model) {
        String items = request.getParameter("delitems");// System.out.println(items);
        String[] strs = items.split(",");

        for (int i = 0; i < strs.length; i++) {
            try {
                int a = Integer.parseInt(strs[i]);
                int deleteAreaManager = weipeopleMapper.deleteByPrimaryKey(a);

            } catch (Exception e) {
            }
        }
        return "redirect:/weixiu/selectAllWeixiu.do";
    }


}
