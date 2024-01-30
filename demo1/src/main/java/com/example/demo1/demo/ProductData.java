package com.example.demo;

import java.sql.Date;

public class ProductData {
    private Integer id;
    private String  productId;
    private String productName;
    private Integer stock;
    private Integer price;
    private String image ;
    private Date date;



    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductData(Integer id,String productId,String productName,Integer stock, Integer price,String image,Date date){
    this.id=id;
     this.productId=productId;
     this.productName=productName;
     this.stock=stock;
     this.price =price;
     this.image=image;
     this.date=date;

 }
    public ProductData( String productName, Integer price, String image){
        this.productName=productName;

        this.price=price;
        this.image=image;


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

    public Integer getPrice() {
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
