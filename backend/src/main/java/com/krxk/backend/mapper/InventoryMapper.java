package com.krxk.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.krxk.backend.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InventoryMapper extends BaseMapper<Inventory> {
    @Select("select sum(goods_num) from `shop_inventory` where goods_id=#{goods_id}")
    int GetGoodsTotalNum(int goods_id);
}
