package com.data.demo_java_web_session02.Ex01;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LifecycleServletServlet", value = "/LifecycleServlet-servlet")
public class LifecycleServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "vong doi init(): Servlet duoc khoi tao.";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("vong doi service(): xu ly yeu cau get.");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Vong doi cua Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Vong doi cua Servlet</h1>");
        out.println("<ul>");
        out.println("<li><strong>init()</strong>: Duoc goi mot lan duy nhat khi Servlet duoc khoi tao.</li>");
        out.println("<li><strong>service()</strong>: Duoc goi moi khi co yeu cau tu client (GET/POST...)</li>");
        out.println("<li><strong>destroy()</strong>: Duoc goi mot lan duy nhat khi Servlet bi huy boi container.</li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
        System.out.println("vong doi destroy(): Servlet bi huy.");
    }
}
