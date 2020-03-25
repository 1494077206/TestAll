package zy.jdbcMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Administrator on 2020/3/11.
 */
public class TestConn {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/1703c?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        Connection conn = null;
        Statement st = null;

        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
            // 2. 创建一个链接对象
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接成功");
            // 3. 创建一个sql语句的发送命令对象
            String sql = "insert into dept values('5','研发部')";
            st= conn.createStatement();
            // 4. 执行sql语句，拿到查询的结果集对象
            //st.executeQuery(sql);
            st.execute(sql);
            System.out.println("执行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5. 关闭链接 ，命令对象 ，结果集
            if(st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
