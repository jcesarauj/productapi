package com.productapi.models;

public class Product {
    private int _id;
    private String _name;

    public Product(int id, String name) {
        this._id = id;
        this._name = name;
    }

    public Product() {

    }

    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Product guest = (Product) obj;
        return _id == guest._id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_name == null) ? 0 : _name.hashCode());
        result = prime * result + _id;

        return result;
    }

}
