package com.sinothk.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinothk.user.domain.UserEntity;
import com.sinothk.user.domain.WxApiEntity;
import com.sinothk.user.domain.WxUserEntity;
import com.sinothk.user.domain.WxUserOpenIdEntity;
import com.sinothk.user.repository.UserMapper;
import com.sinothk.user.repository.WxUserOpenIdMapper;
import com.sinothk.user.service.WxUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("wxUserService")
public class WxUserServiceImpl implements WxUserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Resource(name = "wxUserOpenIdMapper")
    private WxUserOpenIdMapper wxUserOpenIdMapper;

    @Override
    public WxUserEntity saveOrFindUser(WxApiEntity wxApiEntity) {
        QueryWrapper<WxUserOpenIdEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(WxUserOpenIdEntity::getOpenId, wxApiEntity.getOpenid());

        // 查询用户是否存在
        WxUserOpenIdEntity wxUserOpenIdEntity = wxUserOpenIdMapper.selectOne(wrapper);
        if (wxUserOpenIdEntity == null) {
            // 不存在注册



            return null;
        } else {
            try { // 用户已存在
                QueryWrapper<UserEntity> userWrapper = new QueryWrapper<>();
                userWrapper.lambda().eq(UserEntity::getAccount, wxUserOpenIdEntity.getAccount());
                // 找到用户信息并赋值
                UserEntity userEntity = userMapper.selectOne(userWrapper);
                WxUserEntity wxUserEntity = new WxUserEntity();
                BeanUtils.copyProperties(userEntity, wxUserEntity);
                // 设置微信信息
                wxUserEntity.setOpenId(wxUserOpenIdEntity.getOpenId());
                wxUserEntity.setSession_key(wxApiEntity.getSession_key());
                return wxUserEntity;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
