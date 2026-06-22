package com.lwzy.service.before;

import com.lwzy.bean.before.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {
    //加购
    String putCart(Cart cart);
    //查询购物车
    List<Map<String,Object>> select(int userId);
    //删除商品
    int delete(int id);
    //清空购物车
    int clear(int userId);
    //我的收藏
    List<Map<String, Object>> selectFocus(int userId);
}
