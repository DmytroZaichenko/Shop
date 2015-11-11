
public class ActionCustomer {

    private Customer[] customers;

    public Customer[] getCustomers() {
        return customers;
    }

    public ActionCustomer() {
        customers = new Customer[100];
        InitCustomer();
    }

    private void InitCustomer() {

        Customer c = new Customer(getNewIdx(),"Dmytro");
        addToCustomers(c);

        c = new Customer(getNewIdx(),"Petro");
        addToCustomers(c);

    }

    public int getNewIdx() {

        int idx = 0;

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null){
                idx = i;
                break;
            }
        }

        return  ++idx;
    }

    public void addToCustomers(Customer customer){

        for (int i = 0; i < customers.length ; i++) {
            if (customers[i] == null) {
                customers[i] = customer;
                break;
            }
        }

    }
}
