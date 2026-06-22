package com.lwzy.service.admin;

import com.lwzy.bean.admin.Admin;
import com.lwzy.mapper.admin.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin login(String aname, String apwd) {
        return adminMapper.login(aname,apwd);
    }
}
