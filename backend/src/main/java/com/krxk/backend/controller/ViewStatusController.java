package com.krxk.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.krxk.backend.entity.Shop;
import com.krxk.backend.entity.View_status;
import com.krxk.backend.mapper.ShopMapper;
import com.krxk.backend.mapper.ViewStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewStatusController {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ViewStatusMapper viewStatusMapper;

    private Boolean AssertShopInfo(int shop_id, String password) {
        Shop shop = shopMapper.selectById(shop_id);
        if(shop.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping("/view_status")
    public List<View_status> findAllViewStatus(int shop_id, String password) {
        if(AssertShopInfo(shop_id, password) == false) {
            return null;
        }
        QueryWrapper<View_status>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shop_id", shop_id);
        return viewStatusMapper.selectList(queryWrapper);
    }

    @PostMapping("/view_status")
    public String addViewStatus(int shop_id, View_status viewStatus) {
//        if(AssertShopInfo(shop_id, password) == false) {
//            return "信息校验错误";
//        }
        int res = viewStatusMapper.insert(viewStatus);
        if(res > 0) {
            return "浏览记录插入成功";
        } else {
            return "浏览记录插入失败";
        }
    }
}
