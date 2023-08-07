package com.cybersoft.newbalanceproject.dto.response;

public class GDVRespone {
    private int id ;
    private String gdvName;
    private String fullname;

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGdvName(String gdvName) {
        this.gdvName = gdvName;
    }

    public String getFullname() {
        return fullname;
    }

    public int getId() {
        return id;
    }

    public String getGdvName() {
        return gdvName;
    }
}
