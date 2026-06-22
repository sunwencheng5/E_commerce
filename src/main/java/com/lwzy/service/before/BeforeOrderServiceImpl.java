package com.lwzy.service.before;

import com.lwzy.bean.admin.Order;
import com.lwzy.mapper.before.CartMapper;
import com.lwzy.mapper.before.BeforeOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BeforeOrderServiceImpl implements BeforeOrderService {
    @Autowired
    BeforeOrderMapper beforeOrderMapper;
    @Autowired
    CartMapper cartMapper;
    @Override
    public void orderSubmit(Order order) {
        //添加订单
        beforeOrderMapper.insertOrder(order);
        //添加订单详情
        beforeOrderMapper.insertOrderDetail(order);
        //更新商品库存
        beforeOrderMapper.updateStore(order.getUser().getId());
        //清空购物车
        cartMapper.clear(order.getUser().getId());}

    @Override
    public void pay(int id) {
        beforeOrderMapper.pay(id);
    }

    @Override
    public List<Order> select(int userId) {
        return beforeOrderMapper.select(userId);
    }

    @Override
    public List<Map<String, Object>> selectOrderDetail(int orderId) {
        return beforeOrderMapper.selectOrderDetail(orderId);
    }
}
