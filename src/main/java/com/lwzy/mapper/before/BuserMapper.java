package com.lwzy.mapper.before;

import com.lwzy.bean.before.Buser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuserMapper {
    //根据邮箱地址查询用户
    Buser selectBuserByEmail(Buser buser);
    //添加用户数据到表
    int register(Buser buser);
    //查询是否存在用户
    Buser selectBuser(Buser buser);
    //修改用户密码
    int updatebpwd(Buser buser);
}
