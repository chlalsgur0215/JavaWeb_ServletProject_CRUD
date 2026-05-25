package idusw.javaweb.sba2.repository;

import idusw.javaweb.sba2.domain.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl extends DAOImpl implements MemberDAO {
    public MemberDAOImpl() {
        conn = this.getConnection("db_no");
    }

    @Override
    public int saveMember(Member member) {
        int rows = 0;
        String query = "insert into mb_no(email, password, phone, address, role) values (?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getPhone());
            pstmt.setString(4, member.getAddress());
            pstmt.setString(5, member.getRole());
            rows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //this.closeResources(conn, stmt, pstmt, rs);
        }
        return rows;
    }

    private Member rsToDTO(ResultSet rs) throws SQLException {
        Member dto = new Member();
        // rs : ResultSet 객체 참조 변수
        // rs.getString(1) : 현재 레코드의 첫번재 필드 값
        // rs.getString("<field_name>"); 필드이름로도 가능
        dto.setId(rs.getInt(1));
        dto.setEmail(rs.getString(2));
        dto.setPassword(rs.getString(3));
        dto.setPhone(rs.getString(4));
        dto.setAddress(rs.getString(5));
        dto.setRole(rs.getString(6));
        dto.setRegDateTime(rs.getTimestamp("reg_date_time"));
        return dto;
    }

    @Override
    public Member getMember(Member member) {
        Member retMember = null;
        String query = "select * from mb_no where email = ? and password = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            rs = pstmt.executeQuery();
            if (rs.next()) { // 다음 record값을 접근
                retMember = rsToDTO(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { //this.closeResources(conn, stmt, pstmt, rs);
        }
        return retMember;
    }

    @Override
    public List<Member> getAllMember() {
        List<Member> members = null;
        String sql = "select * from mb_no order by id desc";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            members = new ArrayList<Member>();
            while (rs.next()) { // 다음 ResultSet 원소 값, record를 접근
                members.add(rsToDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //this.closeResources(conn, stmt, pstmt, rs);
        }
        return members;
    }


    @Override
    public int updateMember(Member member) {
        int rows = 0;
        String query = "update mb_no set password=?, phone=?, address=?, role=? where email=?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getPassword());
            pstmt.setString(2, member.getPhone());
            pstmt.setString(3, member.getAddress());
            pstmt.setString(4, member.getRole());
            pstmt.setString(5, member.getEmail());
            if ((rows = pstmt.executeUpdate()) < 1) throw new RuntimeException(member.getEmail());
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //this.closeResources(conn, stmt, pstmt, rs);
        }
        return rows;
    }
    @Override
    public int deleteMember(Member member) {
        int rows = 0;
        String query = "delete from mb_no where email = ? and password = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            rows = pstmt.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
        finally { //this.closeResources(conn, stmt, pstmt, rs);
            }
        return rows;
    }

}

