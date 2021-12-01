package com.aviles.servlets;

import com.aviles.entity.Credentials;
import com.aviles.entity.User;
import com.aviles.util.CredentialsDbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //constant fields
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "";


        if(action.equals("login")) {

            //read parameters from form
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //check if credentials are valid
            boolean correctLogin = CredentialsDbUtil.checkCredentials(username, password);

            System.out.println("Correct Login value:" + correctLogin);

            if(correctLogin) {
                //get user from true login
                User tempUser = CredentialsDbUtil.getUserFromCreds(username, password);

                System.out.println("========>>> User tempUser from Login Servlet: " + tempUser);

                //set session attributes
                session.setAttribute("user", tempUser);
                session.setAttribute("loggedIn", true);

                url="/welcome.jsp";

            } else {
                request.setAttribute("loginerror", "true");
                url="/login.jsp";
            }

        }
        else if(action.equals("logout")) {

            //reset values
            session.setAttribute("user", null);
            session.setAttribute("loggedIn", false);

            url="/welcome.jsp";
        }


        //forward to page
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
