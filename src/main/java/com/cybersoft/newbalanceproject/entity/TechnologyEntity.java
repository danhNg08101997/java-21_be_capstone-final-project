package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "technology")
public class TechnologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int techId;
    private String techName;
    @OneToMany(mappedBy = "tech")
    @JsonIgnore
    private Set<ProductEntity> productTech;

    public int getTechId() {
        return techId;
    }

    public void setTechId(int techId) {
        this.techId = techId;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public Set<ProductEntity> getProductTech() {
        return productTech;
    }

    public void setProductTech(Set<ProductEntity> productTech) {
        this.productTech = productTech;
    }
}
