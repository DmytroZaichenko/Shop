
public class Product {

    private int id;
    private String name;
    private double price;
    private Category category;

    public Product(Category category, String name, double price,int id ) {

        this.category = category;
        this.name = name;
        this.price = price;
        this.id = id;
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
