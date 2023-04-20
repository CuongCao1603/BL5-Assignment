/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ProductDtls {

    private int productId;
    private String productName;
    private String madeIn;
    private String price;
    private String productCategory;
    private String status;
    private String photoName;
    private String email;

    public ProductDtls() {
    }

    public ProductDtls( String productName, String madeIn, String price, String productCategory, String status, String photoName, String email) {
//        this.productId = productId;
        this.productName = productName;
        this.madeIn = madeIn;
        this.price = price;
        this.productCategory = productCategory;
        this.status = status;
        this.photoName = photoName;
        this.email = email;
    }

    public ProductDtls(int productId, String productName, String madeIn, String price, String productCategory, String status, String photoName, String email) {
        this.productId = productId;
        this.productName = productName;
        this.madeIn = madeIn;
        this.price = price;
        this.productCategory = productCategory;
        this.status = status;
        this.photoName = photoName;
        this.email = email;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ProductDtls{" + "productId=" + productId + ", productName=" + productName + ", madeIn=" + madeIn + ", price=" + price + ", productCategory=" + productCategory + ", status=" + status + ", photoName=" + photoName + ", email=" + email + '}';
    }

    

}
