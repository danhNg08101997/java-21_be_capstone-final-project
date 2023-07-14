package com.cybersoft.newbalanceproject.entity.ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductCartIds implements Serializable {
    @Column(name = "product_id")
    private int productId;
    @Column(name = "cart_id")
    private int cartId;
    public ProductCartIds(){}
    public ProductCartIds(int productId, int cartId){
        this.cartId = cartId;
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
