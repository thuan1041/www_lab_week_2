package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="product_price")
public class ProductPrice {
    @Id
    private LocalDateTime priceDateTime;
    @Column(name = "note")
    private String note;

    @Column(name ="price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime priceDateTime, String note, double price) {
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
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
}
