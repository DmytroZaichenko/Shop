
public class Report {

    private Shop shop;

    public Report(Shop shop) {
        setShop(shop);
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void printCatalog(){

        Product[][] catalogProduct = shop.getActionProduct().getCatalogProducts();

        System.out.println("Products by Category");

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


}
