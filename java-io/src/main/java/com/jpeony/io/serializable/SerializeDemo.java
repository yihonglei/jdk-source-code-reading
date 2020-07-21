package com.jpeony.io.serializable;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化
 *
 * @author yihonglei
 */
public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "yi";
        e.address = "beijing";
        e.age = 27;
        e.number = 101;
        try (FileOutputStream fileOut = new FileOutputStream("C:\\mycode\\employee.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("序列化数据保存在: C:\\mycode\\employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
