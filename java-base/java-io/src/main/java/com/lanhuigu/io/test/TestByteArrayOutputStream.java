package com.lanhuigu.io.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestByteArrayOutputStream {
    public static void main(String[] args) {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            String str = "1111111111111";
            byte[] bytes = str.getBytes("UTF-8");
            output.write(bytes);

            byte[] data = output.toByteArray();
            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                sb.append((char)b);
            }
            System.out.println("内容:" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
