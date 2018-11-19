package DataAccess;

import Model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    List<Product> productList;
    String inputFileName = "products.txt";
    static ProductDAO instance;
    private ProductDAO(){ productList = getProductsList();}

    public static ProductDAO getInstance(){
        if(instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    public List<Product> getProducts(){
        return productList;
    }

    public Product getProduct(int id)
    {
        for (Product p:productList
             ) {
            if(p.getProductId() == id)
                return p;
        }

        return null;
    }

    public List<Product> getProducts(String name){
        List<Product> result = new ArrayList<>();

        for (Product p:productList
        ) {
            if(p.getProductName().startsWith(name))
                result.add(p);
        }

        return result;
    }

    private List<Product> getProductsList() {
        List<Product> products = new ArrayList<>();
        String name, description,line;
        double price;
        int id;
        String[] temp = {};
        try(BufferedReader br = new BufferedReader(new FileReader("DataAccess/products.txt"))){
            while ((line = br.readLine()) != null) {
                temp = line.split("%%");
                Product product = new Product(Integer.parseInt(temp[0]),temp[1],temp[2],Double.parseDouble(temp[3]));
                products.add(product);
            }
        } catch (IOException e){
            System.out.println("File Not Found");
        }
        return products;
    }

}
