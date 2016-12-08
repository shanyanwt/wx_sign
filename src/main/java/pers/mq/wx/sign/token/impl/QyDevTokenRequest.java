package pers.mq.wx.sign.token.impl;

import com.google.common.base.Strings;

import com.alibaba.fastjson.JSON;

import java.util.Calendar;

import pers.mq.wx.model.AccessToken;
import pers.mq.wx.sign.token.TokenRequest;
import pers.mq.wx.utils.WebRequestUtil;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public class QyDevTokenRequest implements TokenRequest {

    @Override
    public AccessToken request(String corpid, String corpsecret) {
        Calendar now = Calendar.getInstance();
        StringBuffer addressSb = new StringBuffer();
        addressSb.append("https://qyapi.weixin.qq.com/cgi-bin/gettoken");
        addressSb.append("?corpid=").append(corpid);
        addressSb.append("&corpsecret=").append(corpsecret);
        String requestResult = WebRequestUtil.get(addressSb.toString());
        AccessToken accessToken = null;
        if (!Strings.isNullOrEmpty(requestResult)) {
            accessToken = JSON.parseObject(requestResult, AccessToken.class);
            accessToken.setCreateTime(now.getTime());
        }
        String json = "";
        return accessToken;
    }
}