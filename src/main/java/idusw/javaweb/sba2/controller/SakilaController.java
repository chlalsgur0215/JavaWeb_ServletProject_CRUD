package idusw.javaweb.sba2.controller;

import idusw.javaweb.sba2.domain.Actor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name="sakilaController",
        urlPatterns = {"/sakila/actors", "/sakila/register-form", "/sakila/register",
                "/sakila/update-form", "/sakila/update", "/sakila/delete-form", "/sakila/delete"})
public class SakilaController extends HttpServlet {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dbUrl = getServletContext().getInitParameter("dbUrl");
        String dbUser = getServletContext().getInitParameter("dbUser");
        String dbPass = getServletContext().getInitParameter("dbPass");
        // URI에서는 마지막 '/' 뒷 부분을 서브스트링화
        String uri = request.getRequestURI();
        String cmd = uri.substring(uri.lastIndexOf('/') + 1);

        String jdbcUrl = dbUrl + "sakila";
        String query = "";
        String view = "/WEB-INF/sakila/";
        try { /* 드라이버 로딩 : 운영체제가 하드웨어를 제어하는데 사용하는 프로그램 */
            Class.forName("com.mysql.cj.jdbc.Driver"); /* mysql connector */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            // 로딩된 드라이버, 드라이버관리자의 getConnection 메소드를 호출하여 연결 객체를 반환
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
            // 연결객체를 활용하여 질의를 처리할 수 있는 문장 객체를 생성하여 반환
            if(cmd.equals("actors")) {
                query = "select * from actor order by actor_id desc"; // sakila DB에 포함된 actor 테이블에 질의
                stmt = conn.createStatement();
                // 지정된 질의를 실행하고, 결과(조회 - ResultSet, 생성, 수정, 삭제 - int )를 반환
                rs = stmt.executeQuery(query);
                ArrayList<Actor> actors = new ArrayList<Actor>();
                Actor actor = null;
                while (rs.next()) {
                    actor = new Actor();
                    actor.setActorId(rs.getInt(1));
                    actor.setFirstName(rs.getString(2));
                    actor.setLastName(rs.getString(3));
                    actor.setLastUpdate(rs.getTimestamp(4));
                    actors.add(actor);
                }
                request.setAttribute("list", actors);
                request.getRequestDispatcher(view + "actors.jsp").forward(request, response);
            }
            else if(cmd.equals("register")) { // select * from tbName : actor order by last_update desc;
                query = "insert into actor(first_name, last_name) values (\'" +
                    request.getParameter("first_name") + "\', \'" +
                    request.getParameter("last_name") + "\')"; // sakila DB에 포함된 actor 테이블에 질의
                stmt = conn.createStatement();
                int i = stmt.executeUpdate(query);
                if(i >= 1) {
                    response.sendRedirect("./actors"); // 정상 처리 : 목록 보기를 호출
                } else
                    response.sendRedirect("./404"); // 오류 처리
            }
            else if(cmd.equals("update")) { // select * from tbName : actor order by last_update desc;
                query = "update actor set first_name = ?, last_name= ? where actor_id = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, request.getParameter("first-name"));
                pstmt.setString(2, request.getParameter("last-name"));
                pstmt.setInt(3, Integer.parseInt(request.getParameter("actor-id")));
                int i = pstmt.executeUpdate();
                if(i >= 1) {
                    response.sendRedirect("./actors"); // 정상 처리 : 목록 보기를 호출
                } else
                    response.sendRedirect("./404"); // 오류 처리
            }
            else if(cmd.equals("delete")) { // select * from tbName : actor order by last_update desc;
                System.out.println("delete-89");
                query = "delete from actor where actor_id = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, Integer.parseInt(request.getParameter("actor-id")));
                int i = pstmt.executeUpdate();
                if(i >= 1) {
                    response.sendRedirect("./actors"); // 정상 처리 : 목록 보기를 호출
                } else
                    response.sendRedirect("./404"); // 오류 처리
            }
        } catch(SQLException e)  {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) {}
            if (pstmt != null) try {pstmt.close(); } catch (Exception e) {}
            if (stmt != null) try {stmt.close(); } catch (Exception e) {}
            if (conn != null) try {conn.close(); } catch (Exception e) {}
        }
    }
    HttpSession session;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String cmd = uri.substring(uri.lastIndexOf('/') + 1);
        String view = "/WEB-INF/sakila/";
        if (cmd.equals("register-form")) {
            request.getRequestDispatcher(view + "register-form.jsp").forward(request, response);
        }
        else if (cmd.equals("update-form")) {
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("fn", request.getParameter("fn"));
            request.setAttribute("ln", request.getParameter("ln"));
            request.getRequestDispatcher(view + "update-form.jsp").forward(request, response);
        }
        else if (cmd.equals("delete-form")) {
            request.setAttribute("id", request.getParameter("id"));
            request.getRequestDispatcher(view + "delete-form.jsp").forward(request, response);
        }
        else
            process(request, response); // register, actors, update, delete
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

}
