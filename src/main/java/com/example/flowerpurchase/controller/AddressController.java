package com.example.flowerpurchase.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.flowerpurchase.model.Address;
import com.example.flowerpurchase.model.ShoppingCart;
import com.example.flowerpurchase.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        result.put("data", address);
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

    @RequestMapping("/api/address/{uid}")
    private JSONObject fetchAllByUid(@PathVariable long uid) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "获取成功";
        List<Address> list = addressRepository.findAllByUid(uid);
        JSONArray data = JSONArray.parseArray(JSON.toJSONString(list));
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    @PutMapping("/api/address/{id}")
    private JSONObject update(@PathVariable long id, @RequestBody JSONObject reqObj) {
        JSONObject result = new JSONObject();
        int code = 1;
        String msg = "修改成功";
        Address address = addressRepository.findById(id).get();
        address.setReceiver_name(reqObj.get("receiver_name").toString());
        address.setReceiver_phone(reqObj.get("receiver_phone").toString());
        address.setReceiver_province(reqObj.get("receiver_province").toString());
        address.setReceiver_city(reqObj.get("receiver_city").toString());
        address.setReceiver_district(reqObj.get("receiver_district").toString());
        address.setReceiver_address(reqObj.get("receiver_address").toString());
        address.setReceiver_zip(reqObj.get("receiver_zip").toString());
        addressRepository.save(address);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }
}
