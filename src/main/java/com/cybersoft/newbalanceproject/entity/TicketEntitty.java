package com.cybersoft.newbalanceproject.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "ticket")
public class TicketEntitty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private TransactionEntity transaction;
    @ManyToOne
    @JoinColumn(name = "gdv_id")
    private GDVEntity gdv;
    @Column(name = "ticket_message")
    private String message;
    @Column(name = "create_at")
    private Date create;

    public GDVEntity getGdv() {
        return gdv;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreate() {
        return create;
    }

    public int getTicketId() {
        return ticketId;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public void setGdv(GDVEntity gdv) {
        this.gdv = gdv;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setCreate(Date create) {
        this.create = create;

    }
}
