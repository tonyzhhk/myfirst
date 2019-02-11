package com.demo.basic.serialize;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * 序列化demo
 *
 * @author zhanghk.tony.
 * @date 2019-01-31 14:22
 */
public class DemoEntry {

    public static void main(String[] args) {
        Family family = new Family();
        family.setDaddy("Tony");
        family.setMammy("Susan");
        family.setSon("Zq");
        System.out.println(JSON.toJSONString(family));
        // 不定义具体文件路径，文件保存在该路径下
        System.out.println(System.getProperty("user.dir"));

        // IOUtils.closeQuietly在2.6的时候将它标记为过时，因为Java7里的“try-with-resource”语法的出现
        // 如下是该语法的实现。在try()内定义的流相当于加了final标记，你无法再改变其内存引用地址即无法再进行赋值操作
        // windows具体路径"d://tempFile"
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"))) {
            oos.writeObject(family);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("tempFile");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Family family1 = (Family) ois.readObject();
            System.out.println(JSON.toJSONString(family1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 删除文件
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
