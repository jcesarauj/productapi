package com.productapi.domain.models;

import javax.persistence.Entity;
import com.productapi.domain.models.core.AbstractEntity;

@Entity
public class Product extends AbstractEntity {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setValor(double price) {
        this.price = price;
    }
}
