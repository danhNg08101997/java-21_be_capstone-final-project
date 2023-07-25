package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name="gdv")
public class GDVEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gdv_id")
    private int gdvId;
    @Column(name = "gdv_name")
    private String username;
    @Column(name = "gdv_password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "is_available")
    private boolean isAvailable;
    @Column(name = "is_delete")
    private boolean isDelete;
    @OneToMany(mappedBy = "gdvOfTransaction")
    @JsonIgnore
    private Set<TransactionEntity> transactions;
    @OneToMany(mappedBy = "gdvOfTicket")
    @JsonIgnore
    private Set<TicketEntitty> tickets;
    @OneToMany(mappedBy = "gdvOfSupport")
    @JsonIgnore
    private Set<GDVProductEntity> gdvProducts;

    public int getGdvId() {
        return gdvId;
    }
    public void setGdvId(int gdvId) {
        this.gdvId = gdvId;
    }

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<TicketEntitty> getTickets() {
        return tickets;
    }

    public void setTickets(Set<TicketEntitty> tickets) {
        this.tickets = tickets;
    }

    public Set<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    public Set<GDVProductEntity> getGdvProducts() {
        return gdvProducts;
    }

    public void setGdvProducts(Set<GDVProductEntity> gdvProducts) {
        this.gdvProducts = gdvProducts;
    }
}
