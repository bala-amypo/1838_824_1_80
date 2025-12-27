package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/simple-status")
public class SimpleStatusServlet extends HttpServlet {
    @Override
   // SimpleStatusServlet.java
@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    resp.setStatus(HttpServletResponse.SC_OK);
}


}
