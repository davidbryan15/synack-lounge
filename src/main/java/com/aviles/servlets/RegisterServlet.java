package com.aviles.servlets;

import com.aviles.entity.Credentials;
import com.aviles.entity.User;
import com.aviles.util.UserDbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get params from form
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String email = request.getParameter("email").trim();
        String username = request.getParameter("username").trim();
        String pass = request.getParameter("password").trim();


        //create new credentials object and user
        Credentials tempCred = new Credentials(username, pass);
        User tempUser = new User(firstName, lastName, email, tempCred);

        //create url for later usage
        String url;

        //check if user is already in DB using email address
        if(isExistingUser(tempUser)){
            //set request attribute to true to show error to user
            request.setAttribute("alreadyExists", "true");
            url = "/register.jsp";
        }
        //if fields are not blank then add user
        else if(!tempUser.isEmpty() && !tempCred.isEmpty()){
            //add user to db
            UserDbUtil.addUser(tempUser);

            //set session variables
            HttpSession session = request.getSession();

            //add user to session for name display
            session.setAttribute("user", tempUser);

            //set loggedin value as true for visibility factors
            session.setAttribute("loggedIn", true);

            url = "/user-confirmation.jsp";
        }
        else {
            request.setAttribute("nullerror", "true");
            url = "/register.jsp";
        }

        //forward to jsp
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }


    //method to check is user is already part of DB
    public static boolean isExistingUser(User user){
        boolean isExistingUser = false;

        List<User> users = UserDbUtil.getUsers();

        for(User tempUser : users) {
            if (tempUser.getEmail().equalsIgnoreCase(user.getEmail())) {
                isExistingUser = true;
            }
        }
        return isExistingUser;
    }
}
