package com.mybatis.generator.service.intf;

import com.mybatis.generator.entity.user;
import com.mybatis.generator.util.PlainUtil;

public interface UserService {
    public PlainUtil<user> queryUser(String userName, String Password);
    public PlainUtil<Boolean> addUser(user user) throws Exception;
    public int updateUser(user user);
    public int deleteUser(int id);
}
