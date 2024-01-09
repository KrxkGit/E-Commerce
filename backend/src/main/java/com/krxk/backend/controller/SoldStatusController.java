package com.krxk.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.krxk.backend.entity.Shop;
import com.krxk.backend.entity.Sold_status;
import com.krxk.backend.mapper.ShopMapper;
import com.krxk.backend.mapper.SoldStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SoldStatusController {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private SoldStatusMapper soldStatusMapper;

    private Boolean AssertShopInfo(int shop_id, String password) {
        Shop shop = shopMapper.selectById(shop_id);
        if(shop.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping("/sold_status")
    public List<Sold_status> findAllSoldStatus(int shop_id, String password) {
        if(AssertShopInfo(shop_id, password) == false) {
            return null;
        }
        QueryWrapper<Sold_status>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shop_id", shop_id);
        return soldStatusMapper.selectList(queryWrapper);
    }

//    @PostMapping("/sold_status")
//    public String addSoldStatus(Sold_status soldStatus) {
////        if(AssertShopInfo(shop_id, password) == false) {
////            return "信息校验错误";
////        }
//        int res = soldStatusMapper.insert(soldStatus);
//        if(res > 0) {
//            return "销售状态插入成功";
//        } else {
//            return "销售状态插入失败";
//        }
//    }
}
