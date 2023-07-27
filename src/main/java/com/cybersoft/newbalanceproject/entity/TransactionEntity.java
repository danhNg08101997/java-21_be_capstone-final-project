package com.cybersoft.newbalanceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transId;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;
    @ManyToOne
    @JoinColumn(name="gdv_id")
    private GDVEntity gdvOfTransaction;
    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name="status_id")
    private StatusEntity status;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @OneToMany(mappedBy = "transaction")
    @JsonIgnore
    private Set<TicketEntitty> tickets;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public GDVEntity getGdvOfTransaction() {
        return gdvOfTransaction;
    }

    public void setGdvOfTransaction(GDVEntity gdvOfTransaction) {
        this.gdvOfTransaction = gdvOfTransaction;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Set<TicketEntitty> getTicket() {
        return tickets;
    }

    public void setTicket(Set<TicketEntitty> ticket) {
        this.tickets = ticket;
    }

    @Column(name = "is_delete")
    private boolean isDelete;

    public boolean isDelete() {
        return isDelete;
    }
    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
