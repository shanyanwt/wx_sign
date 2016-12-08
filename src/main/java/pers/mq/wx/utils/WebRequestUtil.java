package pers.mq.wx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/12/1
 * Time: 13:48
 * web请求工具
 */
public final class WebRequestUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebRequestUtil.class);

    private WebRequestUtil() {
        throw new AssertionError();
    }

    /**
     * get方式请求
     *
     * @return 请求结果
     */
    public static String get(String address) {
        StringBuffer resultSb = new StringBuffer();
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(address);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultSb.append(line);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return resultSb.toString();
    }
}
