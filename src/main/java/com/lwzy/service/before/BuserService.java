package com.lwzy.service.before;

import com.lwzy.bean.before.Buser;
import com.lwzy.mapper.before.BuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface BuserService {
    //判断邮箱是否已被使用
    String isUse(Buser buser);
    //添加用户数据到表
    int register(Buser buser);
    //登录
    Buser login(Buser user);
    //修改密码
    int updatebpwd(Buser buser);
}
