package DataAccess;

import Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    List<Product> productList;
    String inputFileName;
    static ProductDAO instance;
    private ProductDAO(){
        try {
            inputFileName = UserDAO.class.getClassLoader().getResource("products.txt").toURI().getPath();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        productList = getProductsList();}

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
            if(p.getId() == id)
                return p;
        }

        return null;
    }

    public List<Product> getProducts(String name){
        List<Product> result = new ArrayList<>();

        for (Product p:productList
        ) {
            if(p.getName().startsWith(name))
                result.add(p);
        }

        return result;
    }

    private List<Product> getProductsList() {
        List<Product> products = new ArrayList<>();
        String line;
        String[] temp = {};
        try(BufferedReader br = new BufferedReader(new FileReader(inputFileName))){
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
    public void writeListToFile(List<Product> productList){
        StringBuilder sb = new StringBuilder();
        for (Product product:productList
        ) {
            sb.append(product.getId()+"%%");
            sb.append(product.getName()+"%%");
            sb.append(product.getDescription()+"%%");
            sb.append(product.getPrice());
            sb.append("line.separator");
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName))){
            bw.write(sb.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
