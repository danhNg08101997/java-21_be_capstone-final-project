package com.cybersoft.newbalanceproject.dto.response;

public class CustomerRespone {
    private int id ;
    private String customer_name;
    private boolean is_priority;
    private String fullname;

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setIs_priority(boolean is_priority) {
        this.is_priority = is_priority;
    }

    public String getFullname() {
        return fullname;
    }

    public int getId() {
        return id;
    }

    public String getCustomer_name() {
        return customer_name;
    }
}
