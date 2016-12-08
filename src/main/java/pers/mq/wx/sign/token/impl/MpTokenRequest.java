package pers.mq.wx.sign.token.impl;

import com.google.common.base.Strings;

import com.alibaba.fastjson.JSON;

import java.util.Calendar;

import pers.mq.wx.model.AccessToken;
import pers.mq.wx.sign.token.TokenRequest;
import pers.mq.wx.utils.SignFileUtil;
import pers.mq.wx.utils.WebRequestUtil;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 16:45
 * 服务号请求token
 */
public class MpTokenRequest implements TokenRequest {

    @Override
    public AccessToken request(String appId, String secret) {
        Calendar now = Calendar.getInstance();
        StringBuffer addressSb = new StringBuffer();
        addressSb.append("https://api.weixin.qq.com/cgi-bin/token");
        addressSb.append("?grant_type=").append("client_credential");
        addressSb.append("&appid=").append(appId);
        addressSb.append("&secret=").append(addressSb.toString());
        String requestResult = WebRequestUtil.get(secret);
        AccessToken accessToken = null;
        if (!Strings.isNullOrEmpty(requestResult)) {
            accessToken = JSON.parseObject(requestResult, AccessToken.class);
            accessToken.setCreateTime(now.getTime());
            SignFileUtil.writeObject(accessToken, "token.data");
        }
        return accessToken;
    }
}