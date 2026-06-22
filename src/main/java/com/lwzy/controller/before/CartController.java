package com.lwzy.controller.before;

import com.lwzy.bean.admin.Goods;
import com.lwzy.bean.admin.GoodsType;
import com.lwzy.bean.before.Buser;
import com.lwzy.bean.before.Cart;
import com.lwzy.service.admin.GoodsService;
import com.lwzy.service.admin.GoodsTypeService;
import com.lwzy.service.before.CartService;
import com.lwzy.service.before.IndexService;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.javassist.bytecode.CodeIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    IndexService indexService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsTypeService typeService;

    //加购
    @RequestMapping("/putCart")
    @ResponseBody
    public String putCart(@RequestBody Cart cart, HttpSession session){
       Buser user = (Buser) session.getAttribute("user");
       //如果未登录则返回"nologin"，已登录则正常加购
       if (user == null){
            return "noLogin";
        }else {
            cart.setBusertable_id(user.getId());
            return cartService.putCart(cart);
        }
    }

    //查询
    @RequestMapping("/selectCart")
    public String selectCart(Model model,HttpSession session,String flag){
        //导航栏需要的数据
        List<Goods> adviseGoods=indexService.selectAdviseGoods();//获取所有广告商品
        List<GoodsType> types=typeService.selectAllGoodsType();//获取所有商品类型
        model.addAttribute("adviseGoods",adviseGoods);
        model.addAttribute("allTypes",types);
        Buser user = (Buser) session.getAttribute("user");
        int userId = (user == null?0:user.getId());
        //得到当前登录用户的所有加购信息
        List<Map<String,Object>> list = cartService.select(userId);
        //统计金额
        double total = 0;
        for (Map<String,Object> map:list){
            total = total + (double) map.get("smallsum");
        }
        //存储数据，已便页面取出
        model.addAttribute("total",total);
        model.addAttribute("cartList",list);
        if ("count".equals(flag)){
            return "before/count";
        }
        return "before/cart";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(int id){
        cartService.delete(id);
        return "forward:/cart/selectCart";//刷新页面
    }

    //清空
    @RequestMapping("/clear")
    public String deleteCart(HttpSession session){
        int userId=((Buser)session.getAttribute("user")).getId();
        cartService.delete(userId);
        return "forward:/cart/selectCart";
    }

    //收藏
    @RequestMapping("/myFocus")
    public String myFocus(Model model,HttpSession session){
        //导航栏需要的数据
        List<Goods> adviseGoods=indexService.selectAdviseGoods();//获取所有广告商品
        List<GoodsType> types=typeService.selectAllGoodsType();//获取所有商品类型
        model.addAttribute("adviseGoods",adviseGoods);
        model.addAttribute("allTypes",types);

        Buser user = (Buser) session.getAttribute("user");
        int userId = (user == null?0:user.getId());
        //得到当前登录用户的所有收藏信息
        List<Map<String,Object>> list = cartService.selectFocus(userId);
        model.addAttribute("focusList",list);
        return "before/myFocus";
    }
}
