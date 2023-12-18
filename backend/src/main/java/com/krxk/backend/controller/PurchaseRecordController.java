package com.krxk.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.krxk.backend.entity.Inventory;
import com.krxk.backend.entity.Purchase_record;
import com.krxk.backend.entity.Sold_status;
import com.krxk.backend.entity.User;
import com.krxk.backend.mapper.InventoryMapper;
import com.krxk.backend.mapper.PurchaseRecordMapper;
import com.krxk.backend.mapper.SoldStatusMapper;
import com.krxk.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class PurchaseRecordController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;
    @Autowired
    private SoldStatusMapper soldStatusMapper; // 下单自动添加销售状态
    @Autowired
    private InventoryMapper inventoryMapper; // 判断库存是否充足

    private Boolean AssertUser(int id, String password) {
        User user = userMapper.selectById(id);
        if (password.equals(user.getPassword())) {
            return true; // 密码不正确
        } else {
            return false;
        }
    }
    @GetMapping("/purchase_record")
    public List<Purchase_record> findAllPurchaseRecord(int id, String password) {
        if(AssertUser(id, password) == false) {
            return null;
        }
        QueryWrapper<Purchase_record>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return purchaseRecordMapper.selectList(queryWrapper);
    }

    @PostMapping("/purchase_record")
    public String insertPurchaseRecord(int id, String password, Purchase_record purchaseRecord) {
        if(AssertUser(id, password) == false) {
            return "密码校验错误";
        }
        int totalGoodsNum = inventoryMapper.GetGoodsTotalNum(purchaseRecord.getGoods_id());
        if(purchaseRecord.getNum() > totalGoodsNum) {
            return "商品: " + purchaseRecord.getGoods_id() + " 供给不足。库存总量: " + totalGoodsNum;
        }

        int res = purchaseRecordMapper.insert(purchaseRecord);
        if(res > 0) {
            // 加入销售状态
            QueryWrapper<Inventory> inventoryQueryWrapper = new QueryWrapper<>();
//            inventoryQueryWrapper.select("shop_id", "goods_num");
            inventoryQueryWrapper.eq("goods_id", purchaseRecord.getGoods_id());
            List<Inventory> inventoryList = inventoryMapper.selectList(inventoryQueryWrapper);
//            System.out.println(inventoryList);

            int toBuy = purchaseRecord.getNum();
            int haveBuy;
            // 从每家商店购买
            for (Inventory Item : inventoryList) {
                int shop_goods_num = Item.getGoods_num();
                if(shop_goods_num == 0) {
                    continue;
                }
                if(toBuy <= shop_goods_num) {
                    shop_goods_num -= toBuy;
                    haveBuy = toBuy;
                    toBuy = 0;
                } else {
                    toBuy -= shop_goods_num;
                    haveBuy = shop_goods_num;
                    shop_goods_num = 0;
                }
                Item.setGoods_num(shop_goods_num);
                QueryWrapper<Inventory> tempQueryWrapper = new QueryWrapper<>();
                tempQueryWrapper.eq("shop_id", Item.getShop_id());
                tempQueryWrapper.eq("goods_id", Item.getGoods_id());
                inventoryMapper.update(Item, tempQueryWrapper); // 更新库存

                // 添加销售记录
                Sold_status soldStatus = new Sold_status();
                soldStatus.setShop_id(Item.getShop_id());
                soldStatus.setUser_id(purchaseRecord.getId());
                soldStatus.setGoods_id(purchaseRecord.getGoods_id());
                soldStatus.setNum(haveBuy);
                soldStatus.setDeal_time(new Date()); // 设置为当前时间
                soldStatusMapper.insert(soldStatus);

                if(toBuy <= 0) {
                    break;
                }
                System.out.println(toBuy);
            }

            return "购买成功";
        } else {
            return "购买失败";
        }
    }

}
