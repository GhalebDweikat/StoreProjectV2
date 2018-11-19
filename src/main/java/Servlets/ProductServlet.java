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
import java.util.List;
import java.util.Map;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        if(params.containsKey("name"))
        {
            String[] names = params.get("name");
            List<Product> products = ProductController.getInstance().getProduct(names[0]);
            req.setAttribute("products", products);
            req.getRequestDispatcher("Views/Homepage.jsp").forward(req,resp);


        }
        else if(params.containsKey("id"))
        {
            String id = params.get("id")[0];
            Product product = ProductController.getInstance().getProduct(Integer.parseInt(id));
            req.setAttribute("selectedProduct", product);
            req.getRequestDispatcher("Views/Product.jsp").forward(req,resp);
        }
        else if(params.containsKey("nameAjax"))
        {
            String[] names = params.get("name");
            List<Product> products = ProductController.getInstance().getProduct(names[0]);
            //todo
            // Convert Product to jackson write to output so that JQuery can convert to object and use it to display
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
