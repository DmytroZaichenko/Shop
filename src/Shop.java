
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.text.DateFormat.getDateInstance;

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

        report = new Report(this);
        //report.printCatalog();
        //report.printPrice();
        //report.printRemainderOnStorage();
        report.printTransactionOnDate(getDate(-7));

//        Date currentDate = new Date();
//        System.out.println("Date currentDate = " + currentDate);
//        currentDate = new Date();
//        Long time = currentDate.getTime();
//        long anotherDate = -1;
//        time += (60*60*24*1000*anotherDate);
//        currentDate = new Date(time);
//        System.out.println("Date currentDate = "+currentDate);
//
//        Locale local = new Locale("uk","UK");
//        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT,local);
//        currentDate = new Date();
//        System.out.println("currentDateTime = "+df.format(currentDate));
//
//        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY");
//        currentDate = new Date();
//        System.out.println("currentDateTime = "+sdf.format(currentDate));




    }



    public void initShop(){

        addCountToStorage(actionProduct.findProductByName("Jemeson"), 3);
        addCountToStorage(actionProduct.findProductByName("Red Label"), 5);
        addCountToStorage(actionProduct.findProductByName("Burenka"), 10);
        addCountToStorage(actionProduct.findProductByName("Kupyanskoe"), 21);

        int idxCustomer = actionCustomer.findCustomerByName("Perto");
        int idxProduct = actionProduct.findProductByName("Burenka");
        addTransaction(idxCustomer, idxProduct, getDate(-7), 1 , actionProduct.getPriceByIdx(idxProduct));

        idxProduct = actionProduct.findProductByName("white bread");
        addTransaction(idxCustomer, idxProduct, getDate(-7), 1 , actionProduct.getPriceByIdx(idxProduct));

        idxCustomer = actionCustomer.findCustomerByName("Dmytro");
        addTransaction(idxCustomer, idxProduct, getDate(-6), 2 , actionProduct.getPriceByIdx(idxProduct));
        idxProduct = actionProduct.findProductByName("burenka");
        addTransaction(idxCustomer, idxProduct, getDate(-6), 2 , actionProduct.getPriceByIdx(idxProduct));



    }

    private Date getDate(int countOfDate){
        Calendar date = new GregorianCalendar();
        date.add(Calendar.DAY_OF_YEAR,countOfDate);
        return date.getTime();
    }

    private void addTransaction(int idCustomer, int idProduct, Date date, double count, double price ){

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
