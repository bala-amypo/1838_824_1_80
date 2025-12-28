package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setStatus(200);
        resp.getWriter().write("Servlet Alive");
    }
}
