package Controllers;

import DataAccess.ProductDAO;
import Model.Product;

import java.util.ArrayList;

public class ProductController {
    public void addProduct(int productID, String productName, String productDescription, double price){
        ArrayList<Product> productList = ProductDAO.getInstance().getProducts();
        productList.add(new Product(productID,productName,productDescription,price));

    }
}
