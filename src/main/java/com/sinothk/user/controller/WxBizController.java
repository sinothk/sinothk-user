package com.sinothk.user.controller;

import com.alibaba.fastjson.JSON;
import com.sinothk.base.entity.ResultData;
import com.sinothk.user.config.KeyValue;
import com.sinothk.user.domain.WxApiEntity;
import com.sinothk.user.domain.WxUserEntity;
import com.sinothk.user.service.UserService;
import com.sinothk.user.service.WxUserService;
import com.sinothk.user.utils.HttpsClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "微信用户管理")
@RestController
@RequestMapping("/wxBiz")
public class WxBizController {

    @Resource(name = "wxUserService")
    private WxUserService wxUserService;

    @ApiOperation(value = "获得微信OpenId", notes = "获得微信OpenId")
    @GetMapping("/getOpenId")
    public ResultData<WxUserEntity> getOpenId(@ApiParam("code") @RequestParam("code") String code) {
        // http://192.168.124.12:11000/wxBiz/getOpenId

        Map<String, Object> ret = new HashMap<>();
        // 组装参数*****
        Map<String, String> urlData = new HashMap<>();
        urlData.put("appid", KeyValue.wx_appid);//小程序id
        urlData.put("secret", KeyValue.wx_secret);//小程序key
        urlData.put("grant_type", "authorization_code");//固定值这样写就行
        urlData.put("js_code", code);//小程序传过来的code

        try {
            String code2OpenidUrl = "https://api.weixin.qq.com/sns/jscode2session";
            String dataStr = new HttpsClientUtil().doGet(code2OpenidUrl, urlData);
            if (dataStr == null) {
                return ResultData.error("微信接口返回数据为空");
            }

            WxApiEntity wxApiEntity = JSON.parseObject(dataStr, WxApiEntity.class);
            WxUserEntity wxUserEntity = wxUserService.saveOrFindUser(wxApiEntity);

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
