package com.cybersoft.newbalanceproject.entity.ids;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Supportids implements Serializable {
    @Column(name = "gdv_id")
    private int gdvId;
    @Column(name = "product_id")
    private int productId;

    public int getProductId() {
        return productId;
    }

    public int getGdvId() {
        return gdvId;
    }
    public void setGdvProduct(int productId,int gdvId){
        this.productId = productId;
        this.gdvId = gdvId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setGdvId(int gdvId) {
        this.gdvId = gdvId;
    }
}
