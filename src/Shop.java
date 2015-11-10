
public class Shop {

    private ActionProduct actionProduct;
    private Customer[] customers;
    private Transaction[] transactions;

    private int[][] storage;

    public Customer[] getCustomers() {
        return customers;
    }

    public int[][] getStorage() {
        return storage;
    }

    public Shop() {

       actionProduct = new ActionProduct();
       initShop();


    }


    public void initShop(){

         addCountToStorage(actionProduct.findProductByName("Jemeson"), 3);

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
