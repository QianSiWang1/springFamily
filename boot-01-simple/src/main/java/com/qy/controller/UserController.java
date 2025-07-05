package com.qy.controller;

import com.qy.entity.User;
import com.qy.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Tag(name = "用户接口")
@Slf4j
public class UserController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    StringRedisTemplate redisTemplate;


    /**
     * 返回User的json数据
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    @Operation(summary = "根据id查询用户")
    public User getUser(@PathVariable("id") Long id){
        User userById = userMapper.getUserById(id);
        System.out.println(userById);
        return userById;
    }

    @GetMapping("/user/users")
    @Operation(summary = "查询所有")
    public User getUsers(){
        User userById = userMapper.getList();
        System.out.println(userById);
        log.info("查询所有");
        return userById;
    }

    @GetMapping("/incr")
    @Operation(summary = "redis自增")
    public String incr(){
        Long haha = redisTemplate.opsForValue().increment("haha");
        return "增加后的值："+haha;
    }
}
