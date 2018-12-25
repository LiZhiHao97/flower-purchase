package com.example.flowerpurchase.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String img;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int status;
    @Column(nullable = false)
    private String create_time;

    public Product(String name, String description, String img, int price, int status, String create_time) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
        this.status = status;
        this.create_time = create_time;
    }

    public Product() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCraete_time() {
        return create_time;
    }

    public void setCraete_time(String create_time) {
        this.create_time = create_time;
    }

}
