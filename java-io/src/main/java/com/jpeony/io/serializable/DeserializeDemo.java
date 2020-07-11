package com.jpeony.io.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化
 */
public class DeserializeDemo {
    public static void main(String [] args) {
        Employee e = null;
        try (
                FileInputStream fileIn = new FileInputStream("C:\\mycode\\employee.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn)
          ) {
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
            return;
        } catch(ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("===反序列化===");
        System.out.println("name: " + e.name);
        System.out.println("address: " + e.address);
        System.out.println("age: " + e.age);
        System.out.println("number: " + e.number);
    }
}
