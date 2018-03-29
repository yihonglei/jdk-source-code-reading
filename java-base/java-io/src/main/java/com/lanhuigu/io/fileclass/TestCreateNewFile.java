package com.lanhuigu.io.fileclass;

import java.io.File;
import java.io.IOException;

/**
 * 在指定位置创建一个空文件，成功就返回true，如果已存在就不创建然后返回false。
 */
public class TestCreateNewFile {

    public static void main(String[] args) {
        // 1.指定文件路径
        File file = new File("C:\\mycode\\test-createNewFile.txt");
        try  {
            // 2.调用创建方法创建
            boolean b = file.createNewFile();
            // 3. 创建文件结果
            System.out.println("createNewFile创建文件结果:" + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
