package com.cybersoft.newbalanceproject.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SignUpRequest {

    private String fullname;
    @NotNull(message = "username not null")
    @NotEmpty(message = "username not empty")
    private String username;
    @NotNull(message = "password not null")
    @NotEmpty(message = "password not empty")
    private String password;
    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
