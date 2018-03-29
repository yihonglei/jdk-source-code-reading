package com.lanhuigu.io.fileclass;

import java.io.File;

/**
 *  列出指定目录中所有包含的子文件与子目录
 */
public class TestListFilesDirs {

    public static void main(String[] args) {
        // 1. 根据File相应构造器，创建File对象
        File file = new File("C:\\mycode");
        // 2. 通过list方法得到所包含的所有子目录与子文件名称
        String[] names = file.list();
        // 3. 显示这些名称
        for (int i = 0; i < names.length; i++) {
            System.out.println("文件名称:" + names[i]);
        }
        /**
         * listFiles:
         * 方法返回当前File对象指向的目录中所有文件与子目录
         */
        // 4. 分别显示文件名与文件夹名
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File myFile = files[i];
            if (myFile.isFile()) {
                System.out.println("子文件名称:" + myFile.getName());
            } else if (myFile.isDirectory()){
                System.out.println("子目录名称:" + myFile.getName());
            }
        }

    }

}
