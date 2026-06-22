package com.lwzy.service.before;

import com.lwzy.mapper.before.FocusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FocusServiceImpl implements  FocusService{
    @Autowired
    FocusMapper mapper;

    @Override
    public String focus(int userId, int goodsId) {
        //如果未登录则返回noLogin字符串
        if(userId==0){
            return "noLogin";
        }
        List<Map<String,Object>> mapList=mapper.select(userId,goodsId);
        //如果收藏过，返回no字符串
        if(mapList.size()>0){
            return "no";
        }else{
            //添加成功则返回ok，失败则返回fail
            if(mapper.add(userId,goodsId)>0){
                return "ok";
            }else{
                return  "fail";
            }
        }
    }
}
