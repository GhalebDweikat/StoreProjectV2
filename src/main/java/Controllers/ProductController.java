package Controllers;

import DataAccess.ProductDAO;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    static ProductController instance;

    public static ProductController getInstance() {
        if (instance==null){
            instance = new ProductController();
        }
        return instance;
    }

    private ProductController(){}

    public void addProduct(int productID, String productName, String productDescription, double price){
        List<Product> productList = ProductDAO.getInstance().getProducts();
        productList.add(new Product(productID,productName,productDescription,price));
        ProductDAO.getInstance().writeListToFile(productList);
    }
    public List<Product> getAllProducts(){
        return ProductDAO.getInstance().getProducts();
    }
    public List<Product> getProduct(String name){
        List<Product> products = ProductDAO.getInstance().getProducts(name);
        return products;
    }

    public Product getProduct(int productID){
        List<Product> products = ProductDAO.getInstance().getProducts();
        for (Product prod:products
        ) {
            if (prod.getId()== productID){
                return prod;
            }
        }
        return null;
    }
}