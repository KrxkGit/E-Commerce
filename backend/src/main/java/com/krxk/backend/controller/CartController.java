package com.krxk.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.krxk.backend.entity.Cart;
import com.krxk.backend.entity.User;
import com.krxk.backend.mapper.CartMapper;
import com.krxk.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private UserMapper userMapper;
    private Boolean AssertUser(int id, String password) {
        User user = userMapper.selectById(id);
        if (password.equals(user.getPassword())) {
            return true; // 密码不正确
        } else {
            return false;
        }
    }

    @GetMapping("/cart")
    public List<Cart> findAllCart(int id, String password) {
        if(AssertUser(id, password) == false) {
            return null;
        }

        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return cartMapper.selectList(queryWrapper);
    }

    @PostMapping("/cart")
    public String InsertCart(int id, String password, Cart cart) { // 增加购物车记录
        if(AssertUser(id, password) == false) {
            return "用户信息校验失败";
        }
        int res = cartMapper.insert(cart);
        if(res > 0) {
            return "购物车加入成功";
        } else {
            return "购物车加入失败";
        }
    }

    @DeleteMapping("/cart")
    public String DeleteCart(int id, String password, int goods_id) { // 删除购物车记录
        if(AssertUser(id, password) == false) {
            return "用户信息校验失败";
        }

        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        queryWrapper.eq("goods_id", goods_id);
        int res = cartMapper.delete(queryWrapper);
        if(res > 0) {
            return "购物车记录删除成功";
        } else {
            return "购物车记录删除失败";
        }
    }
}
