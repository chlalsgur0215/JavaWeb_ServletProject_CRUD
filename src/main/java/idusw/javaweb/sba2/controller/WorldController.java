package idusw.javaweb.sba2.controller;

import idusw.javaweb.sba2.domain.City;
import idusw.javaweb.sba2.domain.Country;
import idusw.javaweb.sba2.domain.Language;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name="jdbcController",
        urlPatterns = {"/world/country", "/world/city", "/world/language"})
public class WorldController extends HttpServlet {
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
        String tbName = uri.substring(uri.lastIndexOf('/') + 1);

        String jdbcUrl = dbUrl + "world"; // dbServer == jdbc:mysql://localhost:3306/
        String query = "";
        String view = "/WEB-INF/world/";
        try { /* 드라이버 로딩 : 운영체제가 하드웨어를 제어하는데 사용하는 프로그램 */
            Class.forName("com.mysql.cj.jdbc.Driver"); /* mysql connector */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            // 로딩된 드라이버, 드라이버관리자의 getConnection 메소드를 호출하여 연결 객체를 반환
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
            // 연결객체를 활용하여 질의를 처리할 수 있는 문장 객체를 생성하여 반환
            stmt = conn.createStatement();
            // 지정된 질의를 실행하고, 결과(조회 - ResultSet, 생성, 수정, 삭제 - int )를 반환

            if(tbName.equals("country")) {
                query = "select * from country";
                rs = stmt.executeQuery(query);
                ArrayList<Country> countries = new ArrayList<Country>();
                Country country = null;
                while (rs.next()) {
                    country = new Country();
                    // rs : 결과 집합 객체에서 필드명에 해당하는 문자열 값을 가져와 country 객체에 배정
                    country.setCode(rs.getString(1));
                    country.setName(rs.getString(2));
                    country.setContinent(rs.getString(3));
                    country.setRegion(rs.getString(4));
                    // 생성된 country 객체를 countries라는 집합객체의 원소로 추가
                    countries.add(country);
                }
                request.setAttribute("list", countries);
                request.getRequestDispatcher(view + "country.jsp").forward(request, response);
            } else if(tbName.equals("city")) {
                query = "select * from city order by id desc";
                rs = stmt.executeQuery(query);
                ArrayList<City> cities = new ArrayList<City>();
                City city = null;
                while (rs.next()) {
                    city = new City();
                    city.setId(rs.getInt(1)); // int : 4 bytes, long : 8 bytes
                    city.setName(rs.getString(2));
                    city.setCountryCode(rs.getString(3));
                    city.setDistrict(rs.getString(4));
                    city.setPopulation(rs.getInt(5));
                    cities.add(city);
                }
                request.setAttribute("list", cities);
                request.getRequestDispatcher(view + "city.jsp").forward(request, response);
            }
            else if(tbName.equals("language")) {
                query = "select * from countrylanguage";
                rs = stmt.executeQuery(query);
                ArrayList<Language> languages = new ArrayList<Language>();
                Language language = null;
                while (rs.next()) {
                    language = new Language();
                    language.setCountryCode(rs.getString(1));
                    language.setLanguage(rs.getString(2));
                    language.setIsOfficial(rs.getString(3));
                    language.setPopulation(rs.getString(4));
                    languages.add(language);
                }
                request.setAttribute("list", languages);
                request.getRequestDispatcher(view + "country-language.jsp").forward(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

}
