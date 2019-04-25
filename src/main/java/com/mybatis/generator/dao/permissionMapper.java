package com.mybatis.generator.dao;

import com.mybatis.generator.entity.permission;
import com.mybatis.generator.entity.permissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface permissionMapper {
    int countByExample(permissionExample example);

    int deleteByExample(permissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(permission record);

    int insertSelective(permission record);

    List<permission> selectByExample(permissionExample example);

    permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") permission record, @Param("example") permissionExample example);

    int updateByExample(@Param("record") permission record, @Param("example") permissionExample example);

    int updateByPrimaryKeySelective(permission record);

    int updateByPrimaryKey(permission record);
}