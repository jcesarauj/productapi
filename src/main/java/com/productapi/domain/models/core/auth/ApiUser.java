package com.productapi.domain.models.core.auth;

import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.productapi.domain.models.core.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ApiUser extends AbstractEntity {
    @NotEmpty
    private boolean admin;

    @NotEmpty
    @Column(unique = true)
    private String userName;

    @NotEmpty
    private String name;

    @NotEmpty
    @JsonIgnore
    private String password;    

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}