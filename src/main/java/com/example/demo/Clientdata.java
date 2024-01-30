//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo;

import java.sql.Date;

public class Clientdata {
    private Integer id;
    private Integer customerID;
    private Integer customerIDd;
    private Double total;
    private Date date;
    private String emUsername;

    public Clientdata(Integer id, Integer customerID, Double total, Date date, String emUsername) {
        this.id = id;
        this.customerID = customerID;
        this.total = total;
        this.date = date;
        this.emUsername = emUsername;
    }


    public Integer getId() {
        return this.id;
    }

    public Integer getCustomerID() {
        return this.customerID;
    }

    public Double getTotal() {
        return this.total;
    }

    public Date getDate() {
        return this.date;
    }

    public String getEmUsername() {
        return this.emUsername;
    }
}
