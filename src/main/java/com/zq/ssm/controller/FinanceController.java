package com.zq.ssm.controller;

import com.zq.ssm.dao.FinanceMapper;
import com.zq.ssm.model.Areabike;
import com.zq.ssm.model.Areamanager;
import com.zq.ssm.model.Finance;
import com.zq.ssm.service.AreaManagerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceMapper financeMapper;

    @Autowired
    private AreaManagerService areaManagerService;


    @RequestMapping("/toallfinance.do")
    public String toallfinance() {
        return "view/areaManager/financeView/finance-add";
    }

    @RequestMapping("/allfinance.do")
    public String allfinance(Model model) {
        List<Finance> selectallfinance = financeMapper.selectallfinance();
        List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
        for (Finance finance : selectallfinance) {
            Areamanager areamanager = areaManagerService.selectAreaManagerById(finance.getManagerId());
            finance.setMoneyDate(areamanager.getAreaName());
            finance.setMoneySurplus(finance.getMoneyIncome() - finance.getMoneyExpend());
        }
        model.addAttribute("finances", selectallfinance);
        //model.addAttribute("areabikeList", areabikeList);
        return "view/areaManager/financeView/finance-list";
    }


    /*模糊查询*/
    @RequestMapping("/selectmohu.do")
    public String selectmohu(@Param(value = "moneyId") String moneyId, Model model) {
        List<Finance> selectallfinance = new ArrayList<Finance>();
        if (moneyId == null || moneyId == "") {
            selectallfinance = financeMapper.selectallfinance();
        } else {
            Finance finance1 = (Finance) financeMapper.selectByPrimaryKey(moneyId);
            selectallfinance.add(finance1);
        }
        model.addAttribute("finances", selectallfinance);
        return "view/areaManager/financeView/finance-list";
    }
}
