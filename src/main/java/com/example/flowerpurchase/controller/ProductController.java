package com.example.flowerpurchase.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.flowerpurchase.model.Product;
import com.example.flowerpurchase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/api/product/create")
    private JSONObject create(@RequestBody JSONObject reqObj) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "商品上架成功";
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Product product = new Product(reqObj.get("name").toString(), reqObj.get("description").toString(), reqObj.get("img").toString(), Integer.valueOf(reqObj.get("price").toString()), Integer.valueOf(reqObj.get("status").toString()), df.format(day));
        productRepository.save(product);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    @DeleteMapping("/api/product/{id}")
    private JSONObject delete(@PathVariable long id) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "删除成功";
        productRepository.deleteById(id);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    @RequestMapping("/api/product/{name}")
    private JSONObject select(@PathVariable String name) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "查询成功";
        List<Product> list = productRepository.findByNameLike("%" + name + "%");
        JSONArray data = JSONArray.parseArray(JSON.toJSONString(list));
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    @RequestMapping("/api/product")
    private JSONObject fetchAll() {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "获取成功";
        List<Product> list = productRepository.findAll();
        JSONArray data = JSONArray.parseArray(JSON.toJSONString(list));
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    @RequestMapping("/api/product/id/{id}")
    private JSONObject fetchById(@PathVariable long id) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "获取成功";
        Product product = productRepository.findById(id).get();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", product);
        return result;
    }
}
