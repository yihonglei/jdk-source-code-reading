package com.lanhuigu.java8.lambdareal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @ClassName: TestProcessFile
 * @Package: com.lanhuigu.java8.lambdareal
 * @Author yihonglei
 * @date 2018/3/6 10:00
 * @version 1.0.0
 */
public class TestProcessFile {
    public static void main(String[] args) throws IOException {
        /**
         * 读取两行(行为参数化，BufferedReader -> String 与BufferedReaderProcessor的process方法签名一致)；
         * 将表达式作为内联形式为函数式接口的抽象方法提供实现，并把整个表达式作为函数式接口的实例(
         * 具体来说，是函数式接口的一个具体实现实例。用匿名类也可以做到，但是比较笨拙。)
         */
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println("读取文件前两行, twoLines:" + twoLines);
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                new BufferedReader(new FileReader("C:\\mycode\\hello.txt"))) {
            return p.process(br);
        }
    }
}
