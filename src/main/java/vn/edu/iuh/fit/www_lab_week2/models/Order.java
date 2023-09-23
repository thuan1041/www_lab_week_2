package vn.edu.iuh.fit.www_lab_week2.models;

import java.time.LocalDateTime;

public class Order {
    private long orderId;
    private LocalDateTime orderDate;

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
