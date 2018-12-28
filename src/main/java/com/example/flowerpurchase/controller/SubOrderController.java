package com.example.flowerpurchase.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.flowerpurchase.repository.SubOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubOrderController {
    @Autowired
    private SubOrderRepository subOrderRepository;

    @PostMapping("/api/sub-order/create")
    private Object create(@RequestBody JSONObject reqObj) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "创建成功";
        Object data = reqObj.get("data");
        
        return data;
    }
}
