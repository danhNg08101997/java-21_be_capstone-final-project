package com.cybersoft.newbalanceproject.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="gdv")
public class GDVEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gdvId;
    @Column(name = "gdv_name")
    private String gdvName;
    @Column(name = "gdv_password")
    private String gdvPassword;
    @Column(name = "is_available")
    private boolean is_available;
    @OneToMany(mappedBy = "gdvtrans")
    private Set<TransactionEntity> transaction;
    @OneToMany(mappedBy = "gdv")
    private Set<TicketEntitty> ticket;

    public Set<TicketEntitty> getTicket() {
        return ticket;
    }
    public void getTicket(Set<TicketEntitty> ticket) {
        this.ticket = ticket;
    }

    public Set<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionEntity> transaction) {
        this.transaction = transaction;
    }

    public int getGdvId() {
        return gdvId;
    }

    public String getGdvName() {
        return gdvName;
    }

    public String getGdvPassword() {
        return gdvPassword;
    }

    public void setGdvId(int gdvId) {
        this.gdvId = gdvId;
    }

    public void setGdvName(String gdvName) {
        this.gdvName = gdvName;
    }

    public void setGdvPassword(String gdvPassword) {
        this.gdvPassword = gdvPassword;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }
}
