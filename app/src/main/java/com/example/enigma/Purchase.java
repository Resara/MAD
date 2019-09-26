package com.example.enigma;

public class Purchase {

    private int purchaseID;
    private String productName;
    private String CustomerName;
    private int quantity;
    // private int photo;
    private double price;



    public Purchase(){

    }

    public Purchase(int purchaseID, String productName, String customerName, int quantity, double price) {
        this.purchaseID = purchaseID;
        this.productName = productName;
        CustomerName = customerName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
