package com.example.flowerpurchase.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.flowerpurchase.model.ShoppingCart;
import com.example.flowerpurchase.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @PostMapping("/api/shopping-cart/create")
    private JSONObject create(@RequestBody JSONObject reqObj) {
        JSONObject result = new JSONObject();
        String msg = "购物车添加成功";
        int code = 1;
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ShoppingCart shoppingCart = new ShoppingCart(Integer.valueOf(reqObj.get("uid").toString()), Integer.valueOf(reqObj.get("pid").toString()), 1, Integer.valueOf(reqObj.get("checked").toString()), df.format(day));
        shoppingCartRepository.save(shoppingCart);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    @DeleteMapping("/api/shopping-cart/{id}")
    private JSONObject delete(@PathVariable long id) {
        JSONObject result = new JSONObject();
        String msg = "删除成功";
        int code = 1;
        shoppingCartRepository.deleteById(id);
        result.put("code", 1);
        result.put("msg", msg);
        return result;
    }

    @RequestMapping("/api/shopping-cart/{id}")
    private JSONObject fetchAllById(@PathVariable long id) {
        JSONObject result = new JSONObject();
        String msg = "获取成功";
        int code = 1;
        List<ShoppingCart> list = shoppingCartRepository.findAllByUid(id);
        JSONArray data = JSONArray.parseArray(JSON.toJSONString(list));
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    @PutMapping("/api/shopping-cart/{id}/{quantity}")
    private JSONObject updateQuantity(@PathVariable long id, @PathVariable int quantity) {
        JSONObject result = new JSONObject();
        String msg = "修改数量成功";
        int code = 1;
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
        shoppingCart.setQuantity(quantity);
        shoppingCartRepository.save(shoppingCart);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }
}
