package com.krxk.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.krxk.backend.entity.Cart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
}
