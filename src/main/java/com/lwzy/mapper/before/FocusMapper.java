package com.lwzy.mapper.before;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FocusMapper {
    //查询
    List<Map<String,Object>> select(int userId,int goodsId);
    //添加
    int add(int userId,int goodsId);
}
