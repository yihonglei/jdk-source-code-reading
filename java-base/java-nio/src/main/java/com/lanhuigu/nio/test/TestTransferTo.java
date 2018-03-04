package com.lanhuigu.nio.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestTransferTo {
    public static void main(String[] args) {
        try (
                FileInputStream fromFile = new FileInputStream("C:\\mycode\\fromFile.txt");
                FileOutputStream toFile = new FileOutputStream("C:\\mycode\\toFile.txt");
                FileChannel fromChannel = fromFile.getChannel();
                FileChannel toChannel = toFile.getChannel();
                ) {
                long position = 0;
                long count = fromChannel.size();
                fromChannel.transferTo(position, count, toChannel);
        } catch (IOException e) {

        }
    }

}
