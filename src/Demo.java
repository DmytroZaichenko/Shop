import java.awt.SplashScreen;
public class Demo {

    public static void main(String[] args) throws Exception {

        Shop shop = new Shop();

        //ShopUI shopUI  = new ShopUI(shop);
        SplashScreen splash = SplashScreen.getSplashScreen();
        Thread.sleep(5000);
        splash.close();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShopUI(shop);
            }
        });

//        Report report = new Report(shop);
//        report.printCatalog();
//        report.printPrice();
//        report.printRemainderOnStorage();
//        report.printTransactionOnDate(shop.getDate(0));
//        report.printCountOfSalesByDay(-7);

    }

}
