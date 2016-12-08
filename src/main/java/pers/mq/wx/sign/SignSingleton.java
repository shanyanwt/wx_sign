package pers.mq.wx.sign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.mq.wx.model.AccessToken;
import pers.mq.wx.model.JsapiTicket;
import pers.mq.wx.model.WxConfig;
import pers.mq.wx.sign.factory.SignFactory;
import pers.mq.wx.sign.ticket.TicketRequest;
import pers.mq.wx.sign.token.TokenRequest;
import pers.mq.wx.utils.ResourceUtil;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 17:19
 * 签名资源管理
 */
public class SignSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignSingleton.class);

    private static SignSingleton instance = null;

    private static final String ITS_WX_CONFIG_FILE = "wx_sign_config.json";

    private AccessToken accessToken;

    private JsapiTicket jsapiTicket;

    private WxConfig wxConfig;

    private SignSingleton() {

    }

    public static SignSingleton getInstance() {
        if (instance == null) {
            LOGGER.debug("从配置文件解析配置参数，文件名为 {}", "wx_sign_config.json");
            WxConfig wxConfig = ResourceUtil.readJson(ITS_WX_CONFIG_FILE, WxConfig.class);
            LOGGER.info("全局配置为：{}", wxConfig);
            instance = new SignSingleton();
            instance.setWxConfig(wxConfig);
        }
        return instance;
    }

    /**
     * 重置Token
     */
    public void restToken() {
        SignFactory signFactory = createSignFactory();
        if (signFactory != null) {
            TokenRequest tokenRequest = signFactory.createToken();
            accessToken = tokenRequest.request(wxConfig.getAppid(), wxConfig.getSecret());
            instance.setAccessToken(accessToken);
        }
    }

    /**
     * 重置票据数据
     */
    public void restTicket() {
        SignFactory signFactory = createSignFactory();
        if (signFactory != null) {
            TicketRequest ticketRequest = signFactory.createTicket();
            jsapiTicket = ticketRequest.request(accessToken.getAccessToken());
            instance.setJsapiTicket(jsapiTicket);
        }
    }

    private SignFactory createSignFactory() {
        SignFactory signFactory = null;
        try {
            Class clazz = Class.forName(wxConfig.getClassname());
            signFactory = (SignFactory) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOGGER.error("创建证书工厂失败", e);
        }
        return signFactory;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public JsapiTicket getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(JsapiTicket jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    public WxConfig getWxConfig() {
        return wxConfig;
    }

    public void setWxConfig(WxConfig wxConfig) {
        this.wxConfig = wxConfig;
    }
}
