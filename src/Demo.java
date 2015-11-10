import java.util.Arrays;


public class Demo {

    public static void main(String[] args) {

        Shop shop = new Shop();
        System.out.println("products: "+Arrays.deepToString(shop.getProducts()));
        System.out.println("storage: "+Arrays.deepToString(shop.getStorage()));

    }

}
