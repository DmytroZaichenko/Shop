import java.util.Date;

public class Transaction {

    private int idCustomer;
    private int idProduct;
    private Date date;
    private double count;
    private double price;

    public Transaction(int idCustomer, int idProduct, Date date, double count, double price) {
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.date = date;
        this.count = count;
        this.price = price;
    }
}
