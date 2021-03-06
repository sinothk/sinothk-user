package com.sinothk.user.controller;

import com.sinothk.base.entity.ResultData;
import com.sinothk.base.utils.JWTUtil;
import com.sinothk.user.domain.UserEntity;
import com.sinothk.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @ApiOperation(value = "用户新增", notes = "用户新增")
    @PostMapping("/add")
    public ResultData<UserEntity> add(@ApiParam(value = "用户信息") @RequestBody UserEntity userEntity) {
        // http://localhost:11000/user/add
        return userService.add(userEntity);//ResultData.error("产出Id = ");
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
    public ResultData<UserEntity> login(@ApiParam(value = "account") @RequestParam("account") String account, @ApiParam(value = "password") @RequestParam("password") String password) {
        // http://localhost:11000/user/login
        return userService.login(account, password);
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @GetMapping("/getUserInfo")
    public ResultData<UserEntity> getUserInfo(@ApiParam(value = "token") @RequestHeader("token") String token) {
        // http://localhost:11000/user/getUserInfo
        String userName = JWTUtil.getUsername(token);
        return userService.getUserInfo(userName);
    }

    @GetMapping("/getUserInfoTest")
    public ResultData<UserEntity> getUserInfoTest() {
        // http://192.168.124.3:11000/user/getUserInfoTest ResultData.success("ok");//
        return userService.getUserInfo("liangyt");
    }

    @ApiOperation(value = "用户更新", notes = "用户更新")
    @PostMapping("/update")
    public ResultData<UserEntity> update(@ApiParam(value = "用户信息") @RequestBody UserEntity userEntity) {
        // http://localhost:11000/user/add
        return userService.update(userEntity);
    }
}
