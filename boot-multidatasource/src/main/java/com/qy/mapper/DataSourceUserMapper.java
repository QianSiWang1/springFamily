package com.qy.mapper;

import com.qy.entity.DataSourceUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataSourceUserMapper {
    /**
     * 1、每个方法都在Mapper文件中有一个sql标签对应。
     * 2、所有参数都应该用@Param进行签名，以后使用指定的名字在SQL中取值
     * @param id
     * @return
     */
    DataSourceUser getUserById(@Param("id") Long id);

    List<DataSourceUser> getList();
}
