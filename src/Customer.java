
public class Customer {

    private int id; //
    private String name;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String email;

    public Customer(int id, String name) {

        this.id = id;
        setName(name);

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
