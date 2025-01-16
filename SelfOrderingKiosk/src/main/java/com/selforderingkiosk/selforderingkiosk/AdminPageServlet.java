package com.selforderingkiosk.selforderingkiosk;

import com.selforderingkiosk.selforderingkiosk.common.ProductDto;
import com.selforderingkiosk.selforderingkiosk.ejb.ProductsBean;
import entities.Product;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DeclareRoles({"ADMIN"})
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"ADMIN"}))
@WebServlet(name = "AdminPage", value = "/AdminPage")
public class AdminPageServlet extends HttpServlet {

    @Inject
    ProductsBean productsBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String section = request.getParameter("section");
        List<ProductDto> products=productsBean.findAllProducts();


        if (section == null || section.isEmpty()) {
            section = "add_products";
        }
        request.setAttribute("activeSection", section);
        request.setAttribute("products", products);

        request.getRequestDispatcher("/WEB-INF/pages/admin_page.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


            String[] productIdsAsString = request.getParameterValues("products_ids");
            if(productIdsAsString !=null) {
                List<Long> productsId=new ArrayList<>();
                for (String productId : productIdsAsString) {
                    productsId.add(Long.parseLong(productId));
                }
                productsBean.deleteProductsById(productsId);
            }

        response.sendRedirect(request.getContextPath() + "/popup_msg.jsp");


    }

}
