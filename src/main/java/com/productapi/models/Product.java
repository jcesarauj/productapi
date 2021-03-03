package com.productapi.models;

public class Product {
    private int Id;
    private String Name;

    public Product(int id, String name) {
        this.Id = id;
        this.Name = name;
    }

    public Product() {
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
