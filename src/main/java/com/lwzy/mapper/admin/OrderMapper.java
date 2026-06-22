package com.lwzy.mapper.admin;

import com.lwzy.bean.admin.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface OrderMapper {
    List<Order> selectAll();//查询全部订单
    List<Order> selectByPage(int startIndex,int pageSize);//分页查询
    List<Map<String,Object>> selectByMonth();//按月统计
    List<Map<String,Object>> selectByType();//按类型统计
}
