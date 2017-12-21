package com.lanhuigu.base.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestTempOut {

    public static void main(String args[]) throws IOException {

        FileOutputStream fos = new FileOutputStream("temp.out");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        TestSerial ts = new TestSerial();

        oos.writeObject(ts);

        oos.flush();

        oos.close();

    }

}
