package pers.mq.wx.sign.factory.impl;

import pers.mq.wx.sign.factory.SignFactory;
import pers.mq.wx.sign.ticket.TicketRequest;
import pers.mq.wx.sign.ticket.impl.MpTicketRequest;
import pers.mq.wx.sign.token.TokenRequest;
import pers.mq.wx.sign.token.impl.MpTokenRequest;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 16:42
 * 服务号工厂
 */
public class MpSignFactory implements SignFactory {

    @Override
    public TokenRequest createToken() {
        return new MpTokenRequest();
    }

    @Override
    public TicketRequest createTicket() {
        return new MpTicketRequest();
    }
}
