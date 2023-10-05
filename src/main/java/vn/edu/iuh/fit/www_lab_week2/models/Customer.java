package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="cust_id", columnDefinition ="BIGINT(20)",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    @Column(name="cust_adress", columnDefinition ="VARCHAR(150)")
    private String address;
    @Column(name="cust_email", columnDefinition ="VARCHAR(150)")
    private String email;
    @Column(name="cust_name", columnDefinition ="VARCHAR(150)")
    private String name;
    @Column(name="cust_phone", columnDefinition ="VARCHAR(150)")
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
