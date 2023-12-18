package com.krxk.backend.controller;

import com.krxk.backend.entity.Shop;
import com.krxk.backend.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    @Autowired
    private ShopMapper shopMapper;
    @GetMapping("/shop")
    public String FindShopById(int shop_id, String password) { // 商家登录
        Shop shop = shopMapper.selectById(shop_id);
        if(shop.getPassword().equals(password)) {
            return "登录成功";
        } else {
            return "登录失败";
        }
    }

    @PostMapping("/shop")
    public String InsertShop(Shop shop) { // 商家注册
        int res = shopMapper.insert(shop);
        if(res > 0) {
            return "商家注册成功";
        } else {
            return "商家注册失败";
        }
    }
}
