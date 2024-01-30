package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.annotation.Inherited;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;





public class DeliveryplatController implements Initializable {
    @FXML
    private Button ADDDEL;

    @FXML
    private ImageView impdD;

    @FXML
    private Label pndD;

    @FXML
    private Label ppdD;

    @FXML
    private Spinner<Integer> sppiDEL;


    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private String prod_date;

    private Double pr;private String type;
    private String prod_ID;
    public void setQuatity(){
        spin =new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        sppiDEL.setValueFactory(spin);
    }
    private ProductData prodData;
    private String prodimage;
    private Image image;
    private SpinnerValueFactory<Integer> spin;

    public void setdat(ProductData prodData){
        this.prodData=prodData;
        this.prodimage = prodData.getImage();
        this.ppdD.setText(String.valueOf(prodData.getPrice())+" MAD" );
        String path = "File:" + prodData.getImage();
        this.image = new Image(path, 322, 150, false, true);
        this.impdD.setImage(image);
        this.pndD.setText(prodData.getProductName());
        this.prod_date = String.valueOf(prodData.getDate());
        this.type = prodData.getType();

        pr = prodData.getPrice();

        this.prod_ID = prodData.getProductId();


    }
    private double totalP;

    private int qty;

    public void addBtnD() {
      Alert alert;
       Paydelivery mform=new Paydelivery();
       mform.customerIDd();

        qty =  sppiDEL.getValue();
        String check = "";
        String checkAvailable = "SELECT status FROM product WHERE prod_id = '"
                + prod_ID + "'";

        connect = DDBSE.connectDB();

        try {
            int checkStck = 0;
            String checkStock = "SELECT stock FROM product WHERE prod_id = '"
                    + prod_ID + "'";

            prepare = connect.prepareStatement(checkStock);
            result = prepare.executeQuery();

            if (result.next()) {
                checkStck = result.getInt("stock");
            }

            if(checkStck == 0){


                String updateStock = "UPDATE product SET prod_name = '"
                        + pndD.getText() + "', type = '"
                        + type+ "', stock = 0, price = " + pr
                        + ", status = 'Unavailable', image = '"
                        + prodimage + "', date = '"
                        + prod_date + "' WHERE prod_id = '"
                        + prod_ID + "'";
                prepare = connect.prepareStatement(updateStock);
                prepare.executeUpdate();


            }

            prepare = connect.prepareStatement(checkAvailable);
            result = prepare.executeQuery();

            if (result.next()) {
                check = result.getString("status");
            }


            String checkinfo = "SELECT client_name, client_address, client_contact FROM delivery  ORDER BY id_client DESC LIMIT 1";

            prepare = connect.prepareStatement(checkinfo);
            result = prepare.executeQuery();
            String checkname = null;
            String checkadres = null;
            String checkcon = null;


            if (result.next()) {
                checkname = result.getString("client_name");
                checkadres = result.getString("client_address");
                checkcon = result.getString("client_contact");
            }
            else if(checkname==null && checkadres==null && checkcon==null){

                // Aucune ligne n'a été trouvée, affichez une alerte pour enregistrer une nouvelle ligne
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("No delivery information found. Please enter new delivery information.");
                alert.showAndWait();

                // Ajoutez votre logique pour enregistrer une nouvelle ligne ici




            }

            System.out.println("Checkname: " + checkname);
            System.out.println("Checkadres: " + checkadres);
            System.out.println("Checkcon: " + checkcon);









            if (!check.equals("Available") || qty == 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("the quantity is null");
                alert.showAndWait();
            } else{

                if (checkStck < qty) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid. This product is Out of stock");
                    alert.showAndWait();
                }else {

                    prodimage = prodimage.replace("\\", "\\\\");
                    String insertData = "INSERT INTO temporary_delivery "
                            + "(client_order,name_client,contact_client,adresse_client, prod_name, prod_id, quantity, price,date,image)"
                            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(Data.CID));
                    System.out.println("le CID xlahta machi null"+ Data.CID);
                    prepare.setString(2, checkname);
                    prepare.setString(3,checkcon);
                    prepare.setString(4,  checkadres );
                    prepare.setString(5,pndD.getText());
                    prepare.setString(6, prod_ID);

                    prepare.setString(7, String.valueOf(qty));

                    totalP = (qty * pr);
                    prepare.setString(8, String.valueOf(totalP));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(9, String.valueOf(sqlDate));
                    prepare.setString(10, prodimage);



                    prepare.executeUpdate();

                    int upStock = checkStck - qty;

                    System.out.println(" type insert custoemer"+type);



                    String updateStock = "UPDATE product SET prod_name = '"
                            + pndD.getText() + "', type = '"
                            + type + "', stock = " + upStock + ", price = " + pr
                            + ", status = '"
                            + check + "', image = '"
                            + prodimage + "', date = '"
                            + prod_date + "' WHERE prod_id = '"
                            + prod_ID + "'";

                    prepare = connect.prepareStatement(updateStock);
                    prepare.executeUpdate();
                    System.out.println(" tyyyyyyype"+type);


                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    mform.menuGetTotaldelivery();



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
