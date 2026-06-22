package com.lwzy.controller.before;

import com.lwzy.bean.admin.Goods;
import com.lwzy.bean.admin.GoodsType;
import com.lwzy.service.admin.GoodsService;
import com.lwzy.service.admin.GoodsTypeService;
import com.lwzy.service.before.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    IndexService indexService;
    @Autowired
    GoodsTypeService typeService;
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/index")
    public String index(Model model, int typeId){
        List<Goods> adviseGoods=indexService.selectAdviseGoods();//获取所有广告商品
        List<GoodsType> types=typeService.selectAllGoodsType();//获取所有商品类型
        List<Goods> latestGoods=indexService.selectLatestGoods(typeId);//获取所有广告商品
        //将以上数据存放到变量中，以便页面取出
        model.addAttribute("adviseGoods",adviseGoods);
        model.addAttribute("allTypes",types);
        model.addAttribute("latestGoods",latestGoods);
        //跳转到index.jsp
        return "before/index";
    }

    //点击搜索时
    @RequestMapping("/search")
    public String search(Model model, String key){
        List<Goods> adviseGoods=indexService.selectAdviseGoods();//获取所有广告商品
        List<GoodsType> types=typeService.selectAllGoodsType();//获取所有商品类型
        List<Goods> findGoods=indexService.selectGoodsByKey(key);//获取查询到的商品
        //将以上数据存放到变量中，以便页面取出
        model.addAttribute("adviseGoods",adviseGoods);
        model.addAttribute("allTypes",types);
        model.addAttribute("latestGoods",findGoods);
        //跳转到index.jsp
        return "before/index";
    }

    //打开商品详情
    @RequestMapping("/toDetail")
    public String toDetail(Model model,int id){
        //导航栏需要的数据
        List<Goods> adviseGoods=indexService.selectAdviseGoods();//获取所有广告商品
        List<GoodsType> types=typeService.selectAllGoodsType();//获取所有商品类型
        model.addAttribute("adviseGoods",adviseGoods);
        model.addAttribute("allTypes",types);
        //查询商品信息
        Goods goods=goodsService.selectAGoods(id);
        //保存商品信息
        model.addAttribute("goods",goods);
        //跳转到详情页面
        return "before/goodsDetail";
    }
}
