package idusw.javaweb.sba2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="sba2Controller",
        urlPatterns = {"/home/index", "/home/buttons", "/home/cards",
                "/home/border", "/home/color", "/home/animation", "/home/other",
                "/home/login", "/home/register", "/home/forgot-password", "/home/404", "/home/blank",
                "/home/charts", "/home/tables"})
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf('/') + 1);

        String view = "/WEB-INF/home/";

        view = view + action + ".jsp";

        request.getRequestDispatcher(view).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
