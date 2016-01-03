public class Demo {

    public static void main(String[] args) {

        Shop shop = new Shop();

        ShopUI shopUI  = new ShopUI(shop);

        Report report = new Report(shop);
//        report.printCatalog();
//        report.printPrice();
//        report.printRemainderOnStorage();
        report.printTransactionOnDate(shop.getDate(0));
//        report.printCountOfSalesByDay(-7);

    }

}
