package com.lwzy.service.before;

import com.lwzy.bean.admin.Goods;
import com.lwzy.mapper.before.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements  IndexService{
    @Autowired
    IndexMapper indexMapper;
    @Override
    public List<Goods> selectAdviseGoods() {
        return indexMapper.selectAdviseGoods();
    }

    @Override
    public List<Goods> selectLatestGoods(int typeId) {
        return indexMapper.selectLatestGoods(typeId);
    }

    @Override
    public List<Goods> selectGoodsByKey(String name) {
        return indexMapper.selectGoodsByKey(name);
    }
}
