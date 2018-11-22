package Servlets;

import Controllers.ProductController;
import DataAccess.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("added") != null && (boolean)req.getSession().getAttribute("added") == true) {
            req.setAttribute("msg", "Added Successfully");
            req.getSession().setAttribute("added", false);
        }
        req.getRequestDispatcher("/Views/addproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int id = ProductDAO.getInstance().generateId();
        String name = req.getParameter("name");
        String description = req.getParameter("desc");
        double price = Double.parseDouble(req.getParameter("price"));
        ProductController.getInstance().addProduct(name, description, price);
        req.getSession().setAttribute("added", true);
        resp.sendRedirect("/home");
    }
}
