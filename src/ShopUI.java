import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShopUI implements ActionListener  {

    private Shop shop;
    private String nameProduct;
    private Report report;

    public ShopUI() {

    }

    public ShopUI(Shop shop) {
        this.shop = shop;

        report = new Report(shop);

        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(800,600));
        f.setLocation(300,100);

        f.getContentPane().add(createSellingPanel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();

        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nameProduct = e.getActionCommand();
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
            rb.setActionCommand(p.getName());
            rb.addActionListener(this);
            productsGroup.add(rb);
            pProducts.add(rb);
        }
        Component c = pProducts.getComponent(0);
        if (c instanceof JRadioButton) {
            ((JRadioButton) c).setSelected(true);
            nameProduct = ((JRadioButton) c).getActionCommand();
        }

        panel.add(lProducts, new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));
        panel.add(pProducts, new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,3,0,0),0,0));

        JLabel lCount = new JLabel("Count: ");
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setValue(new Double(1));

        panel.add(lCount, new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));
        panel.add(tfCount, new GridBagConstraints(1,2,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));

        JButton btnBuy = new JButton("Buy");
        panel.add(btnBuy, new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));

        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idxCust = shop.getActionCustomer().findCustomerByName(tfName.getText());
                int idxProduct = shop.getActionProduct().findProductByName(nameProduct);
                shop.addTransaction(idxCust,idxProduct,shop.getDate(0),(Double)tfCount.getValue(),shop.getActionProduct().getPriceByIdx(idxProduct));
                report.printTransactionOnDate(shop.getDate(0));
            }
        });

        return panel;
    }


}
