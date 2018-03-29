package com.lanhuigu.io.fileclass;

import java.io.File;

/**
 * delete()
 * 删除文件或一个空文件夹，如果是文件夹且不为空，则不能删除，成功返回true，失败返回false。
 */
public class TestDelete {

    public static void main(String[] args) {
        // 指定删除文件目录构建File对象
        File file = new File("C:\\mycode\\test-mkdir");
        // 调用delete()方法
        boolean b = file.delete();
        // 删除结果
        System.out.println("删除结果:" + b);
    }

}
