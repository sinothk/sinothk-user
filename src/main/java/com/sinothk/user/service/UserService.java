package com.sinothk.user.service;

import com.sinothk.base.entity.ResultData;
import com.sinothk.user.domain.UserEntity;

public interface UserService {

    ResultData<Boolean> add(UserEntity userEntity);

    ResultData<UserEntity> getUserInfo(String userName);
}
