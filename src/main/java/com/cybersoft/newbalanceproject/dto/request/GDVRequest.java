package com.cybersoft.newbalanceproject.dto.request;

import lombok.Getter;

public class GDVRequest extends SignUpRequest {
    private int id;
    private boolean isAvailable;
    private boolean isDelete;
@Getter
private String role;

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
