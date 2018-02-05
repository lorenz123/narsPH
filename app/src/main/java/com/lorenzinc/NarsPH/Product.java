package com.lorenzinc.NarsPH;

/**
 * Created by One on 2/4/2018.
 */

public class Product {
    private String name;
    private int qty;
    private double price;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
