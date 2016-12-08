package pers.mq.wx.sign.token;

import pers.mq.wx.model.AccessToken;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/11/30
 * Time: 16:34
 * 获取accesstoken接口
 */
public interface TokenRequest {

    /**
     * 获取accesstoken
     *
     * @param a 企业Id, AppId
     * @param s 管理组的凭证密钥
     * @return token对象
     */
    AccessToken request(String a, String s);
}
