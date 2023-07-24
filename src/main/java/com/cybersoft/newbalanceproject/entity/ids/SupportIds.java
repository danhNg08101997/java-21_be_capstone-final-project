package com.cybersoft.newbalanceproject.entity.ids;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SupportIds implements Serializable {
    @Column(name = "gdv_id")
    private int gdvId;
    @Column(name = "product_id")
    private int productId;

    public SupportIds(){};
    public SupportIds(int gdvId, int productId) {
        this.gdvId = gdvId;
        this.productId = productId;
    }

    public int getGdvId() {
        return gdvId;
    }

    public void setGdvId(int gdvId) {
        this.gdvId = gdvId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
