package com.cybersoft.newbalanceproject.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transId;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;
    @ManyToOne
    @JoinColumn(name="gdv")
    private GDVEntity gdvtrans;
    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name="status_id")
    private StatusEntity status;
    @Column(name = "start_time")
    private Date start_time;
    @Column(name = "end_time")
    private Date end_time;
    @OneToMany(mappedBy = "transaction")
    private Set<TicketEntitty> ticket;

    public void setTicket(Set<TicketEntitty> ticket) {
        this.ticket = ticket;
    }

    public Set<TicketEntitty> getTicket() {
        return ticket;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public GDVEntity getGdvtrans() {
        return gdvtrans;
    }

    public int getTransId() {
        return transId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public void setGdvtrans(GDVEntity gdvtrans) {
        this.gdvtrans = gdvtrans;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }
}
