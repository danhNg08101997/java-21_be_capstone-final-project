package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "productType")
public class ProductTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productTypeId;
    private String productTypeName;
    @OneToMany(mappedBy = "productType")
    @JsonIgnore
    private Set<ProductEntity>proProductType;

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Set<ProductEntity> getProProductType() {
        return proProductType;
    }

    public void setProProductType(Set<ProductEntity> proProductType) {
        this.proProductType = proProductType;
    }
}
