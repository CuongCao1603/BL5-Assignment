/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Cart {
    private int cid;
    private int pid;
    private int uid;
    private String productName;
    private String madeIn;
    private double price;
    private double totalPrice;

    public Cart() {
    }

    public Cart( int pid, int uid, String productName, String madeIn, double price, double totalPrice) {
//        this.cid = cid;
        this.pid = pid;
        this.uid = uid;
        this.productName = productName;
        this.madeIn = madeIn;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public Cart(int cid, int pid, int uid, String productName, String madeIn, double price, double totalPrice) {
        this.cid = cid;
        this.pid = pid;
        this.uid = uid;
        this.productName = productName;
        this.madeIn = madeIn;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    
}
