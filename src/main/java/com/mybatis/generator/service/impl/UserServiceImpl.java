package com.mybatis.generator.service.impl;

import com.mybatis.generator.enumUtil.MyExceptionEnum;
import com.mybatis.generator.service.intf.UserService;
import com.mybatis.generator.entity.user;
import com.mybatis.generator.dao.userMapper;
import com.mybatis.generator.util.Md5Encryption;
import com.mybatis.generator.util.PlainUtil;
import com.mybatis.generator.util.RandomNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mybatis.generator.entity.userExample;
@Service("userService")
public class UserServiceImpl implements UserService {
    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    public userMapper userMapper;
    @Override
    public PlainUtil<user> queryUser(String userName, String Password) {
        PlainUtil<user> util = new PlainUtil<>();
        userExample userExample = new userExample();
        userExample.createCriteria().andUsernameEqualTo(userName);
        List<user> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            util.setMessage(MyExceptionEnum.USER_NAME_DOS_NOT_EXIST.getMessage());
            util.setCode(MyExceptionEnum.USER_NAME_DOS_NOT_EXIST.getCode());
            LOGGER.error("UserServiceImpl.queryUser is userNameDosNotExist={}, userName={} ", "", userName);
        }
        users.stream().forEach(user -> {
            String salt = user.getSalt();
            String saltMD = RandomNumber.getSaltMD(Password, salt);
            String[] split = saltMD.split(",");
            if (user.getPassword().equals(split[0])) {
                util.setData(user);
                util.setMessage(MyExceptionEnum.SUCCESS.getMessage());
                util.setCode(MyExceptionEnum.SUCCESS.getCode());
                LOGGER.info("UserServiceImpl.queryUser is success={}, userName={}, password={}, user=%s", "", userName, Password, user);
            } else {
                util.setMessage(MyExceptionEnum.PASSWORD_DOS_NOT_EXIST.getMessage());
                util.setCode(MyExceptionEnum.PASSWORD_DOS_NOT_EXIST.getCode());
                LOGGER.error("UserServiceImpl.queryUser is passwordDosNotExist={}, password={}", "", Password);
            }
        });
        return util;
    }

    @Override
    public PlainUtil<Boolean> addUser(user user) throws Exception{
        PlainUtil<Boolean> util = new PlainUtil<>();
        String password = user.getPassword();

        String saltMD = RandomNumber.getSaltMD(password, null);

        String[] split = saltMD.split(",");
        user.setPassword(split[0]);
        user.setSalt(split[1]);

        String username = user.getUsername();

        userExample userExample = new userExample();
        userExample.createCriteria().andNameGreaterThanOrEqualTo(username);
        List<com.mybatis.generator.entity.user> users = userMapper.selectByExample(userExample);
        if (users.size()>0) {
            util.setMessage(MyExceptionEnum.ALREADY_EXIST.getMessage());
            util.setCode(MyExceptionEnum.ALREADY_EXIST.getCode());
            util.setData(false);
            return util;
        }
        user.setStarttime(new Date());
        user.setModificationtime(new Date());
        user.setUserroleid(1);
        int insert = userMapper.insert(user);
        if (insert<0) {
            throw new Exception("用户注册失败");
        }
        util.setData(true);
        util.setCode(MyExceptionEnum.SUCCESS.getCode());
        util.setMessage(MyExceptionEnum.SUCCESS.getMessage());
        return util;
    }

    @Override
    public int updateUser(user user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}
