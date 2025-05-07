package com.data.demo_java_web_session02.Ex04;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/register01")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("email", email);

        response.sendRedirect("thankyou.jsp");
    }
}