package idusw.javaweb.sba2.controller;

import idusw.javaweb.sba2.domain.Member;
import idusw.javaweb.sba2.service.MemberService;
import idusw.javaweb.sba2.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name="memberController",
        urlPatterns = {"/members/register-form", "/members/post",
                "/members/list", "/members/get", "/members/update", "/members/delete",
                "/members/login-form", "/members/login",
                "/members/logout-form", "/members/logout"})
public class MemberController extends HttpServlet {
    private final MemberService memberService;
    public MemberController() {
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
        String className = "com.mysql.cj.jdbc.Driver"; String dbUrl = "jdbc:mysql://localhost:3306/" + "db_no"; String dbUser = "root"; String dbPass = "cometrue";
        try{ Class.forName(className);
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch(ClassNotFoundException | SQLException e){ e.printStackTrace(); }

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
            if (memberService.create(member) > 0) {
                response.sendRedirect("../members/login-form");
            } else {
                request.setAttribute("errMsg", "회원 가입 실패");
                request.getRequestDispatcher(view + "errors/message.jsp").forward(request, response);
            }

        }
        else if(action.equals("login-form")) {
            request.getRequestDispatcher(view + "/members/login-form.jsp").forward(request, response);
        }
        else if(action.equals("login")) {
            String email = request.getParameter("email");
            String pw = request.getParameter("password");
            String remember = request.getParameter("remember");
            Member member = new Member();
            member.setEmail(email);
            member.setPassword(pw);
            Member retMember = null;
            if ((retMember = memberService.read(member)) != null) {
                session.setAttribute("logedIn", retMember);
                // 키값을 logedIn 바꿨음, ${sessionScope.logedIn}
                if(retMember.getEmail().equals("admin@induk.ac.kr")){
                    session.setAttribute("admin", retMember);
                }
                response.sendRedirect("../home/index");
            }
            else {
                request.setAttribute("errMsg", "로그인 실패");
                request.getRequestDispatcher(view +"errors/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("logout-form")) {
            request.getRequestDispatcher(view + "members/logout-form.jsp").forward(request, response);
        }
        else if(action.equals("logout")) {
            session.invalidate(); // session 객체를 무효화 (메모리에 존재하지않으므로 접근 안됨)
            response.sendRedirect("../home/index");
        }
        else if(action.equals("get")) {
            Member member = (Member) session.getAttribute("logedIn");
            Member retMember = null;
//            member.setEmail(request.getParameter("email"));
//            member.setPassword(request.getParameter("password"));
// 매개변수로 요청받아 Member형의 member객체에 저장. member객체를 매개변수로 하여 read()메서드 호출.
            if ((retMember = memberService.read(member)) != null) {
                request.setAttribute("member", retMember);
                request.getRequestDispatcher(view + "members/update-form.jsp").forward(request, response);
            } else { request.setAttribute("errMsg", "정보 조회 실패");
                request.getRequestDispatcher(view + "errors/message.jsp").forward(request, response); }
        }
        else if(action.equals("list")) {
            ArrayList<Member> members = null;
            if((members = (ArrayList<Member>) memberService.readList()) != null) {
                request.setAttribute("member", members);
                request.getRequestDispatcher(view + "members/list.jsp").forward(request,
                        response); } else {
                request.setAttribute("errMsg", "회원 목록 조회 실패");
                request.getRequestDispatcher(view +
                        "errors/message.jsp").forward(request, response); }
        }
        else if(action.equals("update-form")) {
            request.getRequestDispatcher(view + "/members/list.jsp").forward(request, response);
        }
        else if(action.equals("update")) {
            Member member = new Member();
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            member.setPhone(request.getParameter("phone"));
            member.setAddress(request.getParameter("address"));
            member.setRole(request.getParameter("role"));
            if(memberService.update(member) > 0){
                session.setAttribute("logedIn", member);
                response.sendRedirect("../home/index");// ../members/get
            } else {
                request.setAttribute("errMsg", "정보 수정 실패");
                request.getRequestDispatcher(view + "errors/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("delete")) {
            Member member = new Member();
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            member = (Member) session.getAttribute("logedIn");
            if (memberService.delete(member) > 0) {
                session.invalidate();
                response.sendRedirect("../members/register-form");
            } else { request.setAttribute("errMsg", "탈퇴 실패");
                request.getRequestDispatcher(view + "errors/message.jsp").forward(request, response); }
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
