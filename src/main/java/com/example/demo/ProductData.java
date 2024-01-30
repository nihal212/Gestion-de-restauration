package com.example.demo;

import java.sql.Date;

public class ProductData {
    private Integer id;
    private String  productId;
    private String productName;
    private Integer stock;
    private Double price;
    private String image ;
    private Date date;
    private String type;
    private Integer quantity;
    private String status;
    public String getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductData( String productName, Double price, String image, Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.image = image;


        this.quantity = quantity;

    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductData(Date date,Integer id,  String productId, Integer stock, Double price, String image, String productName, String status, String type){
    this.id=id;
     this.productId=productId;
     this.productName=productName;
     this.stock=stock;
     this.price =price;
     this.image=image;
     this.date=date;
     this.status = status;
        this.type=type;


    }
    public ProductData(Integer id, String productId, String productName, Double price, String image, Date date, String type, Integer qt){
        this.id=id;
        this.type=type;
        this.productId=productId;
        this.productName=productName;
        this.price =price;
        this.image=image;
        this.date=date;
        this.quantity=qt;

    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }

    public Integer getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getId() {
        return id;
    }
}
