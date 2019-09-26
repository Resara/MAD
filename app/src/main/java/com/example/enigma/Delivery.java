package com.example.enigma;

public class Delivery {

    private String customerName;
    private String address;
    private String phone;
    private int proID;
    private String proName;
    private int quantity;
    private double price;

    public Delivery(){

    }

    public Delivery(String customerName, String address, String phone, int proID, String proName, int quantity, double price) {
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.proID = proID;
        this.proName = proName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getProID() {
        return proID;
    }

    public String getProName() {
        return proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
