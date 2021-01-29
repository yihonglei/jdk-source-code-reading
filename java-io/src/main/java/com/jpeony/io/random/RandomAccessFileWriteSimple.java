package com.jpeony.io.random;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @author yihonglei
 */
public class RandomAccessFileWriteSimple {

    public static void main(String[] args) {
        File file = new File("C:\\mycode\\hello.txt");
        /*
         * model各个参数详解:
         * r 以只读方式打开指定文件，调用任何的写方法，都会抛出IOException;
         * rw 以读写方式打开指定文件，如果此文件不存在，则会自动创建;
         * rws 以读写方式打开，与"rw"一样，并对文件内容或元数据的每一次更新都同步写入底层存储设备;
         * rwd 以读写方式打开，与"rw"一样，并对文件内容的每一次更新都同步写入底层存储设备;
         */
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            /* ------------------写入数据-------------- */
            String str = "Test random write!";
            byte[] writeData = str.getBytes();
            raf.write(writeData);
            /* -----------------读取数据--------------- */
            // 获取RandomAccessFile对象文件指针的位置，默认初始位置是0
            System.out.println("RandomAccessFile文件指针的初始位置:" + raf.getFilePointer());
            // 设置文件指针偏移量，下一次读写时从该位置开始
            raf.seek(0);
            // 用于保存实际读取的字节数
            byte[] dataRead = new byte[1024];
            int hasRead = 0;
            // 循环读取
            while ((hasRead = raf.read(dataRead)) > 0) {
                // 打印读取的内容,并将字节转为字符串输入
                System.out.println(new String(dataRead, 0, hasRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
