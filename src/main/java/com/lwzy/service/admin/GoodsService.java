package com.lwzy.service.admin;

import com.lwzy.bean.admin.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    int add(Goods goods);//添加
    int update(Goods goods);//修改
    Map<String,Object> delete(int id);//删除
    List<Goods> select();//查询全部
    List<Goods> selectByPage(int startIndex,int pageSize);//两个参数：起始索引和显示条数
    Goods selectAGoods(int id);//根据id查询商品
}
