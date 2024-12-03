package com.selforderingkiosk.selforderingkiosk;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/menu")
public class DineInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String section = request.getParameter("section");

        if (section == null || section.isEmpty()) {
            section = "oferte";
        }

        request.setAttribute("activeSection", section);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dine_in.jsp");
        dispatcher.forward(request, response);
    }
}
