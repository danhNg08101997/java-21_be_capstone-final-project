package com.cybersoft.newbalanceproject.dto.request;

import lombok.Getter;

public class CustomerRequest extends SignUpRequest{
    private int id;
    private boolean priority;
    private boolean isDelete;
    @Getter
    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
