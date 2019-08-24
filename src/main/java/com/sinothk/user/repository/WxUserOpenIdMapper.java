package com.sinothk.user.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinothk.user.domain.UserEntity;
import com.sinothk.user.domain.WxUserOpenIdEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("wxUserOpenIdMapper")
public interface WxUserOpenIdMapper extends BaseMapper<WxUserOpenIdEntity> {

//    @Select("select u_account from tb_user")
//    Set<Long> getUserAccountSet();
}
