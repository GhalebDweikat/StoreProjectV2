package Servlets;


import Controllers.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Views/Login.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = UserController.getInstance();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberme = req.getParameter("remember");

        if (userController.isValidLogin(username,password)) {
            req.getSession().setAttribute("user", userController.getUser(username));
            if ("yes".equals(rememberme)) {
                Cookie c = new Cookie("user", username);
                c.setMaxAge(7 * 24 * 60 * 60);
                resp.addCookie(c);
            } else {
                Cookie c = new Cookie("user", null);
                c.setMaxAge(0);
                resp.addCookie(c);

            }
            resp.sendRedirect("/home");
        }  else {
            req.getSession().setAttribute("err_msg", "Username and/or password invalid.");
            req.getRequestDispatcher("Views/Login.jsp").forward(req,resp);
        }


    }
}
