package com.ssm.service.impl;

import com.ssm.dao.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huangcr02 on 2017/1/23 023.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
