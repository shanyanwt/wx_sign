package pers.mq.wx.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/12/13
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public class RestResult implements Serializable {

    public static final int OK = 0;
    public static final String M_OK = "成功";

    private int errorCode;
    private String errorMessage;
    private Object data;

    public static RestResult OK(Object data) {
        RestResult restResult = new RestResult();
        restResult.setErrorCode(OK);
        restResult.setErrorMessage(M_OK);
        restResult.setData(data);
        return restResult;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
