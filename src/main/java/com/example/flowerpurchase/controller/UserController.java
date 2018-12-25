package com.example.flowerpurchase.controller;

import com.example.flowerpurchase.model.User;
import com.example.flowerpurchase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/user/register")
    private JSONObject register(@RequestBody JSONObject reqObj) {
        JSONObject result = new JSONObject();
        String msg = "注册成功";
        if (userRepository.findByUsername(reqObj.get("username").toString()) != null) {
            msg = "该用户已存在";
            result.put("code", 0);
            result.put("msg", msg);
            return result;
        }
        Random rand = new Random();
        User user = new User(reqObj.get("username").toString(), reqObj.get("password").toString(), reqObj.get("sex").toString(), reqObj.get("email").toString(), rand.nextInt(10));
        userRepository.save(user);
        result.put("code", 1);
        result.put("msg", msg);
        return result;
    }

    @PostMapping("/api/user/login")
    private JSONObject login(@RequestBody JSONObject reqObj, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String msg = "登录成功";
        int code = 1;
        User user = userRepository.findByUsername(reqObj.get("username").toString());
        if (user == null) {
            msg = "该用户不存在";
            code = 0;
        } else {
            if (!user.getPassword().equals(reqObj.get("password").toString())) {
                msg = "密码不正确，请重新输入";
            } else {
                Cookie cookie = new Cookie("username", String.valueOf(user.getId()));
                cookie.setPath("/");
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
            }
        }
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    @RequestMapping("/api/user/{userid}")
    private JSONObject findById(@PathVariable long userid) {
        User user = userRepository.findById(userid).get();
        String jsonStr = JSON.toJSONString(user);
        return JSONObject.parseObject(jsonStr);
    }
}
