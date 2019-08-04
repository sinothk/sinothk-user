package com.sinothk.user.controller;

import com.sinothk.base.entity.ResultData;
import com.sinothk.base.utils.AccountUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
//    @Transactional
    public ResultData<String> userRegister() {
        // http://localhost:11000/sinothk-user/user/add
        //


//        UserEntity userEntity = new UserEntity();
//        userEntity.setUserName("liangyt");
////        userEntity.setUserPwd(password);
//        return roleService.addUser(userEntity);

        return ResultData.error("产出Id = ");
    }
}
