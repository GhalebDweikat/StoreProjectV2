package Controllers;

import DataAccess.ProductDAO;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    public void addProduct(int productID, String productName, String productDescription, double price){
        List<Product> productList = ProductDAO.getInstance().getProducts();
        productList.add(new Product(productID,productName,productDescription,price));
        //ProductDAO.getInstance().

    }
}
