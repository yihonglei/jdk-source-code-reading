package com.jpeony.jdbc.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * 使用DriverManager类中的getConnection()方法创建与数据源连接。
 *
 * @author yihonglei
 */
public class JdbcConnection {
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
            // 3、使用DatabaseMetaData对象获取数据源相关信息
            DatabaseMetaData dd = conn.getMetaData();
            // 4、获取数据源URL
            System.out.println("URL:" + dd.getURL());
            // 5、获取数据源连接用户名
            System.out.println("UserName:" + dd.getUserName());
            // 6、获取驱动名
            System.out.println("DriverName:" + dd.getDriverName());
            // 7、获取驱动版本号
            System.out.println("DriverVersion:" + dd.getDriverVersion());
            // 8、获取DBMS名称
            System.out.println("DBMSName:" + dd.getDatabaseProductName());
            // 9、获取DBMS版本号
            System.out.println("DBMSVersion:" + dd.getDatabaseProductVersion());
            // 10、是否是只读权限
            System.out.println("isReadOnly:" + dd.isReadOnly());
            // 11、关闭连接
            conn.close();
        } catch (Exception e) {
            System.out.println("数据库连接失败");
        }
    }
}
