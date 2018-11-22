package Servlets;

import Controllers.ProductController;
import Controllers.UserController;
import DataAccess.UserDAO;
import Model.Product;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(params.containsKey("add"))
        {
            Product prod = ProductController.getInstance().getProduct(Integer.parseInt(params.get("add")[0]));
            UserController.getInstance().addProductToCart(user, prod);
            resp.getWriter().println(user.getCart().getProducts().size());
        }
        else if(params.containsKey("remove")) {
            UserController.getInstance().removeProductFromCart(user, Integer.parseInt(params.get("remove")[0]));
            resp.getWriter().write(user.getCart().getProducts().size());
        }
        else
        {
            req.setAttribute("products", user.getCart().getProducts());
            req.getRequestDispatcher("Views/Cart.jsp").forward(req,resp);
        }
    }
}
