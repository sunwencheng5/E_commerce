package com.lwzy.service.before;

import com.lwzy.bean.admin.Order;

import java.util.List;
import java.util.Map;

public interface BeforeOrderService {
    //订单提交
    void orderSubmit(Order order);
    //支付
    void pay(int id);
    //订单查询
    List<Order> select(int userId);//订单(查全部)
    List<Map<String,Object>> selectOrderDetail(int orderId);//订单(精确查询)
}
