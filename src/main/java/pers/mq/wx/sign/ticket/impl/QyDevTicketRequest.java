package pers.mq.wx.sign.ticket.impl;

import com.google.common.base.Strings;

import com.alibaba.fastjson.JSON;

import java.util.Calendar;

import pers.mq.wx.model.JsapiTicket;
import pers.mq.wx.sign.ticket.TicketRequest;
import pers.mq.wx.utils.SignFileUtil;
import pers.mq.wx.utils.WebRequestUtil;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 16:48
 * 企业号请求Ticket
 */
public class QyDevTicketRequest implements TicketRequest {

    @Override
    public JsapiTicket request(String accessToken) {
        Calendar now = Calendar.getInstance();
        StringBuffer addressSb = new StringBuffer();
        addressSb.append("https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket");
        addressSb.append("?access_token=").append(accessToken);
        String requestResult = WebRequestUtil.get(addressSb.toString());
        JsapiTicket jsapiTicket = null;
        if (!Strings.isNullOrEmpty(requestResult)) {
            jsapiTicket = JSON.parseObject(requestResult, JsapiTicket.class);
            jsapiTicket.setCreateTime(now.getTime());
            SignFileUtil.writeObject(jsapiTicket, "ticket.data");
        }
        return jsapiTicket;
    }
}
