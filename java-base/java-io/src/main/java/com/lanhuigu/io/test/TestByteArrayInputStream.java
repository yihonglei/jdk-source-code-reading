package com.lanhuigu.io.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestByteArrayInputStream {
    public static void main(String[] args) {
        try {
            String str = "abcdefghijklmnopqrstuvwxyz";
            byte[] bytes = new byte[1024];
            InputStream input = new ByteArrayInputStream(bytes);
            int data = input.read();
            StringBuilder sb = new StringBuilder();
            while (data != -1) {
                sb.append((char)data);

                data = input.read();
            }
            System.out.println("content:" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
