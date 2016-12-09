# 微信获取签名（java版）
## 配置文件
resources/wx_sign_config.json
```
{
  "appid": "appid",
  "secret": "",
  "debug": false,
  "classname": "pers.mq.wx.sign.factory.impl.QydevSignFactory",
  "url": ""
}
```

* appid：企业Id或者AppId
* secret：管理组的凭证密钥
* debug: 是否开启debug模式
* classname：企业签名(pers.mq.wx.sign.factory.impl.QydevSignFactory), 服务号(pers.mq.wx.sign.factory.impl.MpSignFactory)
* url:生成签名网站地址地址

## 代码说明

## 单元测试
SignControllerTest.java

## 测试情况
企业签名已经测试；服务号签名未测试，手中暂无服务号无法测试。

## 遗憾
1. 代码还有很大优化空间;
1. 没有做异常信息的捕获。
