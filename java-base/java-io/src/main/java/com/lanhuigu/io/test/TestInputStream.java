package com.lanhuigu.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {
    public static void main(String[] args) {
        File file = new File("C:\\mycode\\hello.txt");
        try (InputStream is = new FileInputStream(file)) {
            byte[] data = new byte[1024];
            is.read(data);
            System.out.println("文件内容:" + new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
