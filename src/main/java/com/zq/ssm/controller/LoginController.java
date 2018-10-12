package com.zq.ssm.controller;

import com.zq.ssm.dao.SupermanagerMapper;
import com.zq.ssm.model.Supermanager;
import com.zq.ssm.model.User;
import com.zq.ssm.service.LoginService;
import com.zq.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    /*随机验证码*/
    @RequestMapping("/createCode.do")
    public void imagecode(HttpServletRequest req, HttpServletResponse res) throws IOException {
        BufferedImage bi = new BufferedImage(100, 34, BufferedImage.TYPE_INT_RGB);
        // 得到该图片的绘图对象
        Graphics g = bi.getGraphics();
        Color c = new Color(153, 217, 234);
        g.setColor(c);
        g.fillRect(0, 0, 100, 34);
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r = new Random();
        int len = ch.length, index;
        // 向图片中输出数字和字母
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            index = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88),
                    r.nextInt(188), r.nextInt(255)));
            // 输出的字体和大小
            g.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 24));
            //写什么数字，在图片的什么位置画
            g.drawString("" + ch[index], (i * 15) + 5, 21);
            sb.append(ch[index]);
        }
        req.getSession().setAttribute("pcode", sb.toString());

        //System.out.println(myCode+"++++++");
        ImageIO.write(bi, "JPG", res.getOutputStream());

    }

    /*用户名登录页面*/
    @RequestMapping("/mainlogin2.do")
    public String mainLogin2() {

        return "view/user/main-login2";
    }

    /*邮箱登录页面*/
    @RequestMapping("/mainlogin1.do")
    public String mainLogin1() {

        return "view/user/main-login";
    }

    /*邮箱进行登录*/
    @RequestMapping("/tologin1.do")
    public String tologin1(User user, Model model, HttpServletRequest request) {
        String userPhone = user.getUserPhone();
        String registCode = user.getRegistCode();
        String pcode = (String) request.getSession().getAttribute("randomCode");
        if (registCode.equalsIgnoreCase(pcode)) {
            User user1 = userService.selectUserByPhone(userPhone);
            request.getSession().setAttribute("useUser", user1);
            if (user1 != null) {
                model.addAttribute("user", user1);
                return "bikepage";
            } else {
                model.addAttribute("error", "用户不存在");
                return "forward:/login/mainlogin1.do";
            }
        } else {
            model.addAttribute("error", "验证码错误");
            return "forward:/login/mainlogin1.do";
        }
    }

    /*用户名进行登录*/
    @RequestMapping("/tologin2.do")
    public String tologin2(User user, Model model, HttpServletRequest request) {
        String userName = user.getUserName();
        String registCode = user.getRegistCode();
        String pcode = (String) request.getSession().getAttribute("pcode");

        if (registCode.equalsIgnoreCase(pcode)) {
            User user1 = userService.selectUserByName(userName);
            if (user1 != null) {
                request.getSession().setAttribute("useUser", user1);
                model.addAttribute("user", user1);
                return "bikepage";
            } else {
                model.addAttribute("error", "用户不存在");
                return "forward:/login/mainlogin1.do";
            }
        } else {
            model.addAttribute("error", "验证码错误");
            return "forward:/login/mainlogin1.do";
        }
    }


    /*跳转到管理员首页*/
    @RequestMapping("/tomanagerlogin.do")
    public String tomanager() {
        return "view/areaManager/Managerlogin";
    }

    /*处理登录信息*/
    @RequestMapping("/managerlogin.do")
    public String managerLogin(Supermanager supermanager, Model model, HttpServletRequest request) {
        String pcode = "000000";
        pcode = (String) request.getSession().getAttribute("pcode");
        if (pcode.equalsIgnoreCase(supermanager.getMaragerMark2())) {
            List<Supermanager> supermanagers = loginService.selectAllSuperManager();
            for (Supermanager sup : supermanagers) {
                if (sup.getManagerName().equals(supermanager.getManagerName()) && sup.getManagerPassword().equals(supermanager.getManagerPassword()) && sup.getManagerType() == supermanager.getManagerType()) {
                    model.addAttribute("supermanager", sup);
                    request.getSession().setAttribute("useUser",sup);
                    return "view/areaManager/index";
                } else {
                    model.addAttribute("error", "用户不存在......");

                }
            }
            return "view/areaManager/Managerlogin";
        } else {
            model.addAttribute("error", "验证码错误");
            return "view/areaManager/Managerlogin";
        }

    }

    /**
     * 退出系统
     * @param session
     *          Session
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/userlogout")
    public String logout(HttpSession session) throws Exception{
        //清除Session
        session.invalidate();

        return "bikepage";
    }
    @RequestMapping(value="/managerlogout.do")
    public String managerlogout(HttpSession session) throws Exception{
        //清除Session
        session.invalidate();

        return "view/areaManager/Managerlogin";
    }
}
