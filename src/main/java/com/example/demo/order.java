package com.example.demo;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class order {
    private int orderId;
    private int customerId;
    private String produitname;
    private String produitId;
    private int quantity;
    private double price;
    private String dateOrder;
    private String typeProduit;
private boolean confirmationStatus;  // true if confirmed, false otherwise
    private Color circleColor;  // store the color of the circle
private String numtable;

    //        setters
 public void setNumtable(String numtable) {
        this.numtable = numtable;
    }

    public void setOrderId(int id){
        this.orderId=id;
    }
    public void setCustomerId(int custId){
        this.customerId=custId;
    }
    public void setProduitname(String prodname){
        this.produitname=prodname;
    }
    public void setProduitId(String prodid){
        this.produitId=prodid;
    }
    public void setQuantity(int qtt){
        this.quantity=qtt;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setDateOrder(String dateOr){
        this.dateOrder=dateOr;
    }
    public void setTypeProduit(String typepro){
        this.typeProduit=typepro;
    }
    //        getters
    public int getOrderId(){ return orderId;}
    public int getCustomerId(){
        return customerId;
    }
    public String getProduitname(){return produitname;
    }
    public String getProduitId(){
        return produitId;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public String getDateOrder(){
        return dateOrder;
    }
    public String getTypeProduit(){
        return typeProduit;
    }
 public boolean getConfirmationStatus() {
        return confirmationStatus;
    }
   public String getnumtable() {
        return this.numtable;
    }

    public void setConfirmationStatus(boolean confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }

    public Color getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(Color circleColor) {
        this.circleColor = circleColor;
    }


}

