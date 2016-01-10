import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopUI {

    private Shop shop;
    private String nameProduct;
    private Report report;
    private JPanel pTable;

    public ShopUI() {

    }

    public ShopUI(Shop shop) {
        this.shop = shop;

        report = new Report(shop);

        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(800,600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.setLocation(300,100);

        TableDemo newContentPane = new TableDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        f.setContentPane(newContentPane);


        //Create and set up the content pane.
//        JPanel newContentPane = createTablePanel();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        f.setContentPane(newContentPane);

        //f.getContentPane().add(createSellingPanel());


        f.pack();

        f.setVisible(true);

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        nameProduct = e.getActionCommand();
//    }

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
            //rb.addActionListener(this);
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
        tfCount.setValue(new Double(1.0));
        tfCount.setColumns(15);

        panel.add(lCount, new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));
        panel.add(tfCount, new GridBagConstraints(1,2,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));

        JButton btnBuy = new JButton("Buy");
        panel.add(btnBuy, new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));

        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idxCust = shop.getActionCustomer().findCustomerByName(tfName.getText());
                int idxProduct = shop.getActionProduct().findProductByName(nameProduct);
                double count = Double.parseDouble(tfCount.getText());
                shop.addTransaction(idxCust,idxProduct,shop.getDate(0),count,shop.getActionProduct().getPriceByIdx(idxProduct));
                report.printTransactionOnDate(shop.getDate(0));
            }
        });

        return panel;
    }

    private class TableDemo extends JPanel{

        public TableDemo(){

            super(new GridLayout(1,0));

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
            ActionProduct ap = shop.getActionProduct();
            ActionCustomer ac = shop.getActionCustomer();

            int nom = 0;
            String[] columnNames = {"id", "date","Product","Count","Customer"};

            List<Transaction> lt = new ArrayList<>();
            Transaction[] transactions = shop.getTransactions();
            for (int i = 0; i < transactions.length ; i++) {
                Transaction tran = transactions[i];
                if (tran == null) {
                    break;
                }
                lt.add(tran);
            }

            Object[][] data = new Object[lt.size()][];

            for (int i = 0; i < lt.size(); i ++) {
                Transaction tr = lt.get(i);
                Product product = ap.findProductByIndex(tr.getIdProduct());
                Customer customer = ac.findCustomerByIndex(tr.getIdCustomer());
                ++nom;

                Object[] co =     new Object[]{nom,
                                            sdf.format(tr.getDate()),
                                            product.getName(),
                                            tr.getCount(),
                                            customer.getName()
                                            };
                data[i] = co;

            }

            final JTable table = new JTable(data, columnNames);
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
            table.setFillsViewportHeight(true);

            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane);

        }

    }


}
