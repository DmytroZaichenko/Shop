
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.getDateInstance;

public class Shop {

    private ActionProduct actionProduct;
    private Report report;
    private Customer[] customers;
    private Transaction[] transactions;

    private int[][] storage;

    public Customer[] getCustomers() {
        return customers;
    }

    public int[][] getStorage() {
        return storage;
    }

    public ActionProduct getActionProduct() {
        return actionProduct;
    }

    public Shop() {

        actionProduct = new ActionProduct();
        report = new Report(this);
        report.printCatalog();
        report.printPrice();

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

        initShop();


    }


    public void initShop(){

         //addCountToStorage(actionProduct.findProductByName("Jemeson"), 3);

//        addCountToShop(product, 5);
//        addCountToShop(product, 10);
//        addCountToShop(product, 10);
//
//        customers[0] = new Customer(1,"Demo1");
//        customers[1] = new Customer(2,"Demo2");
//        customers[2] = new Customer(3,"Demo3");
//
//        transactions[0] = new Transaction();

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
