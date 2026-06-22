package com.lwzy.service.admin;

import com.lwzy.bean.admin.Order;
import com.lwzy.mapper.admin.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> selectByPage(int startIndex, int pageSize) {
        return orderMapper.selectByPage(startIndex,pageSize);
    }

    @Override
    public List<Map<String, Object>> selectByMonth() {
        return orderMapper.selectByMonth();
    }

    @Override
    public List<Map<String, Object>> selectByType() {
        return orderMapper.selectByType();
    }
}
