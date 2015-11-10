
public class Shop {

    private Product[][] catalogProducts;
    private Product[]   products;
    private Customer[] customers;
    private Transaction[] transactions;

    private int[][] storage;


    public Product[] getProducts() {
        return products;
    }

    public Product[][] getCatalogProducts() {
        return catalogProducts;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public int[][] getStorage() {
        return storage;
    }

    public Shop() {

        int len = Category.values().length;
        catalogProducts = new Product[len][];
        fillCatalog();

        products        = new Product[100];
        storage = new int[100][2];

        initShop();

    }

    private void fillCatalog(){
        for (int i = 0; i < catalogProducts.length; i++) {
            catalogProducts[i] = new Product[100];
        }
    }

    public void initShop(){

        Product product = new Product(Category.ALCOHOL, "Jemeson", 521.26);
        addCountToShop(product, 3);

        product = new Product(Category.ALCOHOL, "William Lawson`s", 247.10);
        addCountToShop(product, 5);

        product = new Product(Category.DAIRY, "Burenka", 20.05);
        addCountToShop(product, 10);

        product = new Product(Category.DAIRY, "Kupyanskoe", 18.05);
        addCountToShop(product, 10);

    }

    public void addCountToShop(Product product, int countProduct) {

        addToCatalog(product);
        addToStorage(addToProducts(product), countProduct);

    }

    public int addToProducts(Product product){

        int idx = 0;
        for (int i = 0; i < products.length ; i++) {
            if (products[i] == null) {
                products[i] = product;
                idx = ++i;
                break;
            }
        }
        return idx;
    }

    public void addToStorage(int idxProduct, int count){

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

    public void addToCatalog(Product product){

        int position = product.getCategory().getValue();
        for (int i = 0; i < catalogProducts[position].length ; i++) {
            if (catalogProducts[position][i] == null){
                catalogProducts[position][i] = product;
            }
        }
    }

    public Product findFromStorage(int idx){

        return null;
    }

}
