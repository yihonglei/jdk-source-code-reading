package com.lanhuigu.io.charstream;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        File file = new File("C:\\mycode\\hello.txt");
        /**
         * model各个参数详解
         * r 代表以只读方式打开指定文件
         * rw 以读写方式打开指定文件
         * rws 读写方式打开，并对内容或元数据都同步写入底层存储设备
         * rwd 读写方式打开，对文件内容的更新同步更新至底层存储设备
         */
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            //获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile文件指针的初始位置:"+raf.getFilePointer());
            //移动文件指针位置
            raf.seek(0);
            byte[]  buff=new byte[1024];
            //用于保存实际读取的字节数
            int hasRead=0;
            //循环读取
            while((hasRead=raf.read(buff))>0){
                //打印读取的内容,并将字节转为字符串输入
                System.out.println(new String(buff,0,hasRead));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
