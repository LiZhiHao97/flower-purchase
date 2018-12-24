package com.example.flowerpurchase.Model;

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
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int checked;
    @Column(nullable = false)
    private int create_time;

    public ShoppingCart(long uid, long pid, int quantity, int checked, int create_time) {
        this.uid = uid;
        this.pid = pid;
        this.quantity = quantity;
        this.checked = checked;
        this.create_time = create_time;
    }

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

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }
}
