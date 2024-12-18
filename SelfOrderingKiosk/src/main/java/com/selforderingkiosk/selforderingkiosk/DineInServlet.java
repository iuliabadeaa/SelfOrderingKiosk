package com.selforderingkiosk.selforderingkiosk;

import com.selforderingkiosk.selforderingkiosk.common.ProductDto;
import com.selforderingkiosk.selforderingkiosk.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/dine_in")
public class DineInServlet extends HttpServlet {
    @Inject
    ProductsBean productsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String section = request.getParameter("section");

        if (section == null || section.isEmpty()) {
            section = "oferte";
        }
        List<ProductDto> products=productsBean.findAllProducts();
        request.setAttribute("products", products);
        request.setAttribute("activeSection", section);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dine_in.jsp");
        dispatcher.forward(request, response);
    }
}
