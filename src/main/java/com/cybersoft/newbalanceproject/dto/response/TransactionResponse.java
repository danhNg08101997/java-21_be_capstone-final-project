package com.cybersoft.newbalanceproject.dto.response;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import com.cybersoft.newbalanceproject.entity.GDVEntity;
import com.cybersoft.newbalanceproject.entity.ProductEntity;
import com.cybersoft.newbalanceproject.entity.StatusEntity;

import java.sql.Date;

public class TransactionResponse {
    private int transId;
    private CustomerEntity customer;
    private GDVEntity gdvOfTransaction;
    private ProductEntity product;
    private StatusEntity status;
    private Date startTime;
    private Date endTime;

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public void setGdvOfTransaction(GDVEntity gdvOfTransaction) {
        this.gdvOfTransaction = gdvOfTransaction;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getTransId() {
        return transId;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public GDVEntity getGdvOfTransaction() {
        return gdvOfTransaction;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getStartTime() {
        return startTime;
    }
}
