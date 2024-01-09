package com.krxk.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user_cart")
public class Cart {
    private int id;
    private int goods_id;
    private int num;


    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
