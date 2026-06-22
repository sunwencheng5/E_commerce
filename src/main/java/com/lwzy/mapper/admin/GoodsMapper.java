package com.lwzy.mapper.admin;

import com.lwzy.bean.admin.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {
    int add(Goods goods);//添加
    int update(Goods goods);//修改
    public List<Map<String, Object>> selectCart(int id);//查购物车
    public List<Map<String, Object>> selectFocus(int id);//查收藏
    public List<Map<String, Object>> selectOrder(int id);//查订单
    int delete(int id);//删除
    List<Goods> select();//查询全部
    List<Goods> selectByPage(int startIndex,int pageSize);//两个参数：起始索引和显示条数
    Goods selectAGoods(int id);//根据id查询商品
    public List<Goods> selectGoodsByTypeID(int id);//查该类型下有没有商品
}
