package com.mybatis.generator.controller;

import com.mybatis.generator.enumUtil.MyExceptionEnum;
import com.mybatis.generator.service.intf.UserService;
import com.mybatis.generator.util.PlainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mybatis.generator.entity.user;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/addUser")
    public @ResponseBody PlainUtil<Boolean> addUser(String userName, String name, String password) {
        PlainUtil<Boolean> util = new PlainUtil<>();
        try {
            user user = new user();
            user.setPassword(password);
            user.setName(name);
            user.setUsername(userName);
            util = userService.addUser(user);
        } catch (Exception e) {
            util.setCode(MyExceptionEnum.UNkNOWN.getCode());
            util.setMessage(MyExceptionEnum.UNkNOWN.getMessage());
            util.setData(false);
        }
        return util;
    }
    @GetMapping("/queryUser")
    public @ResponseBody PlainUtil<user> queryUser(String userName, String password) {
        PlainUtil<user> util = userService.queryUser(userName, password);
        return util;
    }
}
