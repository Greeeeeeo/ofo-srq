package com.zq.ssm.interceptor;

import com.zq.ssm.model.Supermanager;
import com.zq.ssm.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
/*
        //获取Session
        HttpSession session = request.getSession();

        Object useUser = session.getAttribute("useUser");



        if(useUser != null){
            return true;
        }

        if (useUser instanceof Supermanager){
            //不符合条件的，跳转到登录界面
            request.getRequestDispatcher("/WEB-INF/pages/view/areaManager/Managerlogin.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/WEB-INF/pages/bikepage.jsp").forward(request, response);
        }*/


        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
