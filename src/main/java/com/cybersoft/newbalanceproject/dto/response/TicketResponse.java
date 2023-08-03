package com.cybersoft.newbalanceproject.dto.response;

import java.sql.Date;

public class TicketResponse {
    private int id ;
    private String ticket_message;
    private Date create_at;
    private int gdv_id;
    private int transaction_id;
    public int getId() {
        return id;
    }

    public Date getCreate_at() {
        return create_at;
    }
    public int getGdv_id() {
        return gdv_id;
    }
    public int getTransaction_id() {
        return transaction_id;
    }
    public String getTicket_message() {
        return ticket_message;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
    public void setGdv_id(int gdv_id) {
        this.gdv_id = gdv_id;
    }
    public void setTicket_message(String ticket_message) {
        this.ticket_message = ticket_message;
    }
    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
}
