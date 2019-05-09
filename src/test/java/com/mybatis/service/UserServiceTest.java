package com.mybatis.service;

import com.mybatis.generator.entity.user;
import com.mybatis.generator.service.intf.UserService;
import com.mybatis.generator.util.PlainUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.test4j.junit.Test4J;

public class UserServiceTest extends Test4J {
    @Autowired
    private UserService userService;

    @Before
    public void init() {
        db.table("user").clean().insert(3, new DataMap(){
            {
                this.put("id", 1, 2, 3);
                this.put("username", "dali", "dage", "dashuai");
                this.put("name", "ziji", "shijian", "zhuantai");
                this.put("password", "123", "1234", "4784");
                this.put("salt", "33343", "345454", "34356");
            }
        });
    }
    @Test
    public void queryUser() {
        PlainUtil<user> dali = userService.queryUser("dali", "123");
        want.object(dali).notNull();
    }
}
