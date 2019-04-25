package com.mybatis.generator.dao;

import com.mybatis.generator.entity.user;
import com.mybatis.generator.entity.userExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface userMapper {
    int countByExample(userExample example);

    int deleteByExample(userExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(user record);

    int insertSelective(user record);

    List<user> selectByExample(userExample example);

    user selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") user record, @Param("example") userExample example);

    int updateByExample(@Param("record") user record, @Param("example") userExample example);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}