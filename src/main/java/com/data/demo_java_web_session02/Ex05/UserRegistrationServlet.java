package com.data.demo_java_web_session02.Ex05;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserRegistrationServlet", value = "/register05")
public class UserRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("password", password);

        request.getRequestDispatcher("userinfoEx05.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registerEx05.html");
    }
}