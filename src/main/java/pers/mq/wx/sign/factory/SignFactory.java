package pers.mq.wx.sign.factory;

import pers.mq.wx.sign.ticket.TicketRequest;
import pers.mq.wx.sign.token.TokenRequest;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 16:40
 * 签名工厂类
 */
public interface SignFactory {

    TokenRequest createToken();

    TicketRequest createTicket();
}
