package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;

import javax.xml.namespace.QName;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Column(name = "note")
    private String note;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private double quantity;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(String note, double price, double quantity, Order order, Product product) {
        this.note = note;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "note='" + note + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
