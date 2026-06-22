package com.lwzy.mapper.before;

import com.lwzy.bean.admin.Order;
import com.lwzy.bean.before.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {
    //判断是否已加过购物车
    List<Cart> isExist(Cart cart);
    //添加
    int add(Cart cart);
    //更新加购数量
    int update(Cart cart);
    //查询用户加购的商品
    List<Map<String, Object>> select(int userId);
    //删除商品
    int delete(int id);
    //清空购物车
    int clear(int userId);
    //我的收藏
    List<Map<String, Object>> selectFocus(int userId);
}
