package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    @Column(name = "date")
    private Date date;
    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private Set<ProductCartEntity> productCarts;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<ProductCartEntity> getProductCarts() {
        return productCarts;
    }

    public void setProductCarts(Set<ProductCartEntity> productCarts) {
        this.productCarts = productCarts;
    }
}
