package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "width")
public class WidthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int widthId;
    private String widthName;
    @OneToMany(mappedBy = "width")
    @JsonIgnore
    private Set<ProductEntity> productWidth;

    public int getWidthId() {
        return widthId;
    }

    public void setWidthId(int widthId) {
        this.widthId = widthId;
    }

    public String getWidthName() {
        return widthName;
    }

    public void setWidthName(String widthName) {
        this.widthName = widthName;
    }

    public Set<ProductEntity> getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(Set<ProductEntity> productWidth) {
        this.productWidth = productWidth;
    }
}
