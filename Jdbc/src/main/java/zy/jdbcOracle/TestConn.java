package zy.jdbcOracle;

import java.sql.*;

/**
 * Created by Administrator on 2020/3/11.
 */
public class TestConn {
    public static void main(String[] args) {
        getConnection();
    }
    public static Connection getConnection(){
        System.out.println("jdbc连接oracle数据库");
        Connection conn=null;
        int i = 0;
        try {
            String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
            String user="scott";
            String password="root";

            Class.forName("oracle.jdbc.driver.OracleDriver");//加载数据驱动
            conn = DriverManager.getConnection(url, user, password);// 连接数据库
            System.out.println("连接成功！");
            PreparedStatement preparedStatement = conn.prepareStatement("select * from A");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                i++;
                System.out.println("共查询到"+i+"行数据");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载数据库驱动失败");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("连接数据库失败");
        }
        return conn;
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
