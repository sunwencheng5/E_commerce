package com.lwzy.bean.admin;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Goods {
    private int id;
    private String gname;
    private double goprice;
    private double grprice;
    private int gstore;
    private MultipartFile gpictureForm;//图片内容
    private String gpicture;//图片文件名称
    private GoodsType type;
    private int isshow;
}
