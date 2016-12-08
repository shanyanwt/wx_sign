package pers.mq.wx.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/25
 * Time: 15:33
 * 微信令牌
 */
public class AccessToken {

    /**
     * 令牌
     */
    @JSONField(name = "access_token")
    private String accessToken;

    /**
     * 时间戳
     */
    @JSONField(name = "expires_in")
    private Integer expiresIn;

    /**
     * 获取时间
     */
    private Date createTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", createTime=" + createTime +
                '}';
    }
}
