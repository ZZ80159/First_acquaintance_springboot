package com.zz.test.service;

import com.zz.test.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> queryLimit(Integer currentPage, Integer pageSize);
    Integer addUser(UserEntity user);
    Integer updateUser(UserEntity user);
    Integer deleteUser(UserEntity user);
    List<UserEntity> getAll();
}
