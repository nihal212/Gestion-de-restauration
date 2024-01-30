package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;


//import  com.example.demo.Tableview.menuDisplaytable;

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
    private Double pr;
    private String prod_date;
    private String prod_image;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Alert alert;
    private String type;
    private Image image;

    public String getType() {
        return type;
    }

    private ProductData prodData;
    private SpinnerValueFactory<Integer> spin;


    public void setData( ProductData prodData){
        this.prodData=prodData;
        this.type = prodData.getType();
        this.prod_image = prodData.getImage();
       this.prod_date = String.valueOf(prodData.getDate());

        this.prodID = prodData.getProductId();
        this.prod_name.setText(prodData.getProductName());
        this.prod_price.setText(String.valueOf(prodData.getPrice())+" MAD" );
        String path = "File:" + prodData.getImage();
       this.image = new Image(path, 296, 174, false, true);
        pr = prodData.getPrice();

        this.menuimage.setImage(image);


    }
   /* public void setdatadas(ProductData prodData){
        this.prodData=prodData;
        this.prod_image = prodData.getImage();
        this.ppd.setText(String.valueOf(prodData.getPrice())+" MAD" );
        String path = "File:" + prodData.getImage();
        this.image = new Image(path, 178, 134, false, true);
        this.impd.setImage(image);
        this.pnd.setText(prodData.getProductName());

    }*/
//    public void choiseOrder(ActionEvent event) throws SQLException, IOException {
//        if (checkbook.isSelected()) {
//            System.out.println("le plat pour une table");
//            alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("choise");
//            alert.setHeaderText(null);
//            alert.setContentText("are you sure for a book");
//            Optional<ButtonType> option = alert.showAndWait();
//
//            if (option.get().equals(ButtonType.OK)) {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//
//                // Assurez-vous que le chemin du fichier FXML est correct
//                URL location = getClass().getResource("tableview.fxml");
//                if (location == null) {
//                    System.err.println("Could not find FXML file: tableview.fxml");
//                    return;
//                }
//                fxmlLoader.setLocation(location);
//
//                try {
//                    Parent root = fxmlLoader.load();
//                    Stage stage = new Stage();
//                   Scene scene = new Scene(root);
//                    stage.setWidth(355);
//                    stage.setHeight(500);
//
//                    stage.setTitle("TableView");
//                    stage.setScene(scene);
//                    stage.show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public void setQuatity(){
        spin =new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        menuspinner.setValueFactory(spin);
        }


    private int qty;



    private double totalP;


    public void addBtn() throws IOException {

        HelloController mForm = new HelloController();
        mForm.customerID();

        qty = menuspinner.getValue();
        String check = "";
        String checkAvailable = "SELECT status FROM product WHERE prod_id = '"
                + prodID + "'";

        connect = DDBSE.connectDB();

        try {
            int checkStck = 0;
            String checkStock = "SELECT stock FROM product WHERE prod_id = '"
                    + prodID + "'";

            prepare = connect.prepareStatement(checkStock);
            result = prepare.executeQuery();

            if (result.next()) {
                checkStck = result.getInt("stock");
            }

            if(checkStck == 0){


                String updateStock = "UPDATE product SET prod_name = '"
                        + prod_name.getText() + "', type = '"
                        + type+ "', stock = 0, price = " + pr
                        + ", status = 'Unavailable', image = '"
                        + prod_image + "', date = '"
                        + prod_date + "' WHERE prod_id = '"
                        + prodID + "'";
                prepare = connect.prepareStatement(updateStock);
                prepare.executeUpdate();


            }

            prepare = connect.prepareStatement(checkAvailable);
            result = prepare.executeQuery();

            if (result.next()) {
                check = result.getString("status");
            }if(Idtable.selectedTableId==null && HelloController.mts==null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("you should choice how you want to order");
                alert.showAndWait();
            }

            if (!check.equals("Available") || qty == 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("the quantity is null");
                alert.showAndWait();
            } else{ //if(checkbook.isSelected() ){

                if (checkStck < qty) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid. This product is Out of stock");
                    alert.showAndWait();
                }else if (HelloController.mts!=null){

                        prod_image = prod_image.replace("\\", "\\\\");

                        String insertData = "INSERT INTO customer "
                                + "(customer_id, prod_id, prod_name, type, quantity, price, date, image,em_username,checkBox) "
                                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1, String.valueOf(Data.cID));
                        prepare.setString(2, prodID);
                        prepare.setString(3, prod_name.getText());
                        prepare.setString(4, type);
                        prepare.setString(5, String.valueOf(qty));

                        totalP = (qty * pr);
                        prepare.setString(6, String.valueOf(totalP));

                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        prepare.setString(7, String.valueOf(sqlDate));

                        prepare.setString(8, prod_image);
                        prepare.setString(9, Data.username);
                        //  Idtable tab = new Idtable();  // Utilisez la même instance
                        //  String checkboxValue = tab.selectchoice();
                        //  System.out.println("La valeur " + checkboxValue);
                        //  if (checkboxValue != null) {
                        prepare.setString(10,"take it");
                        //  } else {
                        System.out.println( "le cas où la valeur de la case à cocher "+Idtable.selectedTableId);
                        //   }

                        prepare.executeUpdate();

                        int upStock = checkStck - qty;

                        System.out.println(" type insert custoemer"+type);



                        String updateStock = "UPDATE product SET prod_name = '"
                                + prod_name.getText() + "', type = '"
                                + type + "', stock = " + upStock + ", price = " + pr
                                + ", status = '"
                                + check + "', image = '"
                                + prod_image + "', date = '"
                                + prod_date + "' WHERE prod_id = '"
                                + prodID + "'";

                        prepare = connect.prepareStatement(updateStock);
                        prepare.executeUpdate();
                        System.out.println(" tyyyyyyype"+type);


                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();

                        mForm.menuGetTotal();



                }
                else {
                    prod_image = prod_image.replace("\\", "\\\\");

                    String insertData = "INSERT INTO customer "
                            + "(customer_id, prod_id, prod_name, type, quantity, price, date, image,em_username,checkBox) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(Data.cID));
                    prepare.setString(2, prodID);
                    prepare.setString(3, prod_name.getText());
                    prepare.setString(4, type);
                    prepare.setString(5, String.valueOf(qty));

                    totalP = (qty * pr);
                    prepare.setString(6, String.valueOf(totalP));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(7, String.valueOf(sqlDate));

                    prepare.setString(8, prod_image);
                   prepare.setString(9, Data.username);
                  //  Idtable tab = new Idtable();  // Utilisez la même instance
                  //  String checkboxValue = tab.selectchoice();
                  //  System.out.println("La valeur " + checkboxValue);
                  //  if (checkboxValue != null) {
                        prepare.setString(10,Idtable.selectedTableId );
                  //  } else {
                    System.out.println( "le cas où la valeur de la case à cocher "+Idtable.selectedTableId);
                 //   }

                    prepare.executeUpdate();

                    int upStock = checkStck - qty;

                    System.out.println(" type insert custoemer"+type);



                    String updateStock = "UPDATE product SET prod_name = '"
                            + prod_name.getText() + "', type = '"
                            + type + "', stock = " + upStock + ", price = " + pr
                            + ", status = '"
                            + check + "', image = '"
                            + prod_image + "', date = '"
                            + prod_date + "' WHERE prod_id = '"
                            + prodID + "'";

                    prepare = connect.prepareStatement(updateStock);
                    prepare.executeUpdate();
                    System.out.println(" tyyyyyyype"+type);


                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    mForm.menuGetTotal();
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setQuatity();

    }



}
