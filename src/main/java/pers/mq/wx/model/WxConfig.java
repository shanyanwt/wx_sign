package pers.mq.wx.model;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/25
 * Time: 15:44
 * 微信配置文件
 */
public class WxConfig {

    /**
     * 企业Id, AppId
     */
    private String appid;

    /**
     * 管理组的凭证密钥
     */
    private String secret;

    /**
     * 是否开启debug模式
     */
    private boolean debug;

    /**
     * 生成页面地址
     */
    private String url;

    /**
     * 工厂类名称
     */
    private String classname;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "WxConfig{" +
                "appid='" + appid + '\'' +
                ", secret='" + secret + '\'' +
                ", debug=" + debug +
                ", url='" + url + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
