package com.sinothk.user.service;

import com.sinothk.user.domain.WxApiEntity;
import com.sinothk.user.domain.WxUserEntity;

public interface WxUserService {

    WxUserEntity saveOrFindUser(WxApiEntity wxApiEntity);

}
