package com.productapi.domain.models;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.damianwajser.validator.annotation.NotEmpty;
import com.productapi.domain.models.core.AbstractEntity;

@Entity
public class User extends AbstractEntity {

    @NotEmpty
    @ColumnResult(unique = true)
    private String userName;
    @NotEmpty
    @JsonIgnore
    private String password;
    @NotEmpty
    private String name;

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
}