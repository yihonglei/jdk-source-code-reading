package com.lanhuigu.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * statement的executeQuery()方法
 *
 * @author yihonglei
 */
public class StatementQuerySimple {
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
            // 3、编写sql
            Statement st = conn.createStatement();
            String sql = "SELECT id, name, age FROM person";
            // 4、执行sql
            /*
             * Statement的ResultSet executeQuery(String sql)throws SQLException:
             * 执行给定的SQL语句，该语句返回单个ResultSet对象。
             * 参数：
             *    sql-要发送给数据库的SQL语句，通常为静态SQL SELECT语句。
             * 返回：
             *    包含给定查询所生成数据的ResultSet对象；永远不能为 null
             * 抛出：
             *    SQLException-如果发生数据库访问错误，在已关闭的 Statement 上调用此方法，
             *    或者给定SQL语句生成单个ResultSet对象之外的任何其他内容
             */
            // 查询person表的基本信息
            ResultSet rs = st.executeQuery(sql);
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
        } catch (Exception e) {
            System.out.println("数据库连接失败");
        }
    }
}
