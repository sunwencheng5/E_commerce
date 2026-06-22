package com.lwzy.controller.admin;

import com.lwzy.bean.admin.Goods;
import com.lwzy.bean.admin.Order;
import com.lwzy.service.admin.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    //查询订单
    @RequestMapping("/select")
    public String select(Model model, int currentPage){
        int pageSize=5;//设定每页显示5条数据
        List<Order> list=orderService.selectAll(); //获得所有商品数据
        int totalPage=(int)Math.ceil(list.size()*1.0/pageSize);//总页数
        int startIndex=(currentPage-1)*pageSize; //起始索引
        List<Order> orders=orderService.selectByPage(startIndex,pageSize); //查询当前页的商品数据
        //把当前页、总页数、当前页的商品存储到model中，以便页面取出
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalCount",totalPage);
        model.addAttribute("currentOrders",orders);
        return "admin/selectOrders";//跳转到admin/selectGoods.jsp
    }

    //按月统计
    @RequestMapping("/selectByMonth")
    public String selectByMonth(Model model){
        List<Map<String,Object>> list=orderService.selectByMonth();//获取按月统计的数据
        //将返回的数据组织成柱状图需要的格式,一个月份列表，一个金额列表
        List<String> months=new ArrayList<String>();
        List<Double> amounts=new ArrayList<Double>();
        for(Map<String,Object> map:list){
            months.add("'"+map.get("month")+"'");
            amounts.add((Double)map.get("totalamount"));
        }
        model.addAttribute("months",months);
        model.addAttribute("totalAmounts",amounts);
        return "admin/selectOrderByMonth";
    }

    //按类型统计
    @RequestMapping("/selectByType")
    public String selectByType(Model model){
        List<Map<String,Object>> list=orderService.selectByType();//获取按类型统计的数据
        //将返回的数据组织成柱状图需要的格式,一个类型列表，一个金额列表
        List<String> types=new ArrayList<String>();
        List<Double> amounts=new ArrayList<Double>();
        for(Map<String,Object> map:list){
            types.add("'"+map.get("typename")+"'");
            amounts.add((Double)map.get("totalamount"));
        }
        model.addAttribute("types",types);
        model.addAttribute("totalAmounts",amounts);
        return "admin/selectOrderByType";
    }
}
