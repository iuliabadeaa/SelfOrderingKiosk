package com.selforderingkiosk.selforderingkiosk;

import com.selforderingkiosk.selforderingkiosk.ejb.OrderedProductsBean;
import entities.Order;
import entities.OrderedProduct;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/place_order")
public class PlaceOrderServlet extends HttpServlet {

    @Inject
    OrderedProductsBean orderedProductsBean;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String totalStr = req.getParameter("total");

        List<OrderedProduct> cart = (List<OrderedProduct>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            resp.sendRedirect("dine_in?section=oferte");
        }

        for (OrderedProduct p : cart) {
            String name = p.getName();
            Double price = p.getPrice();
            Integer quantity = p.getQuantity();
            orderedProductsBean.createOrderedProducts(name,price,quantity);

        }

        Order order=new Order();
        order.setType("Dine In");
        if (totalStr != null) {
            try {
                double total = Double.parseDouble(totalStr);

                order.setTotal(total);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        order.setStatus("Preparing");

        resp.sendRedirect(req.getContextPath()+"index");
    }
}
