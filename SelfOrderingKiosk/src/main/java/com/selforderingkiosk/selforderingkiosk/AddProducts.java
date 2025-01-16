package com.selforderingkiosk.selforderingkiosk;

import com.selforderingkiosk.selforderingkiosk.common.ProductDto;
import com.selforderingkiosk.selforderingkiosk.ejb.ProductsBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
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
@WebServlet(name = "AddProducts", value = "/AddProducts")
public class AddProducts extends HttpServlet {
    @Inject
    ProductsBean productsBean;

       public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


           String name=request.getParameter("name");
           String description=request.getParameter("description");
           String price=request.getParameter("price");
           String category=request.getParameter("category");
           String image=request.getParameter("image");

           Double priceTest=null;
           if(price!=null&&!price.isEmpty()){
               priceTest=Double.parseDouble(price);
           }
           productsBean.createProduct(name,description, priceTest,category,image);

           response.sendRedirect(request.getContextPath() + "/popup_msg.jsp");

       }


}
