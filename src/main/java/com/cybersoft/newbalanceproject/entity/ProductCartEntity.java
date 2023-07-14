package com.cybersoft.newbalanceproject.entity;

import com.cybersoft.newbalanceproject.entity.ids.ProductCartIds;

import javax.persistence.*;

@Entity(name = "productCart")
public class ProductCartEntity {
    @EmbeddedId
    ProductCartIds ids;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false,updatable = false)
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "cart_id", insertable = false,updatable = false)
    private CartEntity cart;

    public ProductCartIds getIds() {
        return ids;
    }

    public void setIds(ProductCartIds ids) {
        this.ids = ids;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }
}
