package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "color")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int colorId;
    private String colorName;
    @OneToMany(mappedBy = "color")
    @JsonIgnore
    private Set<ProductEntity>productColors;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
    public Set<ProductEntity> getProductColors() {
        return productColors;
    }

    public void setProductColors(Set<ProductEntity> productColors) {
        this.productColors = productColors;
    }
}
