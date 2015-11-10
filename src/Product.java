
public class Product {

    private int id;
    private String name;
    private double price;
    private Category category;

    protected ActionProduct actionProduct;


    public Product(Category category, String name, double price ) {

        this.category = category;
        this.name = name;
        this.price = price;
        this.id = getIdxFromProducts();

    }

    private int getIdxFromProducts() {

        int idx = 0;
        Product[] products = actionProduct.getProducts();

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null){
                idx = i;
                break;
            }
        }

        return  idx;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
