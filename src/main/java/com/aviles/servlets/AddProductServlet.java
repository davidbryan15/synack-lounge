package com.aviles.servlets;

import com.aviles.entity.Product;
import com.aviles.util.ProductDBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addproduct", value = "/addproduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get product id from form & session
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer productQuantity = Integer.parseInt(request.getParameter("quantity"));


        System.out.println("productID:" + productId);
        System.out.println("productQuantity:" + productQuantity);

        //get session
        HttpSession session = request.getSession();

        //get product from db
        Product tempProduct = ProductDBUtil.getProduct(productId);
        System.out.println("tempProduct from AddProductServlet: " + tempProduct);

        //get current session shopping cart
        List<Product> productList = (List<Product>) session.getAttribute("productlist");
        System.out.println("productList: " + productList );

        //check if product is already in the cart
        boolean isAlreadyInCart = checkCart(tempProduct, productList);
        System.out.println("isAlreadyInCart: " + isAlreadyInCart);


        //if cart is null or empty or product is not in cart at all, add new item
        if(productList == null || productList.isEmpty()){
            productList = new ArrayList<>();
            tempProduct.setProductQuantity(productQuantity);
            tempProduct.setProductPrice(productQuantity*tempProduct.getProductPrice());
            productList.add(tempProduct);
            System.out.println("TempProduct added: " + tempProduct);
        }
        else if(!isAlreadyInCart){
            tempProduct.setProductQuantity(productQuantity);
            tempProduct.setProductPrice(productQuantity*tempProduct.getProductPrice());
            productList.add(tempProduct);
        }
        else if(isAlreadyInCart){
                for(Product product: productList){
                    if(product.getProductId() == tempProduct.getProductId()){
                        int newQuantity = product.getProductQuantity() + productQuantity;
                        product.setProductQuantity(newQuantity);
                        product.setProductPrice(newQuantity*product.getProductPrice());
                    }
                }
            System.out.println("product List after loop: " + productList);
        }

        //forward product to session for tracking
        session.setAttribute("productlist", productList);

        getServletContext().getRequestDispatcher("/shopping-cart.jsp").forward(request,response);
    }


//    New Method for checking current cart

    private boolean checkCart(Product tempProduct, List<Product> productlist) {
        boolean isAlreadyInCart = false;

        if(productlist == null || productlist.isEmpty()){
            isAlreadyInCart = false;
        }
        else {
            for(Product product: productlist){
                if(product.getProductId() == tempProduct.getProductId()){
                    isAlreadyInCart = true;
                    break;
                }
            }
        }

         return isAlreadyInCart;
    }

}
