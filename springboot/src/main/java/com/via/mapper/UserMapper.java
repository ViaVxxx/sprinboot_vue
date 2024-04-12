package com.via.mapper;

import com.via.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository // @Repository 表示这是一个持久层的bean，用来访问数据库
public interface UserMapper extends Mapper<User> {

    @Select("select * from user")
    List<User> getUser();
}
