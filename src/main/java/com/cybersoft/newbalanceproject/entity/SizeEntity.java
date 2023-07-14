package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "size")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sizeId;
    private String sizeName;
    @OneToMany(mappedBy = "size")
    @JsonIgnore
    private Set<ProductEntity>productSize;

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Set<ProductEntity> getProductSize() {
        return productSize;
    }

    public void setProductSize(Set<ProductEntity> productSize) {
        this.productSize = productSize;
    }
}
