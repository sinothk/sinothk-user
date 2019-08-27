package com.sinothk.user.controller;

import com.alibaba.fastjson.JSON;
import com.sinothk.base.entity.ResultData;
import com.sinothk.user.domain.WxApiEntity;
import com.sinothk.user.domain.WxUserEntity;
import com.sinothk.user.domain.WxUserVo;
import com.sinothk.user.service.WxUserService;
import com.sinothk.user.utils.wx.WxUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "微信用户管理")
@RestController
@RequestMapping("/wxBiz")
public class WxBizController {

    @Resource(name = "wxUserService")
    private WxUserService wxUserService;

    @ApiOperation(value = "获得微信OpenId", notes = "获得微信OpenId")
    @GetMapping("/getOpenId")
    @Deprecated
    public ResultData<WxApiEntity> getOpenId(@ApiParam("code") @RequestParam("code") String code) {
        // http://192.168.124.12:11000/wxBiz/getOpenId
        try {
            String wxDataStr = WxUtil.getOpenID(code);
            WxApiEntity wxApiEntity = JSON.parseObject(wxDataStr, WxApiEntity.class);
            return ResultData.success(wxApiEntity);
        } catch (Exception ex) {
            return ResultData.error("获取WxOpenId数据异常");
        }
    }

    @ApiOperation(value = "通过微信code", notes = "通过微信code")
    @PostMapping("/loginByWx")
    public ResultData<WxUserEntity> loginByWx(@ApiParam("wxUserVo") @RequestBody WxUserVo wxUserVo) {
        // http://192.168.124.12:11000/wxBiz/loginByWx
        try {
            WxUserEntity wxUserEntity = wxUserService.saveOrFindUser(wxUserVo);
            if (wxUserEntity == null) {
                return ResultData.error("数据解析为空");
            } else {
                return ResultData.success(wxUserEntity);
            }
        } catch (Exception ex) {
            return ResultData.error("数据访问或解析异常");
        }
    }
}
