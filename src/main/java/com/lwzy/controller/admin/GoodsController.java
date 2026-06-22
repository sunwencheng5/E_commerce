package com.lwzy.controller.admin;

import com.lwzy.bean.admin.Goods;
import com.lwzy.bean.admin.GoodsType;
import com.lwzy.service.admin.GoodsService;
import com.lwzy.service.admin.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsTypeService goodsTypeService;

    @RequestMapping("/select")
    public String select(Model model, int currentPage){
        int pageSize=5;//设定每页显示5条数据
        List<Goods> list=goodsService.select(); //获得所有商品数据
        int totalPage=(int)Math.ceil(list.size()*1.0/pageSize);//总页数
        int startIndex=(currentPage-1)*pageSize; //起始索引
        List<Goods> goods=goodsService.selectByPage(startIndex,pageSize); //查询当前页的商品数据
        //把当前页、总页数、当前页的商品存储到model中，以便页面取出
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalCount",totalPage);
        model.addAttribute("currentGoods",goods);
        return "admin/selectGoods";//跳转到admin/selectGoods.jsp
    }

    //跳转到新增页面
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<GoodsType> types=goodsTypeService.selectAllGoodsType();//查询所有商品类型
        model.addAttribute("typeList",types);//保存到model中，以便页面中取出
        return "admin/addGoods";
    }
    //新增页面上点【确定】按钮时
    @RequestMapping("/doAdd")
    public String doAdd(Goods goods){
        int result=goodsService.add(goods);//将数据添加到goods表
        //判断新增是否成功
        if(result>0){
            return "redirect:/goods/select?currentPage=1";//刷新列表页面
        }else{
            return "admin/addGoods";
        }
    }
    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdate(Model model,int id){
        Goods goods=goodsService.selectAGoods(id);
        List<GoodsType> types=goodsTypeService.selectAllGoodsType();//查询所有商品类型

        model.addAttribute("goods",goods);
        model.addAttribute("typeList",types);//保存到model中，以便页面中取出
        return "admin/updateGoods";
    }
    //修改页面上点【确定】按钮时
    @RequestMapping("/doUpdate")
    public String doUpdate(Goods goods){
        int result=goodsService.update(goods);//将数据更新到goods表
        //判断修改是否成功
        if(result>0){
            return "redirect:/goods/select?currentPage=1";//刷新列表页面
        }else{
            return "admin/updateGoods";
        }
    }
    //跳转到详情页面
    @RequestMapping("/detail")
    public String detail(Model model,int id){
        Goods goods=goodsService.selectAGoods(id);//查询商品信息
        model.addAttribute("goods",goods);//保存数据到model中，以便详情页面取出
        return "admin/goodsDetail";//跳转到详情页面
    }
    //删除
    @RequestMapping("/toDelete")
    @ResponseBody
    public Map<String,Object> toDelete(int id){
        return goodsService.delete(id);
    }
}
