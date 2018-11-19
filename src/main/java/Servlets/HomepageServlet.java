package Servlets;

import Controllers.ProductController;
import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/home")
public class HomepageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> products = ProductController.getInstance().getAllProducts();
        req.getSession().setAttribute("products", products);
        req.getRequestDispatcher("Views/Homepage.jsp").forward(req,resp);
        System.out.println("got Homepage products in session scope");
    }
}
