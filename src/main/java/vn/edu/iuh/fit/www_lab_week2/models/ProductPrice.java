package vn.edu.iuh.fit.www_lab_week2.models;

import java.time.LocalDateTime;

public class ProductPrice {
    private LocalDateTime priceDateTime;
    private String note;
    private double price;

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
