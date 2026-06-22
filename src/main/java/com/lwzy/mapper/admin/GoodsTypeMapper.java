package com.lwzy.mapper.admin;

import com.lwzy.bean.admin.Goods;
import com.lwzy.bean.admin.GoodsType;

import java.util.List;
import java.util.Map;

public interface GoodsTypeMapper {
    List<GoodsType> selectAllGoodsType();//查询所有类型
    int add(GoodsType goodsType);//新增
    int update(GoodsType goodsType);//修改
    int delete(int id);//删除
    List<GoodsType> selectByPage(int startIndex,int pageSize);//两个参数：起始索引和显示条数
    GoodsType selectAGoodsType(int id);//根据id查询商品类型
}
