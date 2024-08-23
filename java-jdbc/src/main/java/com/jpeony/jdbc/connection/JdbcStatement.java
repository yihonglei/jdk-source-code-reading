package com.jpeony.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 简单查询
 */
public class JdbcStatement {
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
            // 3、创建Statement对象
            Statement st = conn.createStatement();
            String sql = " SELECT id, name, age FROM t_user_info ";
            // 4、查询--返回查询结果
            ResultSet rs = st.executeQuery(sql);
            // 5、打印查询结果
            while (rs.next()) {
                System.out.println("id:" + rs.getString("id")
                        + ", name:" + rs.getString("name")
                        + ", age:" + rs.getString("age"));
            }
            // 6、关闭连接
            conn.close();
        } catch (Exception e) {
            System.out.println("数据库连接失败");
        }
    }
}
