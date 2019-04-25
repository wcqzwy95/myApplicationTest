package com.mybatis.generator.dao;

import com.mybatis.generator.entity.rolePermission;
import com.mybatis.generator.entity.rolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface rolePermissionMapper {
    int countByExample(rolePermissionExample example);

    int deleteByExample(rolePermissionExample example);

    int deleteByPrimaryKey(Integer rolepermissionid);

    int insert(rolePermission record);

    int insertSelective(rolePermission record);

    List<rolePermission> selectByExample(rolePermissionExample example);

    int updateByExampleSelective(@Param("record") rolePermission record, @Param("example") rolePermissionExample example);

    int updateByExample(@Param("record") rolePermission record, @Param("example") rolePermissionExample example);
}