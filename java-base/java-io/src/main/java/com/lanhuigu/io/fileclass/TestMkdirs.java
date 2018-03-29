package com.lanhuigu.io.fileclass;

import java.io.File;

/**
 * mkdirs()
 * 在指定位置创建目录，这会创建路径中所有不存在的目录。
 */
public class TestMkdirs {

    public static void main(String[] args) {
        // 指定文件目录
        File file = new File("C:\\mycode\\test\\mkdirs\\hello-fileclass");
        // 调用mkdirs
        boolean b = file.mkdirs();
        // 创建结果
        System.out.println("创建结果:" + b);
    }

}
