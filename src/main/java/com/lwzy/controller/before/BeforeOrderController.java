package com.lwzy.controller.before;

import com.lwzy.bean.admin.Goods;
import com.lwzy.bean.admin.GoodsType;
import com.lwzy.bean.admin.Order;
import com.lwzy.bean.before.Buser;
import com.lwzy.service.admin.GoodsTypeService;
import com.lwzy.service.before.IndexService;
import com.lwzy.service.before.BeforeOrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/beforeorder")
public class BeforeOrderController {
    @Autowired
    BeforeOrderService service;
    @Autowired
    IndexService indexService;
    @Autowired
    GoodsTypeService typeService;

    @RequestMapping("/orderSubmit")
    public String ordderSubmit(Model model, HttpSession session,double amount){
        //导航栏需要的数据
        List<Goods> adviseGoods=indexService.selectAdviseGoods();//获取所有广告商品
        List<GoodsType> types=typeService.selectAllGoodsType();//获取所有商品类型
        model.addAttribute("adviseGoods",adviseGoods);
        model.addAttribute("allTypes",types);

        Order order = new Order();
        order.setAmount(amount);//订单金额
        order.setUser((Buser) session.getAttribute("user"));//当前登录用户
        order.setStatus(0);//订单状态：未支付
        service.orderSubmit(order);//提交订单
        model.addAttribute("order",order);//储存订单数据以便页面取出
        return "before/pay";//跳转到支付页面pay.jsp
    }

    @RequestMapping("/pay")
    public String pay(Model model, HttpSession session,int id){
        service.pay(id);//支付
        return "redirect:/index/index?typeId=0";//跳转到首页
    }

    @RequestMapping("/myOrder")
    public String myOrder(Model model,HttpSession session){
        //导航栏需要的数据
        List<Goods> adviseGoods=indexService.selectAdviseGoods();//获取所有广告商品
        List<GoodsType> types=typeService.selectAllGoodsType();//获取所有商品类型
        model.addAttribute("adviseGoods",adviseGoods);
        model.addAttribute("allTypes",types);

        Buser u = (Buser) session.getAttribute("user");
        int userId= (u==null?0: u.getId());
        List<Order> list = service.select(userId);
        model.addAttribute("orderList",list);
        return "before/myOrder";
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(Model model,int orderId){
        //导航栏需要的数据
        List<Goods> adviseGoods=indexService.selectAdviseGoods();//获取所有广告商品
        List<GoodsType> types=typeService.selectAllGoodsType();//获取所有商品类型
        model.addAttribute("adviseGoods",adviseGoods);
        model.addAttribute("allTypes",types);

        List<Map<String,Object>> list = service.selectOrderDetail(orderId);
        model.addAttribute("orderDetailList",list);
        return "before/orderDetail";
    }
}
