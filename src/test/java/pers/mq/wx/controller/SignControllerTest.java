package pers.mq.wx.controller;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

import pers.mq.wx.model.AccessToken;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/12/7
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */
public class SignControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignControllerTest.class);

    @Test
    public void sign() throws Exception {
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/wx_sign/api/sign/sign";
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("jsApiList", null);
        ResponseEntity<String> response = template.postForEntity(url, params, String.class);
        System.out.println(response.getBody());
        Assert.assertEquals(200,response.getStatusCode().value());

    }

}