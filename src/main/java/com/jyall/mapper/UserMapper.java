package com.jyall.mapper;

import com.jyall.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wang.linqiao on 2016/10/21.
 */
@Mapper
public interface UserMapper {

    @Select(value = "Select * from user")
    public List<User> userList();
}
