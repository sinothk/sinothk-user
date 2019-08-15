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

    @GetMapping("/add2")
//    @Transactional
    public ResultData<String> add2(@ApiParam(value = "token") @RequestHeader("token") String token, @RequestHeader("userName") String userName) {
        // http://localhost:11000/user/add2
        //
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUserName("liangyt");
////        userEntity.setUserPwd(password);
//        return roleService.addUser(userEntity);

        System.out.println("token = " + token);
        System.out.println("userName = " + userName);

        return ResultData.error("Open 接口 = ");
    }
}
