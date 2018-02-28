package com.lanhuigu.io.test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPiped {
    public static void main(String[] args) throws IOException {
        PipedOutputStream output = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream();

        WriteThread writeThread = new WriteThread(output);
        ReaderThread readerThread = new ReaderThread(input);

        output.connect(input);

        Thread thread1 = new Thread(writeThread);
        Thread thread2 = new Thread(readerThread);

        thread1.start();
        thread2.start();
    }
}
