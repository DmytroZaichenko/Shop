
public class ActionProduct {

    private Product[][] catalogProducts;
    private Product[]   products;

    public ActionProduct() {

        products = new Product[100];
        catalogProducts = new Product[Category.values().length][];
        fillCatalogProducts();
        initProducts();
    }


    public Product[] getProducts() {
        return products;
    }

    public Product[][] getCatalogProducts() {
        return catalogProducts;
    }

    private void fillCatalogProducts() {
        for (int i = 0; i < catalogProducts.length; i++) {
            catalogProducts[i] = new Product[100];
        }
    }

    public void addToProducts(Product product){

        for (int i = 0; i < products.length ; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }

    }

    public void addToCatalog(Product product){

        int position = product.getCategory().getValue();
        for (int i = 0; i < catalogProducts[position].length ; i++) {
            if (catalogProducts[position][i] == null){
                catalogProducts[position][i] = product;
                break;
            }
        }
    }

    private void initProducts() {

        Product product = new Product(Category.ALCOHOL, "Jemeson", 521.26, getNewIdx());
        addToArrays(product);

        product = new Product(Category.ALCOHOL, "William Lawson`s", 247.10, getNewIdx());
        addToArrays(product);

        product = new Product(Category.DAIRY, "Burenka", 20.05, getNewIdx());
        addToArrays(product);

        product = new Product(Category.DAIRY, "Kupyanskoe", 18.05, getNewIdx());
        addToArrays(product);

        product = new Product(Category.BAKERY, "Black bread", 2.65, getNewIdx());
        addToArrays(product);

        product = new Product(Category.BAKERY, "White bread", 3.25, getNewIdx());
        addToArrays(product);

    }

    private void addToArrays(Product product) {
        addToCatalog(product);
        addToProducts(product);
    }

    public int findProductByName(String name) {
        int idx = 0;

        for (int i = 0; i < products.length; i++) {

            if (products[i] != null && products[i].getName().toUpperCase().equals(name.toUpperCase())) {
                return products[i].getId();
            }
        }

        Product product = new Product(Category.NONE,name,0, getNewIdx());
        addToArrays(product);
        return product.getId();
    }

    public int getNewIdx() {

        int idx = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null){
                idx = i;
                break;
            }
        }
        return  ++idx;
    }

    public Product findProductByIndex(int idx){
        return products[idx - 1];
    }

    public double getPriceByIdx(int idx){
        return products[idx - 1].getPrice();
    }

}
