package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "fit")
public class FitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fitId;
    @Column(name = "fit_name")
    private String fitName;
    @OneToMany(mappedBy = "fit")
    @JsonIgnore
    private Set<ProductEntity>productFits;

    public int getFitId() {
        return fitId;
    }

    public void setFitId(int fitId) {
        this.fitId = fitId;
    }

    public String getFitName() {
        return fitName;
    }

    public void setFitName(String fitName) {
        this.fitName = fitName;
    }

    public Set<ProductEntity> getProductFits() {
        return productFits;
    }

    public void setProductFits(Set<ProductEntity> productFits) {
        this.productFits = productFits;
    }
}
