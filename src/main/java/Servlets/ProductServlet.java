package Servlets;

import Controllers.ProductController;
import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        Product product = ProductController.getInstance().getProduct(productName);
        req.setAttribute("product",product);
        req.getRequestDispatcher("Views/Product.jsp").forward(req,resp);
    }
}
