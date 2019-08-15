package com.sinothk.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinothk.base.entity.ResultData;
import com.sinothk.base.utils.JWTUtil;
import com.sinothk.base.utils.StringUtil;
import com.sinothk.user.domain.UserEntity;
import com.sinothk.user.repository.UserMapper;
import com.sinothk.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServerImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public ResultData<Boolean> add(UserEntity userEntity) {
        userMapper.insert(userEntity);
        return ResultData.success(true);
    }

    @Override
    public ResultData<UserEntity> login(String account, String password) {

        if (StringUtil.isEmpty(account)) {
            return ResultData.error("账号不能为空");
        }

        if (StringUtil.isEmpty(password)) {
            return ResultData.error("密码不能为空");
        }

        UserEntity dbUser = selectUserByUsername(account);
        if (dbUser == null) {
            return ResultData.error("用户不存在");
        }

        if (!password.equals(dbUser.getUserPwd())) {
            return ResultData.error("密码不正确");
        }

        String token = JWTUtil.sign(account, password);
        dbUser.setToken(token);

        return ResultData.success(dbUser);
    }

    private UserEntity selectUserByUsername(String account) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserEntity::getUserName, account);
        try {
            List<UserEntity> userList = userMapper.selectList(wrapper);
            if (userList == null) {
                return null;
            }
            if (userList.size() != 1) {
                return null;
            }
            return userList.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ResultData<UserEntity> getUserInfo(String userName) {
        UserEntity userEntity = selectUserByUsername(userName);
        return ResultData.success(userEntity);
    }
}
