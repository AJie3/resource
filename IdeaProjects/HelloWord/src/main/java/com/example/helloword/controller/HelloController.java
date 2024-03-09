package com.example.helloword.controller;

import com.example.helloword.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String name){
        return "你真牛啊啊啊" + name;
    }

    @RequestMapping("/Test")
    public String test(String username, String phone){
        System.out.println(username);
        System.out.println(phone);
        return "成功";
    }

    @RequestMapping("/Test1")
    public String test1(@RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPhone());
        return "成功";
    }
}
