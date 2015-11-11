public class Demo {

    public static void main(String[] args) {

        Shop shop = new Shop();

        Report report = new Report(shop);
        report.printCatalog();
        report.printPrice();
        report.printRemainderOnStorage();
        report.printTransactionOnDate(shop.getDate(-6));
        report.printCountOfSalesByDay(-7);

    }

}
