package com.lanhuigu.io.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    public static String read(String fileName) {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("C:\\mycode\\hello.txt"));
    }
}
