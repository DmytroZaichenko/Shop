
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

    public void addToCustomers(Customer customer) {

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = customer;
                break;
            }
        }

    }

    public int findCustomerByName(String name){

        int idx = 0;

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getName().toUpperCase().equals(name.toUpperCase())) {
                return customers[i].getId();
            }
        }

        Customer customer = new Customer(getNewIdx(),name);
        return customer.getId();

    }

    public Customer findCustomerByIndex(int idx){
        return customers[idx - 1];
    }
}
