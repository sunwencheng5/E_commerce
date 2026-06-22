package com.lwzy.service.admin;

import com.lwzy.bean.admin.Goods;
import com.lwzy.mapper.admin.GoodsMapper;
import com.lwzy.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int add(Goods goods) {
        //图片文件上传
        MultipartFile mtf=goods.getGpictureForm();//获取文件内容
        String fileName=mtf.getOriginalFilename();//得到文件名
        if(fileName.length()>0){
            //重新设置一个10位数字的文件名,例：2345632123.png
            String fileNewName= MyUtil.getRandomStr(10)+fileName.substring(fileName.lastIndexOf("."));
            //设置图片上传路径
            String realPath="D:\\24软2孙文成\\孙文成\\demo\\src\\main\\webapp\\static\\images";
            //创建文件对象
            File dirUp=new File(realPath,fileNewName);
            try{
                mtf.transferTo(dirUp);//上传文件
            }catch(IllegalStateException | IOException e){
                e.printStackTrace();
            }
            //设置商品对象的文件名
            goods.setGpicture(fileNewName);
        }

        return goodsMapper.add(goods);
    }

    @Override
    public int update(Goods goods) {
        //图片文件上传
        MultipartFile mtf=goods.getGpictureForm();//获取文件内容
        String fileName=mtf.getOriginalFilename();//得到文件名
        if(fileName.length()>0){
            //重新设置一个10位数字的文件名,例：2345632123.png
            String fileNewName= MyUtil.getRandomStr(10)+fileName.substring(fileName.lastIndexOf("."));
            //设置图片上传路径
            String realPath="D:\\24软2孙文成\\孙文成\\demo\\src\\main\\webapp\\static\\images";
            //创建文件对象
            File dirUp=new File(realPath,fileNewName);
            try{
                mtf.transferTo(dirUp);//上传文件
            }catch(IllegalStateException | IOException e){
                e.printStackTrace();
            }
            //设置商品对象的文件名
            goods.setGpicture(fileNewName);
        }
        return goodsMapper.update(goods);
    }

    @Override
    public Map<String,Object> delete(int id) {
        Map<String,Object> hashmap=new HashMap<String,Object>();
        //判断有无关联数据
        if(goodsMapper.selectCart(id).size()>0 ||
           goodsMapper.selectFocus(id).size()>0 ||
           goodsMapper.selectOrder(id).size()>0){
            hashmap.put("msg","id为"+id+"的商品有关联数据，不允许删除");
        }else{
            if(goodsMapper.delete(id)>0){
                hashmap.put("msg","成功删除id为"+id+"的商品");
            }else{
                hashmap.put("msg","删除失败");
            }
        }
        return hashmap;
    }

    @Override
    public List<Goods> select() {
        return goodsMapper.select();
    }

    @Override
    public List<Goods> selectByPage(int startIndex, int pageSize) {
        return goodsMapper.selectByPage(startIndex, pageSize);
    }

    @Override
    public Goods selectAGoods(int id) {
        return goodsMapper.selectAGoods(id);
    }
}
