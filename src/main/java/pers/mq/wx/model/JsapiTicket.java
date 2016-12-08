package pers.mq.wx.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/25
 * Time: 15:38
 * JSAPI票据
 */
public class JsapiTicket implements Serializable {

    /**
     * 状态码
     */
    private Integer errcode;

    /**
     * 错误消息
     */
    private String errmsg;

    /**
     * 票据
     */
    private String ticket;

    /**
     * 时间戳
     */
    @JSONField(name = "expires_in")
    private Integer expiresIn;

    /**
     * 获取时间
     */
    private Date createTime;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date timeout() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createTime);
        calendar.add(Calendar.SECOND, expiresIn);
        return calendar.getTime();
    }

    @Override
    public String toString() {
        return "JsapiTicket{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", ticket='" + ticket + '\'' +
                ", expiresIn=" + expiresIn +
                ", createTime=" + createTime +
                '}';
    }


}
