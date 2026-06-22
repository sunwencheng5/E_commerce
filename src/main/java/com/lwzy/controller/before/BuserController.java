package com.lwzy.controller.before;

import com.lwzy.bean.before.Buser;
import com.lwzy.service.before.BuserService;
import com.lwzy.service.before.FocusService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class BuserController {
    @Autowired
    BuserService userService;
    @Autowired
    FocusService focusService;

    //查询邮箱地址有没有被用
    @RequestMapping("/isUse")
    @ResponseBody
    public String isUse(@RequestBody Buser user){
        return userService.isUse(user);
    }
    //跳转到注册页面
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "before/register";//跳转到register.jsp
    }

    //点击注册按钮时
    @RequestMapping("/doRegister")
    public String doRegister(Buser user){
        //判断是否注册成功，成功则跳转到登录页面
        if(userService.register(user)>0){
            return "before/login";//跳转到登录.jsp
        }else{
            return "before/register";
        }
    }
    //跳转到登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "before/login";//跳转到login.jsp
    }

    @RequestMapping("/doLogin")
    public String doLogin(Model model, Buser user, HttpSession session){
        //获取验证码计算结果
        String result=(String)session.getAttribute("rand");
        //判断用户输入的验证码和验证码计算结果是否一致
        if(!result.equals(user.getCode())){
            model.addAttribute("errorMessage","验证码错误!");
            model.addAttribute("bemail",user.getBemail());
            return "before/login";
        }else{
            //判断是否存在此用户
            Buser u=userService.login(user);
            if(u!=null){
                //将当前登录用户对象保存到session中
                session.setAttribute("user",u);
                model.addAttribute("errorMessage","");//清空错误信息
                return "forward:/index/index?typeId=0";
            }else{
                model.addAttribute("errorMessage","邮箱或密码错误");
                model.addAttribute("bemail",user.getBemail());
                return "before/login";
            }
        }
    }

    //收藏
    @RequestMapping("/focus")
    @ResponseBody
    public String focus(int goodId,HttpSession session){
        //从session中取出当前登录用户对象
        Buser user=(Buser) session.getAttribute("user");
        int userId=(user==null?0:user.getId());
        //收藏
        return focusService.focus(userId,goodId);
    }

    //修改密码
    @RequestMapping("/toUserInfo")
    public String toUserInfo(){
        return "before/userInfo";
    }
    @RequestMapping("updatePwd")
    public String updatePwd(Buser user, HttpSession session){
        int result = userService.updatebpwd(user);
        if (result > 0){
            session.invalidate();
            return "before/login";
        }else {
            return "before/userInfo";
        }
    }
}
