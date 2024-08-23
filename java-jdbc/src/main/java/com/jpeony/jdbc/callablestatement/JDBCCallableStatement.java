package com.jpeony.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * 存储过程调用
 */
public class JDBCCallableStatement {
    public static void main(String[] args) {
        String user = "root";
        String password = "123456";
        /*
         * useUnicode=true:表示使用Unicode字符集
         * characterEncoding=UTF8:字符编码方式
         * allowMultiQueries=true:是否允许批量处理
         */
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=UTF8&allowMultiQueries=true";
        String driver = "com.mysql.jdbc.Driver";

        try {
            // 1、加载驱动程序
            Class.forName(driver);
            // 2、建立连接
            Connection conn = DriverManager.getConnection(url, user, password);
            // 3、创建CallableStatement对象
            CallableStatement cs = conn.prepareCall("{call user_main_pro()}");
            // 4、执行调用存储过程
            ResultSet rs = cs.executeQuery();
            // 5、打印查询结果
            while (rs.next()) {
                System.out.println(rs.getString("userName"));
                System.out.println(rs.getString("userPwd"));
                /*
                 * 根据查询sql语句的别名做key,拿到对应的值，
                 * 可以将这些值封装到域模型对象，将对象封装到集合中等，
                 * 然后再跟jsp页面交互等都能实现
                 */
            }
            // 6、关闭连接
            conn.close();
        } catch (Exception e) {
            System.out.println("数据库连接失败");
        }
    }
}
