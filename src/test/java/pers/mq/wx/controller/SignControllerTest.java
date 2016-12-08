package pers.mq.wx.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

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
        SignController sc = new SignController();
        sc.sign(new ArrayList<>());
    }

}