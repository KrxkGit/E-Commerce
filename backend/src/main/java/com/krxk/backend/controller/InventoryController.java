package com.krxk.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.krxk.backend.entity.Inventory;
import com.krxk.backend.entity.Shop;
import com.krxk.backend.mapper.InventoryMapper;
import com.krxk.backend.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private InventoryMapper inventoryMapper;

    private Boolean AssertShopInfo(int shop_id, String password) {
        Shop shop = shopMapper.selectById(shop_id);
        if(shop.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping("/inventory")
    public List<Inventory> findInventory(int shop_id, String password) {
        if(AssertShopInfo(shop_id, password) == false) {
            return null;
        }
        QueryWrapper<Inventory>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shop_id", shop_id);
        return inventoryMapper.selectList(queryWrapper);
    }

    @GetMapping("/all_inventory")
    public IPage<Inventory> findAllInventory(int start, int pages) {
        Page<Inventory> page = new Page<>(start, pages);
        return inventoryMapper.selectPage(page, null);
    }

    @PostMapping("/inventory")
    public String AddInventory(int shop_id, String password, Inventory inventory) {
        if(AssertShopInfo(shop_id, password) == false) {
            return "商家信息校验失败";
        }
        int res = inventoryMapper.insert(inventory);
        if(res > 0) {
            return "库存信息加入成功";
        } else {
            return "库存信息加入失败";
        }
    }

    @DeleteMapping("/inventory")
    public String DelInventory(int shop_id, String password, int goods_id) {
        if(AssertShopInfo(shop_id, password) == false) {
            return "商家信息校验失败";
        }
        QueryWrapper<Inventory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shop_id", shop_id);
        queryWrapper.eq("goods_id", goods_id);
        int res =  inventoryMapper.delete(queryWrapper);
        if (res > 0) {
            return "删除库存成功";
        } else {
            return "删除库存失败";
        }
    }

    @PutMapping("/inventory")
    public String UpdateInventoryNum(int shop_id, String password, int goods_id, String goods_name, int goods_num) {
        if(AssertShopInfo(shop_id, password) == false) {
            return "商家信息校验失败";
        }
        QueryWrapper<Inventory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shop_id", shop_id);
        queryWrapper.eq("goods_id", goods_id);
        Inventory inventory = inventoryMapper.selectOne(queryWrapper);
        if(inventory == null) {
            return "修改信息失败";
        }
        inventory.setGoods_num(goods_num);
        inventory.setGoods_name(goods_name);
        inventoryMapper.update(inventory, queryWrapper); // 由于mybatis-plus 默认不支持复合主键，为了简单采用此方法
        return "库存信息修改成功";
    }
}
