package com.cybersoft.newbalanceproject.entity;

import javax.persistence.*;

@Entity(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    @Column(name = "admin_name")
    private String name;
    @Column(name = "admin_password")
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
