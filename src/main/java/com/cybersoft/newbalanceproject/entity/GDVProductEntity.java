package com.cybersoft.newbalanceproject.entity;

import com.cybersoft.newbalanceproject.entity.ids.SupportIds;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "support")
public class GDVProductEntity {
    @EmbeddedId
    private SupportIds ids;
    @ManyToOne
    @JoinColumn (name="gdv_id", insertable = false, updatable = false)
    private GDVEntity gdvOfSupport;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity productOfSupport;

    public SupportIds getIds() {
        return ids;
    }

    public void setIds(SupportIds ids) {
        this.ids = ids;
    }

    public GDVEntity getGdvOfSupport() {
        return gdvOfSupport;
    }

    public void setGdvOfSupport(GDVEntity gdvOfSupport) {
        this.gdvOfSupport = gdvOfSupport;
    }

    public ProductEntity getProductOfSupport() {
        return productOfSupport;
    }

    public void setProductOfSupport(ProductEntity productOfSupport) {
        this.productOfSupport = productOfSupport;
    }
}
