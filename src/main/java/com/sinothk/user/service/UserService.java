package com.sinothk.user.service;

import com.sinothk.base.entity.ResultData;
import com.sinothk.user.domain.UserEntity;

public interface UserService {

    ResultData<UserEntity> add(UserEntity userEntity);

    ResultData<UserEntity> getUserInfo(String userName);

    ResultData<UserEntity> login(String account, String password);
}
