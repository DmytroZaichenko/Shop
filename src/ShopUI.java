import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.List;

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
        panel.setLayout(new GridBagLayout());

        JLabel lName = new JLabel("Your name:");
        JTextField tfName = new JTextField();
        tfName.setColumns(25);
        panel.add(lName, new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
        panel.add(tfName, new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));

        JLabel lProducts = new JLabel("Products: ");
        List<Product> products = shop.getActionProduct().getListOfProduct();
        ButtonGroup productsGroup = new ButtonGroup();

        JPanel pProducts = new JPanel();
        pProducts.setLayout(new GridLayout(products.size(), 0));
        pProducts.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        for (Product p : products){
            JRadioButton rb = new JRadioButton(p.toString());
            productsGroup.add(rb);
            pProducts.add(rb);
        }
        panel.add(lProducts, new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));
        panel.add(pProducts, new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,3,0,0),0,0));

        JLabel lCount = new JLabel("Count: ");
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setValue(1);

        panel.add(lCount, new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));
        panel.add(tfCount, new GridBagConstraints(1,2,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));

        JButton btnBuy = new JButton("Buy");
        panel.add(btnBuy, new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));

        return panel;
    }


}
