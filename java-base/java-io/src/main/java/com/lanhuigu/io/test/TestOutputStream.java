package com.lanhuigu.io.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {
    public static void main(String[] args) {
        File file = new File("C:\\mycode\\hello.txt");
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            String str = "test-append";
            byte[] data = str.getBytes("UTF-8");
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
