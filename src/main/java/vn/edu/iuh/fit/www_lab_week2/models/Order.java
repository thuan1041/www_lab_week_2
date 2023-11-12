package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name="cust_id")
    private Customer customer;
    @JsonbTransient
    @OneToMany()
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Order() {
    }

    public Order(long orderId, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
