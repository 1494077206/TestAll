package zy.jdbcMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2020/3/11.
 */
public class CRUD {
    //增加
    public int save() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into dept values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 6);
            ps.setString(2, "梆梆部");
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }
    //删除
    public int delete(int studentId) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from dept where did=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 5);
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }
    //更新
    public int update() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update dept set dname=?where did=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"更新为zynb");
            ps.setInt(2, 5);
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }
    //查找一条数据
    public void getByStudentId(int studentId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from students where studentId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, rs);
        }
    }

    public void getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from students";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, rs);
        }
    }
}
