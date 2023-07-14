package com.cybersoft.newbalanceproject.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "gender")
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genderId;
    @Column(name = "gender_name")
    private String genderName;
    @OneToMany(mappedBy = "gender")
    private Set<ProductEntity>productGenders;

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public Set<ProductEntity> getProductGenders() {
        return productGenders;
    }

    public void setProductGenders(Set<ProductEntity> productGenders) {
        this.productGenders = productGenders;
    }
}
