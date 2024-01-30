package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class commentairecontrolleur {
    private  Integer id;
    private String comment;
    @FXML
    private AnchorPane commnetzone;

    @FXML
    private Label idcommnet;
    private comment com;
    public void setComment(comment com){
        this.com=com;
        this.idcommnet.setText(com.getComment());
    }


}


