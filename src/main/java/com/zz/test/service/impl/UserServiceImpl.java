package com.zz.test.service.impl;

import com.zz.test.entity.UserEntity;
import com.zz.test.mapper.UserMapper;
import com.zz.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public List<UserEntity> queryLimit(Integer currentPage, Integer pageSize) {
        return userMapper.queryLimit(currentPage, pageSize);
    }

    public Integer addUser(UserEntity user) {
        return userMapper.addUser(user);
    }

    public Integer updateUser(UserEntity user) {
        return userMapper.updateUser(user);
    }

    public Integer deleteUser(UserEntity user) {
        return userMapper.deleteUser(user);
    }

    public List<UserEntity> getAll() {
        return userMapper.getAll();
    }

}

