package com.cybersoft.newbalanceproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_desc")
    private String productDesc;

    public void setPath(String path) {
        this.path = path;
    }

    @Getter
    @Column(name="link_path")
    private String path;
    @Column(name = "icon")
    private String icon;

    public String getPath() {
        return path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<TransactionEntity> transactions;
    @OneToMany(mappedBy = "productOfSupport")
    @JsonIgnore
    private Set<GDVProductEntity> gdvProducts;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

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

    public Set<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    @Column(name = "is_delete")
    private boolean isDelete;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
