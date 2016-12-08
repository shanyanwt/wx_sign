package pers.mq.wx.sign.factory.impl;

import pers.mq.wx.sign.factory.SignFactory;
import pers.mq.wx.sign.ticket.TicketRequest;
import pers.mq.wx.sign.ticket.impl.QyDevTicketRequest;
import pers.mq.wx.sign.token.TokenRequest;
import pers.mq.wx.sign.token.impl.QyDevTokenRequest;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 16:43
 * 企业号工厂
 */
public class QydevSignFactory implements SignFactory {

    @Override
    public TokenRequest createToken() {
        return new QyDevTokenRequest();
    }

    @Override
    public TicketRequest createTicket() {
        return new QyDevTicketRequest();
    }


}
