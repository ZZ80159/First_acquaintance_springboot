package com.zz.test.controller;

import com.zz.test.entity.UserEntity;
import com.zz.test.service.UserService;
import com.zz.test.utils.JsonResult;
import com.zz.test.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    String msg = "";
    String code = "";

    @PostMapping("/queryLimit")
    public JsonResult queryLimit(@RequestBody Integer currentPage, @RequestBody Integer pageSize) {

        List<UserEntity> userList = userService.queryLimit(currentPage, pageSize);
        code = "0";
        msg = "操作成功";
        return new JsonResult(code, msg, userList);
    }

//    @PostMapping("/getAll")
//    public JsonResult getAll() {
//        List<UserEntity> userList = userService.getAll();
//        code = "0";
//        msg = "操作成功";
//        return new JsonResult(code, msg, userList);
//    }

    @PostMapping("/getAll")
    public R getAll() {
        List<UserEntity> userList = userService.getAll();
        return R.ok().data("items", userList);
    }


    @PostMapping("/addUser")
    public JsonResult addUer(@RequestBody UserEntity user) {
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        try {
            if (userService.addUser(user) == 1) {
                msg = "增加用户成功";
                code = "0";
            }

        } catch (Exception exception) {
            msg = exception.toString();
            code = "1";
        }
        return new JsonResult(code, msg);
    }

    @PutMapping("/updateUser")
    public JsonResult updateUser(@RequestBody UserEntity user) {
        //Mybatis的更新操作成功返回1，用户不存在返回0，失败则抛异常
        try {
            msg = userService.updateUser(user) == 1 ? "更新用户成功" : "用户不存在，更新失败";
            code = "0";
        } catch (Exception exception) {
            msg = exception.toString();
            code = "1";
        }
        return new JsonResult(code, msg);
    }

    @DeleteMapping("/deleteUser")
    public JsonResult deleteUser(@RequestBody UserEntity user) {
        //Mybatis的删除操作和更新返回值一样，成功返回1，用户不存在返回0，失败则抛异常
        try {
            msg = userService.deleteUser(user) == 1 ? "删除用户成功" : "用户不存在，删除失败";
            code = "0";
        } catch (Exception exception) {
            msg = "删除异常";
            code = "1";
        }
        return new JsonResult(code, msg);
    }
}

