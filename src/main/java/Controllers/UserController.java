package Controllers;

import DataAccess.UserDAO;
import Model.Product;
import Model.User;

public class UserController {
    public static UserController instance;

    private UserController(){}

    public static UserController getInstance(){
        if(instance == null)
            instance = new UserController();

        return instance;
    }


    public boolean isValidLogin(String username, String password) {
        UserDAO userDAO = UserDAO.getInstance();
        User user = userDAO.getUser(username);
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void addProductToCart(User u, Product p)
    {
        UserDAO.getInstance().addProductToCart(u, p);
    }

    public void removeProductFromCart(User u, int id)
    {
        UserDAO.getInstance().removeProductFromCart(u, id);
    }
}
