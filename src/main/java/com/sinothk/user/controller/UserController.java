package com.sinothk.user.controller;

import com.sinothk.base.entity.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
//    @Transactional
    public ResultData<String> userRegister(@RequestHeader("token") String token, @RequestHeader("token2") String token2) {
        // http://localhost:11000/user/add
        //

        System.out.println("token = " + token);
        System.out.println("token2 = " + token2);

//        UserEntity userEntity = new UserEntity();
//        userEntity.setUserName("liangyt");
////        userEntity.setUserPwd(password);
//        return roleService.addUser(userEntity);


        return ResultData.error("产出Id = ");
    }

    @GetMapping("/add2")
//    @Transactional
    public ResultData<String> add2() {
        // http://localhost:11000/user/add2
        //
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUserName("liangyt");
////        userEntity.setUserPwd(password);
//        return roleService.addUser(userEntity);


        return ResultData.error("Open 接口 = ");
    }
}
