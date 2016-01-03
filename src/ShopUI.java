import javax.swing.*;
import java.awt.*;

public class ShopUI {

    private Shop shop;

    public ShopUI() {

    }

    public ShopUI(Shop shop) {
        this.shop = shop;

        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(800,600));
        f.setLocation(300,100);

        f.getContentPane().add(createSellingPanel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();

        f.setVisible(true);

    }

    private JPanel createSellingPanel(){
        JPanel panel = new JPanel();

        JLabel lName = new JLabel("Your name");
        JTextField tfName = new JTextField();
        panel.add(lName);
        panel.add(tfName);

        return panel;
    }


}
