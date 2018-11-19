package Controllers;

import DataAccess.ProductDAO;
import Model.Product;

import java.util.ArrayList;

public class ProductController {

    static ProductController instance;

    public static ProductController getInstance() {
        if (instance==null){
            instance = new ProductController();
        }
        return instance;
    }

    private ProductController(){};



    public void addProduct(int productID, String productName, String productDescription, double price){
        ArrayList<Product> productList = ProductDAO.getInstance().getProducts();
        productList.add(new Product(productID,productName,productDescription,price));
        ProductDAO.getInstance().writeListToFile(productList);
    }
    public ArrayList<Product> getAllProducts(){
        return ProductDAO.getInstance().getProducts();
    }
    public Product getProduct(String name){
        ArrayList<Product> products = ProductDAO.getInstance().getProducts();
        for (Product prod:products
        ) {
            if (prod.getProductName().equalsIgnoreCase(name)){
                return prod;
            }
        }
        return null;
    }
    public Product getProduct(int productID){
        ArrayList<Product> products = ProductDAO.getInstance().getProducts();
        for (Product prod:products
        ) {
            if (prod.getProductId()== productID){
                return prod;
            }
        }
        return null;
    }
}