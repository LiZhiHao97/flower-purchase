package com.example.flowerpurchase.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.flowerpurchase.model.OrderTable;
import com.example.flowerpurchase.repository.OrderTableRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class OrderTableController {
    @Autowired
    private OrderTableRepository orderTableRepository;

    @PostMapping("/api/order/create")
    private JSONObject create(@RequestBody JSONObject reqObj) {
        JSONObject result = new JSONObject();
        int code =1;
        String msg = "订单已生成";
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        OrderTable orderTable = new OrderTable(Integer.valueOf(reqObj.get("uid").toString()), reqObj.get("username").toString(), reqObj.get("phone").toString(), reqObj.get("address").toString(), df.format(day));
        orderTableRepository.save(orderTable);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    @RequestMapping("/api/order/{uid}")
    private JSONObject findAllByUid(@PathVariable long uid) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "获取成功";
        List<OrderTable> list = orderTableRepository.findAllByUid(uid);
        JSONArray data = JSONArray.parseArray(JSON.toJSONString(list));
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}
