package com.lwzy.bean.admin;

import com.lwzy.bean.before.Buser;
import lombok.Data;

@Data
public class Order {
    private int id;
    private Buser user;
    private double amount;
    private int status;
    private String orderdate;
}
