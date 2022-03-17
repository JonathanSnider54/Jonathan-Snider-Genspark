package com.example.restfulAPIExemple.entity;

import javax.persistence.*;

@Entity
@Table
public class Furniture {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private float price;
    private String name;
    private String brand;

    public Furniture(int id, float price, String name, String brand) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public Furniture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
