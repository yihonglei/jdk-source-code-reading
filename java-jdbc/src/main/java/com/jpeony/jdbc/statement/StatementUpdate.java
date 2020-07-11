package com.jpeony.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * statement的executeUpdate()方法
 *
 * @author yihonglei
 */
public class StatementUpdate {
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
            String sql = "CREATE TABLE person ( " +
                    " id int(11) NOT NULL AUTO_INCREMENT COMMENT '个人信息表'," +
                    " name varchar(10) DEFAULT NULL COMMENT '姓名'," +
                    " age int(3) DEFAULT NULL COMMENT '年龄',PRIMARY KEY (id) " +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            // 4、执行sql
            /*
             * Statement的executeUpdate(String sql)
             * 执行给定SQL语句，该语句可能为INSERT、UPDATE 或DELETE语句，或者不返回任何内容的SQL语句（如 SQL DDL语句）。
             * 参数：
             *    SQL数据操作语言（Data Manipulation Language，DML）语句，如INSERT、UPDATE或DELETE；
             *    或者不返回任何内容的SQL语句，如DDL语句。
             * 返回：
             *    1）对于SQL数据操作语言(DML)语句，返回行计数
             *    2）对于什么都不返回的SQL语句，返回 0。
             * 抛出：
             *    SQLException--如果发生数据库访问错误，在已关闭的Statement上调用此方法，
             *    或者给定的SQL语句生成ResultSet对象
             */

            //5、在数据库中创建person表，注意：可以写insert、update、delete类型sql语句执行，输出结果
            int result = st.executeUpdate(sql);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("数据库连接失败");
        }
    }
}
