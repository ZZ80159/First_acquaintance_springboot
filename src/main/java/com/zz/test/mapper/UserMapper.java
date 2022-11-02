package com.zz.test.mapper;

import com.zz.test.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserEntity> queryLimit(Integer currentPage, Integer pageSize);

    Integer addUser(UserEntity user);

    Integer updateUser(UserEntity user);

    Integer deleteUser(UserEntity user);

    List<UserEntity> getAll();

}
