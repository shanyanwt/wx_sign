package pers.mq.wx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pers.mq.wx.model.AccessToken;
import pers.mq.wx.model.JsapiTicket;
import pers.mq.wx.model.RestResult;
import pers.mq.wx.model.Sign;
import pers.mq.wx.model.WxConfig;
import pers.mq.wx.sign.SignSingleton;
import pers.mq.wx.sign.SignUtil;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/25
 * Time: 15:55
 * 证书服务RPC接口
 */
@RestController
@RequestMapping(value = "/sign")
public class SignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignController.class);

    /**
     * 获取证书
     *
     * @param jsApiList js api功能列表
     * @return 签名
     */
    @RequestMapping("/sign")
    public Object sign(@RequestParam(value = "jsApiList", required = false) List<String> jsApiList) {
        checkTokenAndTicketTimeout();
        SignSingleton signSingleton = SignSingleton.getInstance();
        JsapiTicket jsapiTicket = signSingleton.getJsapiTicket();
        Sign sign = new Sign();
        if (jsapiTicket != null && jsapiTicket.getErrcode().equals(0)) {
            WxConfig wxConfig = signSingleton.getWxConfig();
            sign.setAppId(wxConfig.getAppid());
            sign.setDebug(wxConfig.isDebug());
            sign.setJsApiList(jsApiList);
            String ticket = jsapiTicket.getTicket();
            Map<String, String> signMap = SignUtil.sign(ticket, wxConfig.getUrl());
            sign.setNonceStr(signMap.get("nonceStr"));
            sign.setSignature(signMap.get("signature"));
            sign.setTimestamp(Long.parseLong(signMap.get("timestamp")));
        } else {
            LOGGER.error("签名生成出错");
        }
        LOGGER.info("本次生成token:{}, ticket:{}, sign:{}", signSingleton.getAccessToken(), signSingleton.getJsapiTicket(), sign);
        return RestResult.OK(sign);
    }

    /**
     * 检查token和ticket是否超时
     */
    private void checkTokenAndTicketTimeout() {
        SignSingleton signSingleton = SignSingleton.getInstance();
        AccessToken accessToken = signSingleton.getAccessToken();
        if (accessToken == null) {
            signSingleton.restToken();
            LOGGER.info("新生成token:{}", signSingleton.getAccessToken());
        } else {
            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            Date timeout = accessToken.timeout();
            if (now.after(timeout)) {
                signSingleton.restToken();
                LOGGER.info("超时生成token:{}", signSingleton.getAccessToken());
            }
        }
        JsapiTicket jsapiTicket = signSingleton.getJsapiTicket();
        if (jsapiTicket == null) {
            signSingleton.restTicket();
            LOGGER.info("新生成ticket:{}", signSingleton.getJsapiTicket());
        } else {
            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            Date timeout = jsapiTicket.timeout();
            if (now.after(timeout)) {
                signSingleton.restTicket();
                LOGGER.info("超时生成ticket:{}", signSingleton.getJsapiTicket());
            }
        }
    }

    @RequestMapping(value = "/sign1")
    public Object sign1(@RequestParam(value = "test", required = false) String test) {
        return "aa:" + test;
    }
}
