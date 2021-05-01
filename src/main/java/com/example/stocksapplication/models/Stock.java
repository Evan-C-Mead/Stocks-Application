package com.example.stocksapplication.models;

public class Stock {
//  Checking API for data

    private long id;

    public Stock() {

    }

    public Stock(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
