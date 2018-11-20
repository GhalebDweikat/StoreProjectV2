package Model;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private double price;

    public Product(int productId, String productName, String productDescription, double price){
        this.productId = productId;
        this.price = price;
        this.productDescription = productDescription;
        this.productName = productName;
    }

    public int getId() {
        return productId;
    }

    public void setId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return productDescription;
    }

    public void setDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
