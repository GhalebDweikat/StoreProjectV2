package Servlets;

import Controllers.UserController;
import Model.Product;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        String username = req.getParameter("user");

        if (params.containsKey("pay")) {
            UserController.getInstance().getUser(username).getCart().removeAllProducts();
            req.getRequestDispatcher("/home").forward(req, resp);
        } else {
            List<Product> products = UserController.getInstance().getUser(username).getCart().getProducts();
            req.setAttribute("products", products);
            req.getRequestDispatcher("Views/Checkout.jsp").forward(req, resp);
        }
    }

}
