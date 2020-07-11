package com.jpeony.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * PreparedStatement查询
 *
 * @author yihonglei
 */
public class PreparedStatementQuery {
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
            // 3、创建PreparedStatement对象
            String sql = " SELECT oid, userName, userPwd FROM t_user_main WHERE oid = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            // 对应参数位置赋值
            ps.setString(1, "1");
            // 4、查询--返回查询结果
            ResultSet rs = ps.executeQuery();
            // 5、打印查询结果
            while (rs.next()) {
                System.out.println("oid:" + rs.getString("oid")
                        + ", userName:" + rs.getString("userName")
                        + ", userPwd:" + rs.getString("userPwd"));
            }
            // 6、关闭连接
            conn.close();// 关闭数据库连接
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
