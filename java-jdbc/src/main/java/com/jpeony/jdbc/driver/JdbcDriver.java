package com.jpeony.jdbc.driver;

import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * 加载驱动程序
 *
 * @author yihonglei
 */
public class JdbcDriver {
    public static void main(String[] args) {
        try {
            // 加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 使用DriverManager中的getDrivers方法获取加载的驱动信息
            Enumeration e = DriverManager.getDrivers();
            // 打印已经加载的驱动程序
            while (e.hasMoreElements()) {
                System.out.println(e.nextElement());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
