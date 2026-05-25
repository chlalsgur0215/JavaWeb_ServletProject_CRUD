package idusw.javaweb.sba2.controller;

import idusw.javaweb.sba2.domain.Member;
import idusw.javaweb.sba2.service.MemberService;
import idusw.javaweb.sba2.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

@WebServlet(name="memberController",
        urlPatterns = {"/members/register-form2", "/members/post2"})
public class MemberController2 extends HttpServlet {
    private final MemberService memberService;
    public MemberController2() {
        this.memberService = new MemberServiceImpl();
    };
    protected void doService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();
        // uri 문자열의 마지막 '/' 위치의 뒷부분을 문자열로 반환
        String action = uri.substring(uri.lastIndexOf("/") + 1);
        // Http 세션 객체 생성
        HttpSession session = request.getSession();
        String view = "/WEB-INF/"; // view 경로 지정

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String className = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/" + "db_no";
        String dbUser = "root";
        String dbPass = "cometrue";

        try{
            Class.forName(className); //드라이버 로딩 : MySQL - "com.mysql.cj.jdbc.Driver"
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            // 적재된 드라이버 관리자 객체의 getConnection() 정적메소드를 호출하여 Connection 객체 생성
            // Connection -> statement / PreparedStatement 객체 생성 -> query 실행
            // -> ResultSet (read) or 영향받은 row 수(create, update, delete) 반환
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        if(action.equals("register-form")) {
            request.getRequestDispatcher(view + "members/register-form.jsp").forward(request, response);
        }
        else if(action.equals("post")) {
            Member member = new Member();
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            member.setPhone(request.getParameter("phone"));
            member.setAddress(request.getParameter("address"));
            member.setRole(request.getParameter("role"));
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

            if (rows > 0) {
                response.sendRedirect("../members/login-form");
            } else {
                request.setAttribute("errMsg", "회원 가입 실패");
                request.getRequestDispatcher(view + "errors/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("login-form")) {
            request.getRequestDispatcher(view + "/members/login-form.jsp").forward(request, response);
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doService(request, response);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doService(request, response);
    }
    @Override
    public void destroy() {
        // 자원 회수
        super.destroy();
    }
}
