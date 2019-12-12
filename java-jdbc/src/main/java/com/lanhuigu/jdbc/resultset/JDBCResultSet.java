package com.lanhuigu.jdbc.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ResultSet解析查询结果
 *
 * @author yihonglei
 */
public class JDBCResultSet {
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
            // 设置最大返回行数，这里设置10条
            st.setMaxRows(10);
            String sql = " SELECT oid, userName, userPwd FROM t_user_main ";
            // 4、查询--返回查询结果
            ResultSet rs = st.executeQuery(sql);
            // 5、打印查询结果
            while (rs.next()) {
                System.out.println("oid:" + rs.getString("oid")
                        + ", userName:" + rs.getString("userName")
                        + ", userPwd:" + rs.getString("userPwd"));
            }
            // 6、关闭连接
            st.close(); // 关闭Statement对象
            conn.close(); // 关闭数据库连接
        } catch (Exception e) {
            System.out.println("数据库连接失败");
        }
    }
}
