package com.mybatis.generator.dao;

import com.mybatis.generator.entity.userRole;
import com.mybatis.generator.entity.userRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userRoleMapper {
    int countByExample(userRoleExample example);

    int deleteByExample(userRoleExample example);

    int deleteByPrimaryKey(Integer userroleid);

    int insert(userRole record);

    int insertSelective(userRole record);

    List<userRole> selectByExample(userRoleExample example);

    int updateByExampleSelective(@Param("record") userRole record, @Param("example") userRoleExample example);

    int updateByExample(@Param("record") userRole record, @Param("example") userRoleExample example);
}