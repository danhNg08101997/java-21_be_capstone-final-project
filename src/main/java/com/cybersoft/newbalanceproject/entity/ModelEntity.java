package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "model")
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelId;
    @Column(name = "model_name")
    private String modelName;
    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private Set<ProductEntity>productModels;

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Set<ProductEntity> getProductModels() {
        return productModels;
    }

    public void setProductModels(Set<ProductEntity> productModels) {
        this.productModels = productModels;
    }
}
