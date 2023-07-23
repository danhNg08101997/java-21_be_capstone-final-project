package com.cybersoft.newbalanceproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_des")
    private String productDesc;
    @Column(name = "price")
    private double price;
    @Column(name = "total_quantity")
    private int quantity;
    @Column(name = "listImage")
    private String listImage;
    @OneToMany(mappedBy = "product")
    private Set<TransactionEntity> transaction;

    public Set<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionEntity> transaction) {
        this.transaction = transaction;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public void setListImage(String listImage) {
        this.listImage = listImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getListImage() {
        return listImage;
    }

    public String getProductDesc() {
        return productDesc;
    }
}
