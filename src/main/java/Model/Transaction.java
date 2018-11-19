package Model;

import java.util.Date;
import java.util.List;

public class Transaction {
    String txId;
    Date timestamp;
    double total;
    User user;
    List<Product> products;

    public Transaction(String txId, Date timestamp, double total, User user, List<Product> products) {
        this.txId = txId;
        this.timestamp = timestamp;
        this.total = total;
        this.user = user;
        this.products = products;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
