
public class Product {


    private String name;
    private double price;
    private Category category;


    public Product(Category category, String name, double price ) {

        this.category = category;
        this.name = name;
        this.price = price;

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
