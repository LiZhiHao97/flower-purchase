package com.example.flowerpurchase.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.flowerpurchase.model.SubOrder;
import com.example.flowerpurchase.repository.SubOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubOrderController {
    @Autowired
    private SubOrderRepository subOrderRepository;

    @PostMapping("/api/sub-order/create")
    private JSONObject create(@RequestBody List<JSONObject> data) {
        System.out.println("我在这呢");
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "创建成功";
        for(JSONObject item: data) {
            SubOrder subOrder = new SubOrder(Integer.valueOf(item.get("oid").toString()), Integer.valueOf(item.get("pid").toString()), item.get("pname").toString(), Integer.valueOf(item.get("price").toString()), Integer.valueOf(item.get("quantity").toString()));
            subOrderRepository.save(subOrder);
        }
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    @RequestMapping("/api/sub-order/{oid}")
    private JSONObject findAllByOid(@PathVariable long oid) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "获取成功";
        List<SubOrder> list = subOrderRepository.findAllByOid(oid);
        JSONArray data = JSONArray.parseArray(JSON.toJSONString(list));
        result.put("code", code);
        result.put("mgs", msg);
        result.put("data", data);
        return result;
    }
}
