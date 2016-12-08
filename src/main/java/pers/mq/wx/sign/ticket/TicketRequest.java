package pers.mq.wx.sign.ticket;

import pers.mq.wx.model.JsapiTicket;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 16:37
 * 获取票据接口
 */
public interface TicketRequest {

    /**
     * 获取票据
     *
     * @return 票据对象
     */
    JsapiTicket request(String accessToken);
}
