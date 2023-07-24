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
    @Column(name = "product_desc")
    private String productDesc;
    @Column(name = "is_delete")
    private boolean isDelete;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<TransactionEntity> transactions;
    @OneToMany(mappedBy = "productOfSupport")
    @JsonIgnore
    private Set<GDVProductEntity> gdvProducts;

    public Set<GDVProductEntity> getGdvProducts() {
        return gdvProducts;
    }

    public void setGdvProducts(Set<GDVProductEntity> gdvProducts) {
        this.gdvProducts = gdvProducts;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionEntity> transactions) {
        this.transactions = transactions;
    }
}
