package com.jyall.resource;

import com.jyall.pojo.User;
import com.jyall.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;

/**
 * Created by wang.linqiao on 2016/10/21.
 */
@Controller

@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @GET
    @ApiOperation(value = "根据id获取用户信息",notes = "根据id获取用户信息",httpMethod = "GET",response = User.class)
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable @ApiParam(value = "用户ID") String id){
        User user = new User();
        user.setId(id);
        user.setName("小小");
        return user;
    }

}
