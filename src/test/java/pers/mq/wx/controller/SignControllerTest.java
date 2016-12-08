package pers.mq.wx.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
/*        SignController sc = new SignController();
        sc.sign(new ArrayList<>());*/
        File directory = new File("data");
        System.out.println(directory.getCanonicalPath());
        if (!directory.exists()) {
            directory.mkdir();
        }
//        System.out.println(directory.getAbsolutePath());
        AccessToken accessToken = new AccessToken();
        accessToken.setCreateTime(Calendar.getInstance().getTime());
        accessToken.setAccessToken("token");
        accessToken.setExpiresIn(7200);
        File tokenFile = new File(directory.getCanonicalPath(), "token.data");
        tokenFile.createNewFile();
        OutputStream os = new FileOutputStream(tokenFile);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(accessToken);
        oos.flush();
        oos.close();
        os.close();

        InputStream is = new FileInputStream(tokenFile);
        ObjectInputStream ois = new ObjectInputStream(is);
        AccessToken accessToken1 = (AccessToken)ois.readObject();
        System.out.println(accessToken);
        System.out.println(accessToken1);

    }

}