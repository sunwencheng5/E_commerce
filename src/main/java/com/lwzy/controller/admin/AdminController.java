package com.lwzy.controller.admin;

import com.lwzy.bean.admin.Admin;
import com.lwzy.service.admin.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    //跳转到登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "admin/login";
    }

    //点击登录按钮时
    @RequestMapping("/login")
//    public String login(String aname, String apwd, HttpSession session){
//        Admin admin1=adminService.login(aname,apwd);
//        if(admin1!=null){
//            //将当前登录用户信息保存在session中
//            session.setAttribute("aname",aname);
//            //跳转到商品列表页面
//            return "redirect:/goods/select?currentPage=1";
//        }
//        return "admin/login";//跳转到admin/login.jsp
//    }
        public String login(Admin admin, HttpSession session){
        Admin admin1=adminService.login(admin.getAname(),admin.getApwd());
        if(admin1!=null){
            //将当前登录用户信息保存在session中
            session.setAttribute("aname",admin.getAname());
            //跳转到商品列表页面
            return "redirect:/goods/select?currentPage=1";
        }
        return "admin/login";//跳转到admin/login.jsp
    }

    //安全推出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "admin/login";
    }
}
