package com.lwzy.service.before;

import com.lwzy.bean.before.Buser;
import com.lwzy.mapper.before.BuserMapper;
import com.lwzy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuserServiceImpl implements BuserService {
    @Autowired
    BuserMapper userMapper;
    @Override
    public String isUse(Buser buser) {
        if(userMapper.selectBuserByEmail(buser)!=null){
            return "no"; //查到已被用
        }else{
            return "ok";//没有使用
        }
    }

    @Override
    public int register(Buser buser) {
        //密码加密
        buser.setBpwd(MD5Util.MD5(buser.getBpwd()));
        return userMapper.register(buser);
    }

    @Override
    public Buser login(Buser user) {
        //将密码明文转成密文
        user.setBpwd(MD5Util.MD5(user.getBpwd()));
        Buser u=userMapper.selectBuser(user);
        //返回用户对象
        return u;
    }

    @Override
    public int updatebpwd(Buser user) {
        //将密码明文转成密文
        user.setBpwd(MD5Util.MD5(user.getBpwd()));
        return userMapper.updatebpwd(user);
    }


}
