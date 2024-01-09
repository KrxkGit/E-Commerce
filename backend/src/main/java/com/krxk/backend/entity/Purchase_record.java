package com.krxk.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("purchase_record")
public class Purchase_record {
    // 只关心商品的id，而不关心在哪个shop购买了该商品，故无 shop_id
    private int id;
    private int goods_id;
    private int num;
    private Date transaction_time;

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

    public Date getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(Date transaction_time) {
        this.transaction_time = transaction_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
