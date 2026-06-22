package com.lwzy.service.before;

import com.lwzy.bean.admin.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface IndexService {
    //获取所有广告商品
    List<Goods> selectAdviseGoods();
    //获取类型下的商品
    List<Goods> selectLatestGoods(int typeId);
    //根据商品名获取商品(模糊查询)
    List<Goods> selectGoodsByKey(String name);
}
