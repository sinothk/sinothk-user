package com.sinothk.user.service.impl;


import com.sinothk.base.entity.ResultData;
import com.sinothk.user.domain.UserEntity;
import com.sinothk.user.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServerImpl implements UserService {

    @Override
    public ResultData<Boolean> add(UserEntity userEntity) {
        return ResultData.success(true);
    }

    @Override
    public ResultData<UserEntity> getUserInfo(String userName) {
        return ResultData.success(new UserEntity());
    }
}
