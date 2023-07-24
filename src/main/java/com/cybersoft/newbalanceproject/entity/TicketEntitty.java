package com.cybersoft.newbalanceproject.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "ticket")
public class TicketEntitty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    @Column(name = "ticket_message")
    private String message;
    @Column(name = "create_at")
    private Date create;
    @Column(name = "is_delete")
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private TransactionEntity transaction;
    @ManyToOne
    @JoinColumn(name = "gdv_id")
    private GDVEntity gdvOfTicket;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public GDVEntity getGdvOfTicket() {
        return gdvOfTicket;
    }

    public void setGdvOfTicket(GDVEntity gdvOfTicket) {
        this.gdvOfTicket = gdvOfTicket;
    }
}
