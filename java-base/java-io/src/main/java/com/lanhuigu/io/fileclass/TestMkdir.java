package com.lanhuigu.io.fileclass;

import java.io.File;

/**
 * mkdir():
 * 在指定位置创建目录，这只会创建最后一级目录，如果上级目录不存在就抛异常。
 * 创建成功返回true,否则返回false。
 */
public class TestMkdir {

    public static void main(String[] args) {
        // 指定创建目录位置
        File file = new File("C:\\mycode\\test-mkdir");
        // 调用mkdir()在指定位置创建目录
        boolean b = file.mkdir();
        // 打印创建结果
        System.out.println("创建文件目录结果:" + b);
    }

}
