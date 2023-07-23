package com.cybersoft.newbalanceproject.entity;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.util.Set;

@Entity(name="customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_password")
    private String customerPassword;
    @Column(name = "is_priority")
    private boolean Priority;
    @OneToMany(mappedBy = "customer")
    private Set<TransactionEntity> transaction ;

    public void setTransaction(Set<TransactionEntity> transaction) {
        this.transaction = transaction;
    }

    public Set<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public void setPriority(boolean priority) {
        Priority = priority;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }
}
