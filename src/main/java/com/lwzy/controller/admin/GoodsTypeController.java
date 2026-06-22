package com.lwzy.controller.admin;

import com.lwzy.bean.admin.Goods;
import com.lwzy.bean.admin.GoodsType;
import com.lwzy.service.admin.GoodsService;
import com.lwzy.service.admin.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {
    @Autowired
    GoodsTypeService goodsTypeService;

    @RequestMapping("/select")
    public String select(Model model, int currentPage){
        int pageSize=5;//设定每页显示5条数据
        List<GoodsType> list=goodsTypeService.selectAllGoodsType(); //获得所有商品类型
        int totalPage=(int)Math.ceil(list.size()*1.0/pageSize);//总页数
        int startIndex=(currentPage-1)*pageSize; //起始索引
        List<GoodsType> goodsTypes=goodsTypeService.selectByPage(startIndex,pageSize); //查询当前页的商品类型
        //把当前页、总页数、当前页的商品存储到model中，以便页面取出
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalCount",totalPage);
        model.addAttribute("currentGoodsType",goodsTypes);
        return "admin/selectGoodsType";//跳转到admin/selectGoods.jsp
    }

    //跳转到新增页面
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        return "admin/addGoodsType";
    }
    //新增页面上点【确定】按钮时
    @RequestMapping("/doAdd")
    public String doAdd(GoodsType goodsType){
        int result=goodsTypeService.add(goodsType);//将数据添加到goodsType表
        //判断新增是否成功
        if(result>0){
            return "redirect:/goodsType/select?currentPage=1";//刷新列表页面
        }else{
            return "admin/addGoodsType";
        }
    }
    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdate(Model model,int id){
        GoodsType goodsType=goodsTypeService.selectAGoodsType(id);
        model.addAttribute("goodsType",goodsType);//保存到model中，以便页面中取出
        return "admin/updateGoodsType";
    }
    //修改页面上点【确定】按钮时
    @RequestMapping("/doUpdate")
    public String doUpdate(GoodsType goodsType){
        int result=goodsTypeService.update(goodsType);//将数据更新到goodsType表
        //判断修改是否成功
        if(result>0){
            return "redirect:/goodsType/select?currentPage=1";//刷新列表页面
        }else{
            return "admin/updateGoodsType";
        }
    }

    //删除
    @RequestMapping("/toDelete")
    @ResponseBody
    public Map<String,Object> toDelete(int id){
        return goodsTypeService.delete(id);
    }
}
