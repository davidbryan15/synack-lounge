package com.aviles.entity;

import javax.persistence.*;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "product_img_url")
    private String productImgUrl;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_price")
    private double productPrice;

    public Product(){

    }

    public Product(String productName, String productImgUrl, int productQuantity, double productPrice) {
        this.productName = productName;
        this.productImgUrl = productImgUrl;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
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

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImgUrl='" + productImgUrl + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }
}
