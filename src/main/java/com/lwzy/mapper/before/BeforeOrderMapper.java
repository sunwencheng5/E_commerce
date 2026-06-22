package com.lwzy.mapper.before;

import com.lwzy.bean.admin.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BeforeOrderMapper {
    int insertOrder(Order order);//新增订单
    int insertOrderDetail(Order order);//新商品详情
    int updateStore(int userId);//更新库存
    int pay(int id);//支付状态从0变成1
    List<Order> select(int userId);//订单(查全部)
    List<Map<String,Object>> selectOrderDetail(int orderId);//订单(精确查询)
}
