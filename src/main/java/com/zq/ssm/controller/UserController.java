package com.zq.ssm.controller;

import com.zq.ssm.dao.UserMapper;
import com.zq.ssm.model.*;
import com.zq.ssm.service.*;
import com.zq.ssm.util.Main;
import com.zq.ssm.util.Open;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin.com.Utils;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding;
import javax.naming.MalformedLinkException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    private static Log log = LogFactory.getLog(UserController.class);
    @Resource
    private UserService userService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private RunbikeService runbikeService;

    @Autowired
    private AreaManagerService areaManagerService;

    @Autowired
    private UserMapper userMapper;

    /*跳转到用户首页*/
    @RequestMapping("/tobikepage.do")
    public String toBikePage(HttpServletRequest request, Model model) {

        Object useUser = request.getSession().getAttribute("useUser");
        User user = null;
        if (useUser != null) {
            user = (User) useUser;
        }

        model.addAttribute("user", user);
        return "bikepage";
    }

    /*跳到用户登录界面*/
    @RequestMapping("/tologin.do")
    public String toLogin() {
        return "view/user/main-login";
    }

    /*跳到用户注册接main*/
    @RequestMapping("/toregister.do")
    private String toRegist() {

        return "view/user/main-register";
    }

    /*注册页面获取邮箱验证码,, 使用工具类Mail*/
    @RequestMapping("/registerMail.do")
    @ResponseBody
    public String register(HttpServletRequest request) {
        System.out.println("----------------------------");
        String userPhone = request.getParameter("userPhone");
        String randomCode = (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10);
        String success = Main.regist(userPhone, randomCode);
        request.getSession().setAttribute("randomCode", randomCode);
        if ("success".equals(success)) {
            return randomCode;
        }
        return "123456";
    }

    /*注册页面注册一个新用户*/
    @RequestMapping("/userToRegister.do")
    public String userToRegister(User user, Model model, HttpServletRequest request) {
        String userPhone = user.getUserPhone();
        String registCode = user.getRegistCode();
        String randomCode = (String) request.getSession().getAttribute("randomCode");
        if (registCode.equals(randomCode)) {
            user.setUserWeal("新用户注册，可以免费骑行5次");
            user.setUserPurse(0);
            user.setUserConfirm("未认证");
            user.setRegister(new Date());

            int insertUser = userService.insertUser(user);
            User user1 = userService.selectUserByPhone(userPhone);

            request.getSession().setAttribute("useUser", user1);

            model.addAttribute("user", user);
            return "view/user/main-userenzheng";
        }
        model.addAttribute("error", "验证码不正确");
        return "view/user/main-register";
    }

    @RequestMapping("/touserenzheng.do")
    public String touserenzheng(HttpServletRequest request, Model model) {
        String userPhone = (String) request.getParameter("userPhone");
        String userConfigrom = (String) request.getParameter("userConfigrom");
        User user = userService.selectUserByPhone(userPhone);
        if (userConfigrom.equals("未认证")) {
            model.addAttribute("user", user);
            return "view/user/main-userenzheng";
        } else {
            model.addAttribute("user", user);
            return "bikepage";
        }

    }


    /*跳转到地图页面*/
    @RequestMapping("/map.do")
    public String toMap(Model model, HttpServletRequest request) {
        Object useUser = request.getSession().getAttribute("useUser");

        if (useUser == null) {
            model.addAttribute("error", "用户还没登录，请登录");
            return "view/user/main-login";
        }
        User user = null;
        Supermanager supermanager = null;
        if (useUser instanceof User) {
            user = (User) useUser;
        } else if (useUser instanceof Supermanager) {
            supermanager = (Supermanager) useUser;

        }
        List<Bike> bikes = userService.selectAllBike();
        if (bikes == null) {
            model.addAttribute("msg", "@RequestMapping(\"/map.do\")  userService.selectAllBike(); bikes为空");
            return "view/error";
        }
        model.addAttribute("ob", bikes);
        return "view/areaManager/Map";
    }

    /*跳转到扫吗页面*/
    @RequestMapping("/toScan.do")
    public String userRide(User user, Model model, HttpServletRequest request) {
        /*这儿是定义了一个人为1
         * 如果登录的话 username直接从前台获取
         * */
        String bikeId = request.getParameter("bikeId");
        if (bikeId == null) {
            model.addAttribute("msg", "@RequestMapping(\"/toScan.do\")  request.getParameter(\"bikeId\");; bikeId");
            return "view/error";
        }
        int IntBikeId = 0;
        try {
            IntBikeId = Integer.valueOf(bikeId);
        } catch (NumberFormatException e) {
            log.info("IntBikeId = Integer.valueOf(bikeId); 为空");
            e.printStackTrace();
        }
        /*user.setUserId(4);
        user.setUserName("美美");
        model.addAttribute("useUser", user);
        User user1 = userService.selectUserById(4);
        request.getSession().setAttribute("useUser", user1);*/
        /*这是直接取的一个自行车*/
        int id = 8365;
        Bike bike = userService.selectBikeForId(IntBikeId);
        model.addAttribute("bike", bike);
        //request.getSession().setAttribute("bike",bike);
        return "view/user/sweepCode";
    }

    @RequestMapping("/scan.do")
    @ResponseBody
    public String scanBike(HttpServletRequest request) {
        String two = request.getParameter("two");
        int bikeId = Integer.valueOf(request.getParameter("bikeId"));
        //不知为什么路径前加了file:///，导致不能解码，因此将多出来的的前缀去掉
        //String newTwo=two.replace("file:///", "");
        Bike bike = userService.selectBikeForId(bikeId);
        bike.setBikeState("使用中");

        //Open.CreateCode("852258",request);
        //String pws = Open.openTwo(two);
        //bike.setOpenPsw(pws);

        int updateBike = bikeService.updateBike(bike);
        if (updateBike == 1) {
            System.out.println("-----------------------------updateBike----------" + updateBike);
        }
        String openPsw = bike.getOpenPsw();
        request.getSession().setAttribute("bike", bike);

        return openPsw;
    }

    /*去骑行计费页面*/
    @RequestMapping("/totime.do")
    public String toTime(HttpServletRequest request, Model model) {
        Bike bike = (Bike) request.getSession().getAttribute("bike");
//        User user = (User) request.getSession().getAttribute("useUser");
        Object useUser = request.getSession().getAttribute("useUser");
        if (useUser == null) {
            model.addAttribute("error", "用户还没登录，请登录");
            return "view/user/main-login";
        }
        User user = null;
        Supermanager supermanager = null;
        if (useUser instanceof User) {
            user = (User) useUser;
        } else if (useUser instanceof Supermanager) {
            supermanager = (Supermanager) useUser;
            model.addAttribute("error", "现在是登录的管理员账户，请登录用户账户");
            return "view/user/main-login";
        }

        Runbike runBike = new Runbike();
        runBike.setBike(bike);
        runBike.setBikeId(bike.getBikeId());
        runBike.setUserId(user.getUserId());
        runBike.setUserName(user.getUserName());
        runBike.setRunTimeStart(new Date());
        double row = bike.getBikeRow();
        double col = bike.getBikeCol();
        runBike.setRunAddressStart(row + "" + col);
        runBike.setAreamanager(bike.getAreaManager());

        int insertRunbikeID = runbikeService.insertRunbikeBackId(runBike);
        runBike.setRunBikeId(insertRunbikeID);
        if (insertRunbikeID >= 1) {
            System.out.println("--------------insertRnbike 增加成功-------------“”" + insertRunbikeID);
        }

        request.getSession().setAttribute("runBike", runBike);
        return "view/user/time";

    }

    /**
     * 结束用车去支付页面
     * 此页面更新车辆信息，车辆区域信息
     * 用户账户信息
     */
    @RequestMapping("/touserOver.do")
    public String toUserOver(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("useUser");
        double row = 112.454032 + 0.005;
        double col = 38.02147 - 0.006;

        System.out.println("经度：" + row + "=====纬度：" + col);
        //用经纬度匹配区域，需调用别人的方法，此处先写死了
        String areaName = "中北大学西区";
        Bike bike = (Bike) request.getSession().getAttribute("bike");
        bike.setBikeRow(row);
        bike.setBikeCol(col);
        bike.setBikeAddress(row + "" + col);
        bike.setBikeState("空闲");
        bikeService.updateBike(bike);

        //获取支付应金额
//        String pay=request.getParameter("money");
        String pay = "5";
        Runbike runBike = (Runbike) request.getSession().getAttribute("runBike");
        runBike.setRunAddressEnd(row + "" + col);
        runBike.setRunPay(Float.valueOf(pay));
        System.out.println("------------------runBike----------------" + runBike);
        runBike.setRunBikeId(runBike.getRunBikeId());
        int updateRunbike = runbikeService.updateRunbike(runBike, bike);
        if (updateRunbike == 1) {
            System.out.println("--------------insertRnbike 增加成功-------------“”" + updateRunbike);
        }
        System.out.println("a====updateRunbike==" + updateRunbike);

        if (Integer.parseInt(pay) == 0) {
            model.addAttribute("user", user);
            model.addAttribute("runBike", runBike);
            return "view/user/freePay";
        } else {
            System.out.println("getUserPurse" + user.getUserPurse());
            System.out.println("Float.parseFloat(pay)" + Float.parseFloat(pay));
            if (user.getUserPurse() == null) {
                model.addAttribute("msg", "user.getUserPurse()为空");
                return "view/error";
            }
            if (user.getUserPurse() > Float.parseFloat(pay)) {
                int money = (int) (user.getUserPurse() - Float.parseFloat(pay));
                user.setUserPurse(money);
                int updateUser = userService.updateUser(user);
                if (updateUser == 1) {
                    System.out.println("--------------updateUser 修改成功-------------“”" + updateRunbike);
                }
                request.getSession().setAttribute("success", "支付成功！");
                model.addAttribute("user", user);
                model.addAttribute("runBike", runBike);
                return "view/user/freePay";
            } else {
                System.out.println("余额不足");
                System.out.println("userid===" + user.getUserId());
                request.getSession().setAttribute("pay", pay);
                request.getSession().setAttribute("addMoney", "余额不足，进入充值页面！");
                model.addAttribute("user", user);
                model.addAttribute("runBike", runBike);
                model.addAttribute("pay", pay);
                model.addAttribute("msg", "余额不足，进入充值页面！");
                return "view/user/main-userchongzhi2";
//                response.sendRedirect(request.getContextPath()+"/user.do?method=chongZhi2&id="+user.getUserId());
            }
        }

    }

    /*充值页面*/
    @RequestMapping("/chongzhi.do")
    public String chongzhi(HttpServletRequest request, Model model) {
        try {
            if ((User) request.getSession().getAttribute("useUser") == null && Integer.valueOf(request.getParameter("purse")) == null && Integer.valueOf(request.getParameter("pay")) == 0.0 && Integer.valueOf(request.getParameter("oldpurse")) == null) {
            }
        } catch (NumberFormatException e) {
            model.addAttribute("msg", "----(User) request.getSession().getAttribute(\"useUser\") + ----null");
            model.addAttribute("msg", "----pay+----null");
            model.addAttribute("msg", "-Integer.valueOf(request.getParameter(\"oldpurse\")) + -------null");
            model.addAttribute("msg", "-----Integer.valueOf(request.getParameter(\"purse\")) +---null");
            e.printStackTrace();
            return "view/error";
        }
        Integer purse = Integer.valueOf(request.getParameter("purse"));
        float pay = Integer.valueOf(request.getParameter("pay"));
        Integer oldpurse = Integer.valueOf(request.getParameter("oldpurse"));
        User user = (User) request.getSession().getAttribute("useUser");


        user.setUserPurse((int) (purse + oldpurse - pay));
        int updateUser = userService.updateUser(user);
        if (updateUser == 1) {
            System.out.println("--------------updateUser 修改成功-------------“”" + updateUser);
        }

        model.addAttribute("msg", "支付成功！");
        model.addAttribute("user", user);
        Runbike runbike = new Runbike();
        runbike.setRunPay(pay);
        model.addAttribute("runBike", runbike);
        return "view/user/freePay";
    }


    /*认证  充值页面  拿到Session中的用户给钱包充值*/
    @RequestMapping("/renzhengchongzhi.do")
    public String renzhengchongzhi(HttpServletRequest request, Model model) {
        Integer purse = 0;
        String purse1 = request.getParameter("purse");
        if (purse1 == null || purse1.equals("")) {
            purse = 0;

        } else {
            purse = Integer.valueOf(purse1);
        }

        User user = (User) request.getSession().getAttribute("useUser");
        if (user == null) {
            model.addAttribute("error", "用户未登录，请先登录");
            return "view/user/main-login";
        }
        user.setUserPurse(purse);
        user.setUserConfirm("已认证");
        user.setUserCredit(100);
        int updateUser = userService.updateUser(user);
        if (updateUser == 1) {
            System.out.println("--------------updateUser 修改成功-------------“”" + updateUser);
        }

        model.addAttribute("user", user);
        return "view/user/main-userupdate";
    }

    /*ajax 判断用户是否存在*/
    @RequestMapping("/ajaxUser.do")
    public void ajaxUser(HttpServletRequest request, Model model, HttpServletResponse response) {
        String userPhone = request.getParameter("userPhone");
        User user = null;
        try {
            userService.selectUserByPhone(userPhone);
            if (user == null) {
                response.getWriter().write("0");
            } else {
                response.getWriter().write("1");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*updateUserMsg 修改用户信息*/
    @RequestMapping("/updateUserMsg.do")
    public String updateUserMsg(MultipartFile file, User user, Model model, HttpServletRequest request) throws IOException {

        /**
         * 上传图片
         */
        //01上传的地址
        String path = request.getSession().getServletContext().getRealPath("image");
        //02获取文件名
        String fileName = null;
        try {
            fileName = file.getOriginalFilename();
            //03文件的传输保存
            File dir = new File(path, fileName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file.transferTo(dir);
            //MultipartFile自带的解析方法
            user.setUserPortrait("/image/" + fileName);
            System.out.println("-----------------user=------------------" + user);
            user.setUserConfirm("已认证");
            int updateUser = userService.updateUser(user);
            User user1 = userService.selectUserById(user.getUserId());

            if (updateUser == 1) {
                model.addAttribute("user", user1);
                request.getSession().setAttribute("useUser", user1);
                model.addAttribute("msg", "用户信息修改成功");
                return "bikepage";
                /* return "view/user/main-userupdate";*/
            } else {
                model.addAttribute("msg", "用户信息修改失败");
                model.addAttribute("user", user1);
                return "bikepage";
                /* return "view/user/main-userupdate";*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "bikepage";
        }

    }


    /*检查邮箱是否重名*/
    @RequestMapping("/toCheckUser.do")
    @ResponseBody
    public String toCheckUser(@RequestParam("userPhone") String userPhone) {
        List<User> users = userService.selectAllUser();
        boolean check = false;

        try {
            for (User user : users) {
                if (userPhone.equals(user.getUserPhone())) {

                    return "1";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "0";


    }

    /*去反馈页面*/
    @RequestMapping("/toaddfeed.do")
    public String toaddfeed(Model model, HttpServletRequest request) {
        User useUser = null;

        try {
            useUser = (User) request.getSession().getAttribute("useUser");
            if (useUser == null) {
                model.addAttribute("error", "用户未登录，请先登录");
                return "view/user/main-login";
            }
            List<Areabike> areabikeList = areaManagerService.SelectforAreaForBike();
            model.addAttribute("areabikeList", areabikeList);
            model.addAttribute("user", useUser);

            return "view/user/main-addFeed";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "用户未登录，请先登录");
            return "view/user/main-login";
        }
    }

    /* *//*添加反馈*//*
    @RequestMapping("/addfeed.do")
    public String addfeed(Feedback feedback, Model model) {

        int i = userService.insertFeedBack(feedback);
        if (i == 1) {
            model.addAttribute("msg", "反馈成功，我们会尽快处理的");
            return "view/user/main-addFeed";
        }
        model.addAttribute("msg", "反馈失败，请重新反馈......");
        return "view/user/main-addFeed";
    }*/

    @RequestMapping(value = "/addfeed.do", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request, Feedback feedback, Model model) throws IOException {
        /**
         * 上传图片
         */
        //01上传的地址
        String path = request.getSession().getServletContext().getRealPath("image");
        //02获取文件名
        String fileName = file.getOriginalFilename();
        //03文件的传输保存
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        feedback.setBikePicture("/image/" + fileName);
        int i = userService.insertFeedBack(feedback);
        if (i == 1) {
            model.addAttribute("msg", "反馈成功，我们会尽快处理的");
            return "bikepage";
//            return "view/user/main-addFeed";
        }
        model.addAttribute("msg", "反馈失败，请重新反馈......");
        return "bikepage";

//        return "view/user/main-addFeed";
    }

//---------------------------------------------------------------------------------------------------------------------------------------
    /*后台管理的用户crud*/

    @RequestMapping("/selectAllUser.do")
    public String SelectAreaManager(Model model) {
        List<User> users = userService.selectAllUser();
        model.addAttribute("userlists", users);

        return "view/areaManager/userView/user-list";
    }

    /*删除areamanager*/
    @RequestMapping("/deleteuser.do")
    public String deleteuser(int id, Model model) {

        int i = userMapper.deleteByPrimaryKey(id);
        if (i != 0) {
            model.addAttribute("msg", "fail");
        } else {
            model.addAttribute("msg", "success");
        }
        return "redirect:/user/selectAllUser.do";
    }

    @RequestMapping("/toupdateuser.do")
    public String toupdateuse(int id, Model model) {
        User user = userMapper.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "view/areaManager/userView/user-update";
    }

    @RequestMapping("/updateuser.do")
    public String updateuse(User user, Model model) {
        int updateByPrimaryKeySelective = userMapper.updateByPrimaryKeySelective(user);
        return "redirect:/user/selectAllUser.do";

    }

    /*批量删除*/
    @RequestMapping("/batchdeleteuser.do")
    public String batchdeleteuser(HttpServletRequest request, Model model) {
        String items = request.getParameter("delitems");// System.out.println(items);
        String[] strs = items.split(",");

        for (int i = 0; i < strs.length; i++) {
            try {
                int a = Integer.parseInt(strs[i]);
                int deleteAreaManager = userMapper.deleteByPrimaryKey(a);

            } catch (Exception e) {
            }
        }
        return "redirect:/user/selectAllUser.do";
    }
}
