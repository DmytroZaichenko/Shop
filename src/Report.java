import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

public class Report {

    public final DateFormat dateFormatReport = DateFormat.getDateInstance(DateFormat.DEFAULT);

    private Shop shop;

    public Report(Shop shop) {
        setShop(shop);
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void printCatalog(){

        Product[][] catalogProduct = shop.getActionProduct().getCatalogProducts();

        System.out.println("PRODUCTS BY CATEGORY");

        for (int i = 0; i < catalogProduct.length ; i++) {

            System.out.println(Category.values()[i]);
            for (int j = 0; j < catalogProduct[i].length; j++) {
                if (catalogProduct[i][j] != null){
                    System.out.print("   |_");
                    Product p = catalogProduct[i][j];
                    System.out.println(  " name: "+p.getName()+
                                         "; price: "+p.getPrice()+" UAH");
                }
            }

        }
        System.out.println("");

    }

    public void printPrice(){

        Product[] products = shop.getActionProduct().getProducts();
        System.out.println("PRICE");
        for (int i = 0; i < products.length ; i++) {
            Product p = products[i];
            if (p != null) {
                System.out.println(p.getId() +". "+ p.getName()+" - "+p.getPrice()+" UAH");
            }
        }
    }

    public void printRemainderOnStorage(){

        int[][] storage = shop.getStorage();
        ActionProduct ap = shop.getActionProduct();

        System.out.println("");
        System.out.println("REMAINDER ON THE STORAGE");

        int idNum = 0;

        for (int i = 0; i < storage.length ; i++) {

            if (storage[i][0] != 0){
                Product p = ap.findProductByIndex(storage[i][0]);
                System.out.println(++idNum +". "+ p.getName()+" - "+p.getPrice()+" UAH"+
                                   " count: "+storage[i][1]);

            }

        }
    }

    public void printTransactionOnDate(Date date){

        System.out.println("TRANSACTION ON " + dateFormatReport.format(date));

        Transaction[] transactions = shop.getTransactions();
        ActionProduct ap = shop.getActionProduct();
        ActionCustomer ac = shop.getActionCustomer();

        boolean isBuy = false;
        int nom = 0;
        double count = 0;
        double sum = 0;

        for (int i = 0; i < transactions.length; i++) {

            Transaction tran = transactions[i];

            if (tran != null && tran.getDate().equals(date)){

                Product product   = ap.findProductByIndex(tran.getIdProduct());
                Customer customer = ac.findCustomerByIndex(tran.getIdCustomer());

                ++nom;
                count += tran.getCount();
                sum += tran.getPrice() * tran.getCount();

                System.out.println(
                                         nom+". customer: " + customer.getName()
                                         + " product name: " + product.getName()
                                         + " price: " + tran.getPrice()
                                         + " count: " + tran.getCount()
                );
            }

        }

        System.out.println("========================================");
        System.out.println("In total: "+ nom + " of sales, count: "+ count + " sum: "+sum);

    }

    public void printCountOfSalesByDay(int countOfDay) {

        if (countOfDay > 0){
            System.out.println("It had no future sales.");
            return;
        }

        Date fDate = shop.getDate(countOfDay);

        System.out.println("SHOW SALES WITH " + dateFormatReport.format(fDate));

        double countByDay = 0;
        Transaction[] transactions = shop.getTransactions();

        while ( countOfDay != 1){

            countByDay = 0;
            for (int i = 0; i < transactions.length; i++) {

                Transaction tran = transactions[i];
                if (tran == null){break;};

                if (tran.getDate().equals(fDate)){
                    countByDay += tran.getCount();
                }
            }

            System.out.println("date: "+dateFormatReport.format(fDate)+", number of sales: "+countByDay);
            countOfDay = countOfDay + 1;
            fDate = shop.getDate(countOfDay);

        }



    }

}
