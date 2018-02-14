package com.lanhuigu.io.file;

import java.io.File;

/**
 * list()
 * 返回当前目录的文件或目录名，包括隐藏文件。
 * 如果该目录下未获取到值，返回null。
 */
public class TestListNoArgs {
    public static void main(String[] args) {
        // 指定构建目录
        File file = new File("C:\\mycode");
        // 返回目录下的文件或目录名，包含隐藏文件
        String[] listNames = file.list();
        // 循环打印文件或目录名
        for (String name : listNames) {
            System.out.println("文件名称:" + name);
        }
    }
}
