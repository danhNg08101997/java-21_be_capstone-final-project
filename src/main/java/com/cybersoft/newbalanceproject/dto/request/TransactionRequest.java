package com.cybersoft.newbalanceproject.dto.request;

import com.cybersoft.newbalanceproject.entity.CustomerEntity;

import java.sql.Date;

public class TransactionRequest {
    private int transId;
    private int customerId;
    private int productId;
    private int gdvId;
    private int statusId;
    private Date start_time;
    public void setGdvId(int gdvId) {
        this.gdvId = gdvId;
    }

    public int getGdvId() {
        return gdvId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;

    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }


    public int getTransId() {
        return transId;
    }

    public int getStatusId() {
        return statusId;
    }

    public Date getStart_time() {
        return start_time;
    }

    public int getCustomerId() {
        return customerId;
    }

}
