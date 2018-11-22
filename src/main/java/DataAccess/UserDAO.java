package DataAccess;

import Model.Product;
import Model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    List<User> userList;
    String inputFileName = "";

    private UserDAO() {
        try {
            inputFileName = UserDAO.class.getClassLoader().getResource("users.txt").toURI().getPath();
        }catch(Exception ex){System.err.println(ex.getMessage());}
        userList = getUsersFromFile(inputFileName);
    }

    static UserDAO instance;

    public static UserDAO getInstance(){
        if(instance == null)
            instance = new UserDAO();

        return instance;
    }

    private List<User> getUsersFromFile(String filename){
        List<User> users = new ArrayList<User>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\s+");
                User u = new User(data[0], data[1], data[2]);
                users.add(u);
            }
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }

        return users;
    }

    public void addUser(String username, String password){
        String userId = generateId() + "";
        userList.add(new User(userId, username, password));
        refreshFile(inputFileName);// not very efficient, rewriting the whole file after every write, but this allows for update user in the future to change password. This can be moved to
                                    // a thread instead and also when the object is being destroyed.
    }

    public User getUser(String username){
        for (User u: userList) {
            if(u.getUsername().equals(username))
            {
                return u;
            }
        }
        return null;
    }

    public void refreshFile(String filename){
        StringBuilder sb = new StringBuilder();
        for (User u: userList) {
            sb.append(u.getUserId());
            sb.append(" ");
            sb.append(u.getUsername());
            sb.append(" ");
            sb.append(u.getPassword());
            sb.append(System.getProperty("line.separator"));
        }

        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(sb.toString());
        }
        catch (Exception ex){

        }
    }

    public void addProductToCart(User u, Product p)
    {
        u.getCart().addProduct(p);
    }

    public void removeProductFromCart(User u, int id)
    {
        u.getCart().removeProduct(id);
    }

    public int generateId(){
        return userList.size();
    }
}
