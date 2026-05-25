package idusw.javaweb.sba2.repository;

import jakarta.servlet.http.HttpServlet;

import java.sql.*;

public class DAOImpl extends HttpServlet implements DAO  {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public Connection getConnection(String dbName) {
        String className = "com.mysql.cj.jdbc.Driver";  //getServletContext().getInitParameter("className");
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName; //getServletContext().getInitParameter("dbUrl");
        String dbUser = "root"; //getServletContext().getInitParameter("dbUser");
        String dbPass = "cometrue"; //getServletContext().getInitParameter("dbPass");

        try{
            //드라이버 로딩 : MySQL - "com.mysql.cj.jdbc.Driver"
            Class.forName(className);
            // 적재된 드라이버 관리자 객체의 getConnection() 정적메소드를 호출하여 Connection 객체 생성
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void closeResources(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) try { rs.close(); } catch (Exception e) {e.printStackTrace();}
        if (pstmt != null) try {pstmt.close(); } catch (Exception e) {e.printStackTrace();}
        if (stmt != null) try {stmt.close(); } catch (Exception e) {e.printStackTrace();}
        if (conn != null) try {conn.close(); } catch (Exception e) {e.printStackTrace();}
    }
}
