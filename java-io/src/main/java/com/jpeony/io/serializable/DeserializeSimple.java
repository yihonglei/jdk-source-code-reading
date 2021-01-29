package com.jpeony.io.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化
 *
 * @author yihonglei
 */
public class DeserializeSimple {
    public static void main(String[] args) {
        Employee e = null;
        try (
                FileInputStream fileIn = new FileInputStream("C:\\mycode\\employee.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("===反序列化===");
        System.out.println(e);
    }
}
