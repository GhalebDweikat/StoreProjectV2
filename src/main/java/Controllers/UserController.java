package Controllers;

import DataAccess.UserDAO;
import Model.User;

public class UserController {

        public boolean isValidLogin(String username, String password) {
        UserDAO userDAO = UserDAO.getInstance();
        User user = userDAO.getUser(username);
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
