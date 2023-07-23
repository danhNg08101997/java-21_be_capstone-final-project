package com.cybersoft.newbalanceproject.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    @Column(name="status_name")
    private String statusName;
    @OneToMany(mappedBy = "status")
    private Set<TransactionEntity> transaction;

    public Set<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionEntity> transaction) {
        this.transaction = transaction;
    }
    public int getStatusId() {
        return statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
