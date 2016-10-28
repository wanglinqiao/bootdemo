package com.jyall.service;

import com.jyall.mapper.UserMapper;
import com.jyall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang.linqiao on 2016/10/21.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> userList(){
        return userMapper.userList();
    }
}
