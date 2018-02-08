package com.lanhuigu.io.arrays;

import java.io.ByteArrayOutputStream;

/**
 * 往ByteArrayOutputStream写入数据的步骤:
 * 1. 创建字节数组输出流
 * 2. 将数据转化为字节数组
 * 3. 将字节数组写入到ByteArrayOutputStream，转化为输出流
 *
 * ByteArrayOutputStream中的数据可以通过调用toByteArray方法以字节数组形式返回，
 * 然后我们可以对数组做相应的操作。
 */
public class TestByteArrayOutputStream {

    public static void main(String[] args) {
        try {
            // 创建字节数组输出流
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            // 将数据转化为字节数组
            String str = "abcdefghijklmnopqrstuvwxyz";
            byte[] bytes = str.getBytes("UTF-8");
            // 将字节数据写入到ByteArrayOutputStream，转化为输出流
            output.write(bytes);
            // 将写入的数据以数组的形式返回
            byte[] data = output.toByteArray();
            // 打印内容
            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                sb.append((char)b);
            }
            System.out.println("内容:" + sb.toString());
        } catch (Exception e) {

        }
    }

}
