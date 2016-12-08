package pers.mq.wx.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/25
 * Time: 15:22
 * 微信证书
 */
public class Sign {

    /**
     * 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
     */
    private boolean debug;

    /**
     * 必填，企业号的唯一标识，此处填写企业号corpid
     */
    private String appId;

    /**
     * 必填，生成签名的时间戳
     */
    private long timestamp;

    /**
     * 必填，生成签名的随机串
     */
    private String nonceStr;

    /**
     * 必填，签名，见附录1
     */
    private String signature;

    /**
     * 必填，需要使用的JS接口列表，所有JS接口列表见附录2
     */
    private List<String> jsApiList;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<String> getJsApiList() {
        return jsApiList;
    }

    public void setJsApiList(List<String> jsApiList) {
        this.jsApiList = jsApiList;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "debug=" + debug +
                ", appId='" + appId + '\'' +
                ", timestamp=" + timestamp +
                ", nonceStr='" + nonceStr + '\'' +
                ", signature='" + signature + '\'' +
                ", jsApiList=" + jsApiList +
                '}';
    }
}
