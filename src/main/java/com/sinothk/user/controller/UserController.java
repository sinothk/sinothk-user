package com.sinothk.user.controller;

import com.sinothk.base.entity.ResultData;
import com.sinothk.base.utils.JWTUtil;
import com.sinothk.user.domain.UserEntity;
import com.sinothk.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;


    @GetMapping("/add")
    public ResultData<Boolean> add(UserEntity userEntity) {
        // http://localhost:11000/user/add
        return userService.add(userEntity);//ResultData.error("产出Id = ");
    }

    @GetMapping("/getUserInfo")
    public ResultData<UserEntity> getUserInfo(@RequestHeader("token") String token) {
        // http://localhost:11000/user/getUserInfo
        String userName = JWTUtil.getUsername(token);
        return userService.getUserInfo(userName);
    }

    @GetMapping("/add2")
//    @Transactional
    public ResultData<String> add2(@RequestHeader("token") String token, @RequestHeader("userName") String userName) {
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
