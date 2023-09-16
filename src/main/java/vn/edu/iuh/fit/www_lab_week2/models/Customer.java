package vn.edu.iuh.fit.www_lab_week2.models;

public class Customer {
    private long customerId;
    private String address;
    private String email;
    private String name;
    private String phone;

    public Customer() {
    }

    public Customer(long customerId, String address, String email, String name, String phone) {
        this.customerId = customerId;
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
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
}
