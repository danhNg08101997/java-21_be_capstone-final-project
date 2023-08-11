package com.cybersoft.newbalanceproject.dto.request;

import lombok.Getter;

public class GDVRequest extends SignUpRequest {
    @Getter
    private int gdvId;
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

    public void setGdvId(int gdvId) {
        this.gdvId = gdvId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
