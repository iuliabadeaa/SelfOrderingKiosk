package com.selforderingkiosk.selforderingkiosk;

import com.selforderingkiosk.selforderingkiosk.common.DiscountDto;
import com.selforderingkiosk.selforderingkiosk.ejb.DiscountsBean;
import entities.Discount;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.lang.String;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ApplyDiscount", value="/ApplyDiscount")
public class ApplyDiscountServlet extends HttpServlet {

    @Inject
    DiscountsBean discountsBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String discount = request.getParameter("discount");
        String total = request.getParameter("total");

        if (total == null || total.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Valoarea totală este lipsă sau invalidă.");
            request.setAttribute("section", "oferte");
            RequestDispatcher dispatcher = request.getRequestDispatcher("dine_in");
            dispatcher.forward(request, response);
            return;
        }

        Double totalInt = Double.parseDouble(total);

        boolean validDiscount = checkDiscount(discount);
        response.setContentType("text/html");

        if (validDiscount) {
            totalInt = totalInt - (totalInt*15 / 100);


            request.setAttribute("total", totalInt.toString());
            request.setAttribute("section", "oferte");
            RequestDispatcher dispatcher = request.getRequestDispatcher("dine_in");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("errorMessage", "Codul de reducere nu este valid.");
            request.setAttribute("total", total);
            request.setAttribute("section", "oferte");
            RequestDispatcher dispatcher = request.getRequestDispatcher("dine_in");
            dispatcher.forward(request, response);

        }
        response.sendRedirect(request.getContextPath());


    }

    private boolean checkDiscount(String discount) {
        List<DiscountDto> d = discountsBean.findAllDiscounts();
        for (DiscountDto dto : d) {
            if (dto.getCode().equals(discount)) {
                return true;
            }
        }
        return false;
    }


}
