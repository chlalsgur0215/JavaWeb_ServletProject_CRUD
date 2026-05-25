package idusw.javaweb.sba2.repository;

import java.sql.*;

//DAO : Data Access Object - 데이터 소스(데이터의 출처, DBMS, XML, JSON, CSV, txt파일)를 접근하여 처리하는 객체
public interface DAO {
    //연결 객체를 가져오는 메서드 선언
    Connection getConnection(String dbName) throws SQLException;
    //자원 회수 메서드 선언
    void closeResources(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs);
}
