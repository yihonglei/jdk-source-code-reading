package com.jpeony.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * PreparedStatement的execute()方法
 *
 * @author yihonglei
 */
public class PreparedStatementExecute {
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
            // 1、加载驱动类
            Class.forName(driver);
            // 2、连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            // 3、编写预编译sql
            String sql = "SELECT id, name, age FROM person";
            PreparedStatement ps = conn.prepareStatement(sql);
            // 4、执行sql
            /*
             * PreparedStatement的 execute() throws SQLException
             * 一些预处理过的语句返回多个结果，execute方法处理这些复杂的语句，
             * executeQuery和executeUpdate处理形式更简单的语句。
             * execute方法返回一个boolean值，指示第一个结果的形式。
             * 必须调用getResultSet或getUpdateCount方法获取该结果，必须调用getMoreResults获取任何后续结果。
             * 返回:
             *    如果第一个结果是ResultSet对象，则返回true；如果第一个结果是更新计数或者没有结果，则返回 false
             * 抛出:
             *    SQLException-如果发生数据库访问错误；在关闭的PreparedStatement上调用此方法，或者为此方法提供了参数
             */
            // 查询person表的基本信息
            ResultSet rs = ps.executeQuery();
            // 5、输出结果
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));
                /*
                 * 根据查询sql语句的别名做key,拿到对应的值，
                 * 可以将这些值封装到域模型对象，将对象封装到集合中等，
                 * 然后再跟jsp页面交互等都能实现
                 */
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("数据库连接失败");
        }
    }
}
