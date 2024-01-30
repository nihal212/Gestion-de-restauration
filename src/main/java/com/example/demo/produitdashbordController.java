package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class produitdashbordController {
    @FXML
    private ImageView impd;

    @FXML
    private Label pnd;

    @FXML
    private Label ppd;
    private ProductData prodData;
    private String prod_image;
    private Image image;



    public void setdatadas(ProductData prodData){
        this.prodData=prodData;
        this.prod_image = prodData.getImage();
        this.ppd.setText(String.valueOf(prodData.getPrice())+" MAD" );
        String path = "File:" + prodData.getImage();
        this.image = new Image(path, 197, 120, false, true);
        this.impd.setImage(image);
        this.pnd.setText(prodData.getProductName());

    }
}
