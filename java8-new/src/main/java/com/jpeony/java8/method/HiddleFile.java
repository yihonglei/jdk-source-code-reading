package com.jpeony.java8.method;

import java.io.File;
import java.util.Arrays;

/**
 * 打印文件隐藏名
 */
public class HiddleFile {
    public static void main(String[] args) {
        // 当前目录下的隐藏文件
        File[] files = new File(".").listFiles(File::isHidden);

        Arrays.stream(files).forEach(x -> System.out.println(x.getName()));
    }
}
