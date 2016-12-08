package pers.mq.wx.utils;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/12/7
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public final class ResourceUtil {

    private ResourceUtil() {
        throw new IllegalAccessError();
    }

    public static <T> T readJson(String configFileName, Class<T> clazz) {

        ClassLoader loader = (ClassLoader) MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader());

        try {
            Enumeration e = loader.getResources(configFileName);
            ArrayList urls = Lists.newArrayList();

            while (e.hasMoreElements()) {
                URL finalConf = (URL) e.nextElement();
                urls.add(finalConf);
            }

            JSONObject finalConf1 = new JSONObject();
            Iterator var6 = Lists.reverse(urls).iterator();

            while (var6.hasNext()) {
                URL url = (URL) var6.next();
                String json = Resources.toString(url, Charsets.UTF_8);
                JSONObject tmpConf = JSON.parseObject(json);
                finalConf1.putAll(tmpConf);
            }

            return TypeUtils.cast(finalConf1, clazz, ParserConfig.getGlobalInstance());
        } catch (IOException var10) {
            Throwables.propagate(var10);
            return null;
        }
    }
}
