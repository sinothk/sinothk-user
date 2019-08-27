package com.sinothk.user.service;

import com.sinothk.user.domain.WxUserEntity;
import com.sinothk.user.domain.WxUserVo;

public interface WxUserService {

    WxUserEntity saveOrFindUser(WxUserVo wxApiEntity);

}
