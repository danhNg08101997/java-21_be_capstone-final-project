package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.util.Set;

@Entity(name="customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String username;
    @Column(name = "customer_password")
    private String password;
    @Column(name = "is_priority")
    private boolean priority;
//    @Column(name = "is_delete")
//    private boolean isDelete;
    @Column(name = "fullname")
    private String fullname;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<TransactionEntity> transactions ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

//    public boolean isDelete() {
//        return isDelete;
//    }
//
//    public void setDelete(boolean delete) {
//        isDelete = delete;
//    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getCustomerId() {return customerId;}

    public Set<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionEntity> transactions) {
        this.transactions = transactions;
    }
}
