package com.lwzy.mapper.admin;

import com.lwzy.bean.admin.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    //根据用户名和密码查询
    Admin login(String aname,String apwd);
}
