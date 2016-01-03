
import java.util.*;

public class Shop {

    private ActionProduct actionProduct;
    private ActionCustomer actionCustomer;
    private Report report;

    private Transaction[] transactions;

    private int[][] storage;

    public ActionCustomer getActionCustomer() {
        return actionCustomer;
    }

    public int[][] getStorage() {
        return storage;
    }

    public ActionProduct getActionProduct() {
        return actionProduct;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public Shop() {

        actionProduct = new ActionProduct();
        actionCustomer = new ActionCustomer();
        //
        storage = new int[100][2];
        transactions = new Transaction[100];

        initShop();

    }


    public void initShop(){

        //add count on the storage
        addCountToStorage(actionProduct.findProductByName("Jemeson"), 3);
        addCountToStorage(actionProduct.findProductByName("Red Label"), 5);
        addCountToStorage(actionProduct.findProductByName("Burenka"), 10);
        addCountToStorage(actionProduct.findProductByName("Kupyanskoe"), 21);

        //add transaction
//        int idxCustomer = actionCustomer.findCustomerByName("Perto");
//        int idxProduct = actionProduct.findProductByName("Burenka");
//
//        addTransaction(idxCustomer, idxProduct, getDate(-7), 1 , actionProduct.getPriceByIdx(idxProduct));
//
//        idxProduct = actionProduct.findProductByName("white bread");
//        addTransaction(idxCustomer, idxProduct, getDate(-7), 1 , actionProduct.getPriceByIdx(idxProduct));
//
//        idxCustomer = actionCustomer.findCustomerByName("Dmytro");
//        addTransaction(idxCustomer, idxProduct, getDate(-6), 2 , actionProduct.getPriceByIdx(idxProduct));
//
//        idxProduct = actionProduct.findProductByName("burenka");
//        addTransaction(idxCustomer, idxProduct, getDate(-6), 2 , actionProduct.getPriceByIdx(idxProduct));


    }

    public Date getDate(int countOfDate){

        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR,countOfDate);

        c.set(c.HOUR_OF_DAY,0);
        c.set(c.MINUTE,0);
        c.set(c.SECOND,0);
        c.set(c.MILLISECOND,0);

        return c.getTime();
    }

    public void addTransaction(int idCustomer, int idProduct, Date date, double count, double price ){

        Transaction t = new Transaction();
        t.setIdCustomer(idCustomer);
        t.setIdProduct(idProduct);
        t.setDate(date);
        t.setCount(count);
        t.setPrice(price);

        addToTransaction(t);

    }

    private void addToTransaction(Transaction t){

        for (int i = 0; i < transactions.length ; i++) {
            if (transactions[i] == null){
                transactions[i] = t;
                break;
            }
        }
    }

    public void addCountToStorage(int idxProduct, int count){

        if (idxProduct == 0){return;}

        for (int i = 0; i < storage.length; i++) {

            int idxInStorage = storage[i][0];

            if (idxInStorage == 0){
                storage[i][0] = idxProduct;
                storage[i][1] = count;
                break;
            }else if (idxInStorage == idxProduct){
                storage[i][1] += count;
                break;
            }

        }

    }


    public Product findFromStorage(int idx){

        return null;
    }

}
