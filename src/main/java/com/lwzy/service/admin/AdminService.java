package com.lwzy.service.admin;

import com.lwzy.bean.admin.Admin;

public interface AdminService {
    //根据用户名和密码查询
    Admin login(String aname, String apwd);
}
