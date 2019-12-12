package com.lanhuigu.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 只读和自动提交设置
 *
 * @author yihonglei
 */
public class JdbcSetField {
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
            // 3、是否为只读
            System.out.println("isReadOnly--one:" + conn.isReadOnly());
            // 4、设置为只读
            conn.setReadOnly(true);
            System.out.println("isReadOnly--two:" + conn.isReadOnly());
            // 5、是否自动提交
            System.out.println("AutoCommit--one:" + conn.getAutoCommit());
            // 6、设置为手动提交
            conn.setAutoCommit(false);
            System.out.println("AutoCommit--two:" + conn.getAutoCommit());
        } catch (Exception e) {
            System.out.println("数据库连接失败");
        }
    }
}
