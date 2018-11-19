package DataAccess;

import Model.Product;

import java.util.Date;
import java.util.List;

public class TransactionDAO {

    String inputFileName = "transactions.txt";

    private TransactionDAO() {
    }

    static TransactionDAO instance;

    public static TransactionDAO getInstance(){
        if(instance == null)
            instance = new TransactionDAO();

        return instance;
    }

    public void addTransaction(String txId, Date timestamp, double total, List<Product> products){
        //write to file somehow, I think we can ignore them for now and just assume all transactions get written somewhere.
        //in the future, we can display order history.

    }
}
