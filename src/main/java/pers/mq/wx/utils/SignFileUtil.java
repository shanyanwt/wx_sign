package pers.mq.wx.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/12/8
 * Time: 15:18
 * 文件工具
 */
public final class SignFileUtil {

    public static void writeObject(Object object, String FileName) {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            File file = new File("data", FileName);
            file.createNewFile();
            os = new FileOutputStream(file);
            oos = new ObjectOutputStream(os);
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object readObject(String FileName) {
        File file = new File("data", FileName);
        if (file.exists()) {
            InputStream is = null;
            ObjectInputStream ois = null;
            try {
                is = new FileInputStream(file);
                ois = new ObjectInputStream(is);
                return ois.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
