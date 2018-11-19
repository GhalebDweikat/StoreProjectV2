package Model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p)
    {
        products.add(p);

    }

    public void removeProduct(int id){
        Product p = null;
        for (Product prd: products
             ) {
            if(prd.getProductId() == id) p = prd;
        }
        if(p != null)
            products.remove(p);
    }
}
