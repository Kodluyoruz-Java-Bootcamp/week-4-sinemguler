package com.emlakcepteservice.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "product_name" , nullable = false)
    private String productName;
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    public Product() {
    }

    public Product(int id,String productName, int quantity) {
        this.id = id;
        this.productName=productName;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
