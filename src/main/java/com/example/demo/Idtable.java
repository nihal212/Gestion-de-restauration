package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class Idtable implements Initializable {
    @FXML
    private  Label idtable;

    @FXML
    private  CheckBox choisetble;

    private Table table;
    private String tableid;
    private Table tab;
    @FXML
    private Label nbr;


    public void setdata(Table tab){
        this.tab=tab;
        this.idtable.setText("TABLE"+" "+tab.getNumtab());
        this.nbr.setText("CAPACITY IS :"+" "+String.valueOf(tab.getNbreplace()));
    }
    public static String selectedTableId;
    public  void selectchoice() {

       if (choisetble.isSelected()){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information Message");
           alert.setHeaderText(null);
           alert.setContentText("Successfully choise!");
           alert.showAndWait();
        selectedTableId = String.valueOf(tab.getNumtab());
           System.out.println("Selected Table ID: " + selectedTableId);  // Ajoutez cette ligne pour le débogage





       }else {
           selectedTableId=null;
       }

   }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
