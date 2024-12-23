package com.selforderingkiosk.selforderingkiosk;

import entities.OrderedProduct;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add_to_cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<OrderedProduct> cart = (List<OrderedProduct>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        OrderedProduct product = new OrderedProduct();
        product.setName(productName);
        product.setPrice(productPrice);
        product.setQuantity(quantity);

        boolean found = false;
        for (OrderedProduct p : cart) {
            if (p.getName().equals(product.getName())) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                found = true;
                break;
            }
        }

        if (!found) {
            cart.add(product);
        }

        session.setAttribute("cart", cart);

        response.sendRedirect("dine_in?section=oferte");
    }
}
