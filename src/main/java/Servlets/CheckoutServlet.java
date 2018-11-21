package Servlets;

import Controllers.UserController;
import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        List<Product> products = UserController.getInstance().getUser(username).getCart().getProducts();
        req.setAttribute("products",products);
        req.getRequestDispatcher("Views/Checkout.jsp").forward(req,resp);
    }
}
