package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="customer")
@NamedQueries(
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer c")
)
public class Customer {
    @Id
    @Column(name="cust_id", columnDefinition ="BIGINT(20)",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name="cust_adress", columnDefinition ="VARCHAR(150)")
    private String address;
    @Column(name="cust_email", columnDefinition ="VARCHAR(150)")
    private String email;
    @Column(name="cust_name", columnDefinition ="VARCHAR(150)")
    private String name;
    @Column(name="cust_phone", columnDefinition ="VARCHAR(150)")
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;
    public Customer() {
    }

    public Customer( String address, String email, String name, String phone) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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
