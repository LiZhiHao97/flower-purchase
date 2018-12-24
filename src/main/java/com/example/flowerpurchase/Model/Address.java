package com.example.flowerpurchase.Model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long uid;
    @Column(nullable = false)
    private String receiver_name;
    @Column(nullable = false)
    private String receiver_phone;
    @Column(nullable = false)
    private String receiver_province;
    @Column(nullable = false)
    private String receiver_city;
    @Column(nullable = false)
    private String receiver_district;
    @Column(nullable = false)
    private String receiver_address;
    @Column(nullable = false)
    private String receiver_zip;

    public Address(long uid, String receiver_name, String receiver_phone, String receiver_province, String receiver_city, String receiver_district, String receiver_address, String receiver_zip) {
        this.uid = uid;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.receiver_province = receiver_province;
        this.receiver_city = receiver_city;
        this.receiver_district = receiver_district;
        this.receiver_address = receiver_address;
        this.receiver_zip = receiver_zip;
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

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getReceiver_province() {
        return receiver_province;
    }

    public void setReceiver_province(String receiver_province) {
        this.receiver_province = receiver_province;
    }

    public String getReceiver_city() {
        return receiver_city;
    }

    public void setReceiver_city(String receiver_city) {
        this.receiver_city = receiver_city;
    }

    public String getReceiver_district() {
        return receiver_district;
    }

    public void setReceiver_district(String receiver_district) {
        this.receiver_district = receiver_district;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public String getReceiver_zip() {
        return receiver_zip;
    }

    public void setReceiver_zip(String receiver_zip) {
        this.receiver_zip = receiver_zip;
    }
}
