package com.aviles.servlets;

import com.aviles.entity.Product;
import com.aviles.util.ProductDBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/homeservlet")
public class HomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Http Session
        HttpSession session = request.getSession();

        //grab all products to display here on homepage
        List<Product> products = ProductDBUtil.getProducts();

        //add products to homepage for display
        session.setAttribute("products", products);

        //redirect to home page
        getServletContext().getRequestDispatcher("/welcome.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
