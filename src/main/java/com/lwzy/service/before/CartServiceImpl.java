package com.lwzy.service.before;

import com.lwzy.bean.before.Cart;
import com.lwzy.mapper.before.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartMapper mapper;
    @Override
    public String putCart(Cart cart) {
        int result = 0;
        if (mapper.isExist(cart).size()==0){
          result = mapper.add(cart);
        }else {
           result = mapper.update(cart);
        }
        return result>0?"ok":"fail";
    }

    @Override
    public List<Map<String, Object>> select(int userId) {
        return mapper.select(userId);
    }

    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

    @Override
    public int clear(int userId) {
        return mapper.clear(userId);
    }

    @Override
    public List<Map<String, Object>> selectFocus(int userId) {
        return mapper.selectFocus(userId);
    }
}
