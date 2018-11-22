package Servlets;

import Controllers.ProductController;
import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/home")
public class HomepageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
            List<Product> products = ProductController.getInstance().getAllProducts();
            req.getSession().setAttribute("products", products);
            req.getRequestDispatcher("Views/Homepage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        if (params.containsKey("name")) {
            String[] names = params.get("name");
            List<Product> products = ProductController.getInstance().getProduct(names[0]);
            req.setAttribute("products", products);
            req.getRequestDispatcher("Views/Homepage.jsp").forward(req, resp);
        } else {
            List<Product> products = ProductController.getInstance().getAllProducts();
            req.getSession().setAttribute("products", products);
            req.getRequestDispatcher("Views/Homepage.jsp").forward(req, resp);
        }
    }
}