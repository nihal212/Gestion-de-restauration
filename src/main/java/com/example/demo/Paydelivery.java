package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.demo.Data.CID;

public class Paydelivery  implements Initializable {


    @FXML
    private Label amountdelivery;

    @FXML
    private Label changedelivery;

    @FXML
    private Button savedelivery;

    @FXML
    private Label totaldelivery;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    @FXML
    private TextField totaltextdelivery;
    @FXML
    private TextField amounttextdelivery;
    @FXML
    private TextField changetextdelivery;



    public void menuPayBtndelivery() {

        Alert alert;
        if (totalP == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please choose your order first!");
            alert.showAndWait();
        } else {
            menuGetTotaldelivery();
            String insertPay = "INSERT INTO receipt_delivery (client_order, total, date) "
                    + "VALUES(?,?,?)";

            connect = DDBSE.connectDB();

            try {

                if (Amount == 0) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Messaged");
                    alert.setHeaderText(null);
                    alert.setContentText("Something wrong ");
                    alert.showAndWait();
                } else {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure?");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {
                        menuGetTotaldelivery();
                        customerIDd();

                        prepare = connect.prepareStatement(insertPay);
                        prepare.setString(1, String.valueOf(CID));
                        prepare.setString(2, String.valueOf(totalP));

                        java.util.Date date = new java.util.Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                        prepare.setString(3, String.valueOf(sqlDate));


                        prepare.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Infomation Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successful.");
                        alert.showAndWait();
                      //  menuRestartdelivery();
                    } else {
                        alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Infomation Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Cancelled.");
                        alert.showAndWait();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void menuReceiptBtndelivery() {

        if (totalP == 0 || amounttextdelivery.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Please order first");
            alert.showAndWait();
        } else {
            HashMap map = new HashMap();
            map.put("getReceipt_delivery", (CID));
            System.out.println("dyal delivery receipt"+CID);

            try {

                JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\user\\IdeaProjects\\demo\\src\\main\\resources\\com\\example\\demo\\reciptdelivery.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);

                JasperViewer.viewReport(jPrint, false);

                menuRestartdelivery();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }




    public void menuAmountdelivery() {
        menuGetTotaldelivery();
        if (amounttextdelivery.getText().isEmpty() || totalP == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid :3");
            alert.showAndWait();
        } else {
            Amount = Double.parseDouble(amounttextdelivery.getText());
            if (Amount < totalP) {
                amounttextdelivery.setText("");
            } else {
                Change = (Amount - totalP);
                changetextdelivery.setText(Change + " MAD");
            }
        }
    }





    private int CID;
    public static Integer c;

    public  void customerIDd() {

        String sql = "SELECT MAX(client_order) FROM temporary_delivery";
        connect = DDBSE.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                CID = result.getInt("MAX(client_order)");
            }

            String checkCID = "SELECT MAX(client_order) FROM receipt_delivery";
            prepare = connect.prepareStatement(checkCID);
            result = prepare.executeQuery();
            int checkID = 0;
            if (result.next()) {
                checkID = result.getInt("MAX(client_order)");
            }

            if (CID == 0) {
                CID += 1;
            } else if (CID == checkID) {
                CID += 1;
            }

            Data.CID = CID;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private double totalP;
    public void menuGetTotaldelivery() {
        customerIDd();
        String total = "SELECT SUM(price) FROM temporary_delivery WHERE client_order = " + CID;
        System.out.println("le cid est "+CID);
        System.out.println("le cid dyal data howa"+Data.CID);

        connect = DDBSE.connectDB();

        try {

            prepare = connect.prepareStatement(total);
            result = prepare.executeQuery();

            if (result.next()) {
                totalP = result.getDouble("SUM(price)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void menuDisplayTotaldelivery() {
        menuGetTotaldelivery();
        totaltextdelivery.setText(totalP +" MAD");
    }
    private double Amount;
    private double Change;
    public void menuRestartdelivery() {
        totalP = 0;
        Change = 0;
        Amount = 0;
       totaltextdelivery.setText("0.0 MAD");
        amounttextdelivery.setText("");
        changetextdelivery.setText("0.0 MAD");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuDisplayTotaldelivery();
    }
}
