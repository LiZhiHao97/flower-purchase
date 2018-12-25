package com.example.flowerpurchase.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.flowerpurchase.model.Address;
import com.example.flowerpurchase.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/api/address/add")
    private JSONObject add(@RequestBody JSONObject reqObj) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "地址添加成功";
        Address address = new Address(Integer.valueOf(reqObj.get("uid").toString()), reqObj.get("receiver_name").toString(), reqObj.get("receiver_phone").toString(), reqObj.get("receiver_province").toString(), reqObj.get("receiver_city").toString(), reqObj.get("receiver_district").toString(), reqObj.get("receiver_address").toString(), reqObj.get("receiver_zip").toString());
        addressRepository.save(address);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    @DeleteMapping("/api/address/{id}")
    private JSONObject delete(@PathVariable long id) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "删除成功";
        addressRepository.deleteById(id);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }
}
