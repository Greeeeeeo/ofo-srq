package com.zq.ssm.controller;

import com.zq.ssm.dao.FeedbackMapper;
import com.zq.ssm.model.Areabike;
import com.zq.ssm.model.Areamanager;
import com.zq.ssm.model.Feedback;
import com.zq.ssm.model.Finance;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedBackControllerr {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @RequestMapping("/allfeedback.do")
    public String allfinance(Model model) {
        List<Feedback> feedbacks = feedbackMapper.selectAllFeedBack();
        model.addAttribute("feedbacks", feedbacks);

        return "view/areaManager/feedbackView/feedback-list";
    }


    @RequestMapping("/selectallweixiu.do")
    public String selectallweixiu(Model model) {
        String weixiu = "损坏";

        List<Feedback> feedbacks = feedbackMapper.selectAllweixiu(weixiu);
        model.addAttribute("feedbacks", feedbacks);

        return "view/areaManager/weixiuView/weixiu-list";
    }

    /*模糊查询*/
    @RequestMapping("/selectmohu.do")
    public String selectmohu(@Param(value = "moneyId") String moneyId, Model model) {

        return "view/areaManager/financeView/finance-list";
    }

    @RequestMapping("/toreplaybackfeed.do")
    public String replaybackfeed(int id ,Model model){
        Feedback feedback = feedbackMapper.selectByPrimaryKey(id);
        model.addAttribute("feedback", feedback);
        return "view/areaManager/feedbackView/feedback-reply";
    }

    @RequestMapping("/replayfeedback.do")
    public String replayfeedback(Feedback feedback,Model model){
        int updateByPrimaryKeySelective = feedbackMapper.updateByPrimaryKeySelective(feedback);
        List<Feedback> feedbacks = feedbackMapper.selectAllFeedBack();
        model.addAttribute("feedbacks", feedbacks);
        return "forward:/feedback/allfeedback.do";
    }

    @RequestMapping("/replayweixiuback.do")
    public String replayweixiuback(Feedback feedback,Model model){
        int updateByPrimaryKeySelective = feedbackMapper.updateByPrimaryKeySelective(feedback);
        List<Feedback> feedbacks = feedbackMapper.selectAllFeedBack();
        model.addAttribute("feedbacks", feedbacks);
        return "forward:/feedback/selectallweixiu.do";
    }



}
