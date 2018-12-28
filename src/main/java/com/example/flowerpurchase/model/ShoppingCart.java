package com.example.flowerpurchase.model;

import javax.persistence.*;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long uid;
    @Column(nullable = false)
    private long pid;
    @Column(nullable =  false)
    private String pname;
    @Column(nullable =  false)
    private int price;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int checked;
    @Column(nullable = false)
    private String create_time;

    public ShoppingCart(long uid, long pid, String pname, int price, int quantity, int checked, String create_time) {
        this.uid = uid;
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.checked = checked;
        this.create_time = create_time;
    }

    public ShoppingCart() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
