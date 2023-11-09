package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week2.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private long productId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name ="unit")
    private String unit;
    @Column(name = "manufacturer")
    private String manufacturerName;
    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "status")
    @Column(nullable = false)
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetailList;

    @OneToMany
    private List<ProductImage> productImageList;
    @OneToMany(mappedBy = "product")
    private  List<ProductPrice> productPrices;
    public Product() {
    }

    public Product(long productId, String name, String description, String unit, String manufacturerName, ProductStatus status) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
