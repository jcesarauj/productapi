package com.productapi.domain.models;

import javax.persistence.Entity;

import com.productapi.domain.models.core.AbstractEntity;

@Entity
public class Product extends AbstractEntity {
    private String name;
    private double valor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
