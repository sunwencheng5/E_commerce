package com.lwzy.service.admin;

import com.lwzy.bean.admin.GoodsType;
import com.lwzy.mapper.admin.GoodsMapper;
import com.lwzy.mapper.admin.GoodsTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService{
    @Autowired
    GoodsTypeMapper goodsTypeMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public List<GoodsType> selectAllGoodsType() {
        return goodsTypeMapper.selectAllGoodsType();
    }

    @Override
    public int add(GoodsType goodsType) {
        return goodsTypeMapper.add(goodsType);
    }

    @Override
    public int update(GoodsType goodsType) {
        return goodsTypeMapper.update(goodsType);
    }

    @Override
    public Map<String,Object> delete(int id) {
        Map<String,Object> hashmap=new HashMap<String,Object>();
        //判断有无关联数据
        if(goodsMapper.selectGoodsByTypeID(id).size()>0){
            hashmap.put("msg","id为"+id+"的类型下有关联商品，不允许删除");
        }else{
            if(goodsTypeMapper.delete(id)>0){
                hashmap.put("msg","成功删除id为"+id+"的类型");
            }else{
                hashmap.put("msg","删除失败");
            }
        }
        return hashmap;
    }

    @Override
    public List<GoodsType> selectByPage(int startIndex, int pageSize) {
        return goodsTypeMapper.selectByPage(startIndex,pageSize);
    }

    @Override
    public GoodsType selectAGoodsType(int id) {
        return goodsTypeMapper.selectAGoodsType(id);
    }
}
