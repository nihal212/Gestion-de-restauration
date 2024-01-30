package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PlatpaimentController implements Initializable {
    @FXML
    private ImageView menuimage;

    @FXML
    private AnchorPane menuitem;

    @FXML
    private Button menuorder;

    @FXML
    private Label prod_name;

    @FXML
    private Label prod_price;
    @FXML
    private Spinner<Integer> menuspinner;
    @FXML
    private AnchorPane item;

    private String prodID;
    private Integer pr;
    private String prod_date;
    private String prod_image;

private Image image;
    private ProductData prodData;
    public void setData( ProductData prodData){
        this.prodData=prodData;

        this.prod_image = prodData.getImage();
       this.prod_date = String.valueOf(prodData.getDate());

        this.prodID = prodData.getProductId();
        this.prod_name.setText(prodData.getProductName());
        this.prod_price.setText("$" + String.valueOf(prodData.getPrice()));
        String path = "File:" + prodData.getImage();
       this.image = new Image(path, 190, 94, false, true);
        pr = prodData.getPrice();

        this.menuimage.setImage(image);


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
