package com.example.demo;

import com.sun.imageio.plugins.common.SimpleRenderedImage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.*;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.demo.Data.CID;


public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button logout2;
    @FXML
    private WebView web;

    @FXML
    private GridPane gridDelevery;
    @FXML
    private Button DELIVERYORDER;

    @FXML
    private Button register;
    @FXML
    private Button LogOut;

    @FXML
    private Button ORDER;
    @FXML
    private Button payDelivery;

    @FXML
    private CheckBox chekboxitem;

    @FXML
    private Button Dashboard;

    @FXML
    private AnchorPane Dashboard_client;

    @FXML
    private Button MENU;

    @FXML
    private Label amount;

    @FXML
    private TextField amounttext;

    @FXML
    private Label change;

    @FXML
    private TextField changetext;
    @FXML
    private GridPane gridcomment;


    @FXML
    private AnchorPane clientinterface;

    @FXML
    private TableColumn<ProductData, String> menu_Quantité;

    @FXML
    private TableColumn<ProductData, String> menu_platname;

    @FXML
    private TableColumn<ProductData, String> menu_pricecol;

    @FXML
    private ScrollPane menu_scroll;
    @FXML
    private AnchorPane Delilevrydash;

    @FXML
    private TableView<ProductData> menu_table;

    @FXML
    private AnchorPane menuforme;

    @FXML
    private Button menupay;

    @FXML
    private Button menurecip;

    @FXML
    private Button menuremove;
    @FXML
    private VBox menu_vbox;
    @FXML
    private GridPane menu_gridpane;
    @FXML
    private AnchorPane payemment;

    @FXML
    private Label total;
    @FXML
    private Button msgbutton;
    @FXML
    private TextField messageTextField;

    @FXML
    private TextField totaltaxt;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;
    private AnchorPane home;
    @FXML
    private Button dishes;

    @FXML
    private Button drinks;

    @FXML
    private Button fast_food;
    @FXML
    private Button soup;
    @FXML
    private CheckBox checkbook;

    @FXML
    private CheckBox checktake;
    @FXML
    private GridPane griddashbord;

    @FXML
    private BorderPane clientpage;












    private void switchScene3(Scene scene) {
        // Create a new StackPane for the second scene
        StackPane newRoot = new StackPane();
        newRoot.getChildren().addAll(scene.getRoot());

        // Set the new StackPane as the root of the current scene
       logout2.getScene().setRoot(newRoot);
    }









    public void registre(ActionEvent event){
        if(event.getSource()==register){
            FXMLLoader fxmlLoader = new FXMLLoader();
            URL location = getClass().getResource("carteclient.fxml");
            if (location == null) {
                System.err.println("Could not find FXML file carteclient.fxml");
                return;
            }
            fxmlLoader.setLocation(location);

            try {
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setWidth(750);
                stage.setHeight(560);

                stage.setTitle("FORM");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    public void comment(ActionEvent event) {
        if (event.getSource() == msgbutton) {
            afficherChampMessage();
            if( !messageTextField.getText().isEmpty()){
            enregistrerDansBaseDeDonnees();}


        }
    }
    public void enterHandler(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER  ) {
            // Appeler la méthode pour enregistrer dans la base de données
            enregistrerDansBaseDeDonnees();

            // Rendre le TextField invisible
            messageTextField.setVisible(false);
        }
    }





    private void enregistrerDansBaseDeDonnees() {
        // Placez ici le code pour enregistrer le message dans la base de données
        String message = messageTextField.getText();
        String insertPay = "INSERT INTO commentaire (comment) "
                + "VALUES(?)";


        connect = DDBSE.connectDB();
        try {
            prepare = connect.prepareStatement(insertPay);
                prepare.setString(1, message);
                prepare.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Message enregistré dans la base de données : " + message);
        // Vous devrez intégrer votre propre logique d'accès à la base de données ici
    }

    private void afficherChampMessage() {
        messageTextField.setVisible(true);
    }

   /* public  ObservableList<comment> menuCommnet(){


        String sql = "SELECT * FROM `commentaire`";
        ObservableList<comment> listData = FXCollections.observableArrayList();

        connect = Database.connectDB();

        System.out.println("Connected to the database: " + (connect != null));
        System.out.println("comentaire");

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            comment tab = null;
            while (result.next()) {
                tab = new comment(result.getInt("id"),
                        result.getString("comment"));

                listData.add(tab);
            }     System.out.println(" tabbbbbble idddddd"+tab.getComment());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listData;
    }
    ObservableList<comment> cardlistData= FXCollections.observableArrayList();

    public void menuDisplaycomment() {
        System.out.println("Product:   Price: " );

        cardlistData.clear();
        cardlistData.addAll(menuCommnet());
        int row = 0;
        int column = 0;

        gridcomment.getChildren().clear();
        gridcomment.getRowConstraints().clear();
        gridcomment.getColumnConstraints().clear();


        for (int q = 0; q < cardlistData.size(); q++) {

            try {
                FXMLLoader load = new FXMLLoader();

                // Utilisez une approche absolue pour charger le fichier FXML
                load.setLocation(Tableview.class.getResource("commentaire.fxml"));
                AnchorPane pane = load.load();

                commentairecontrolleur cardC =load.getController();

                cardC.setdata(cardlistData.get(q));

                if (column == 1) {
                    column = 0;
                    row += 1;
                }

                gridcomment.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(5));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }*/

    public void choiseOrder(ActionEvent event) throws SQLException, IOException {
        if (checkbook.isSelected()) {
            System.out.println("le plat pour une table");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("choise");
            alert.setHeaderText(null);
            alert.setContentText("are you sure for a book");
            Optional<ButtonType> option = alert.showAndWait();


            if (option.get().equals(ButtonType.OK)) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                // Assurez-vous que le chemin du fichier FXML est correct
                URL location = getClass().getResource("tableview.fxml");
                if (location == null) {
                    System.err.println("Could not find FXML file: tableview.fxml");
                    return;
                }
                fxmlLoader.setLocation(location);

                try {
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setWidth(750);
                    stage.setHeight(560);

                    stage.setTitle("Tables");
                    stage.setScene(scene);
                    
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (checkbook.isSelected()) {
            // Désélectionnez la case à cocher
            checkbook.setSelected(false);
        }
    }
        public static String mts;
    public void choicetake(){
         if (checktake.isSelected()) {

             System.out.println("le plat en porté");
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("choise");
             alert.setHeaderText(null);
             alert.setContentText("are you sure for take it");
             alert.showAndWait();
            mts="take it";

         } if (checktake.isSelected()) {
            // Désélectionnez la case à cocher
        checktake.setSelected(false);
        }
         else
             mts=null;
    }

    public void switchtypes(ActionEvent event) {
        if(event.getSource() == dishes)

    {
        menuDisplayCard("dishes");
        System.out.println("Switching to Dishes");

    }
        else if(event.getSource()==drinks)

    {
        menuDisplayCard("drinks");
    } else if(event.getSource()==fast_food)

    {
        menuDisplayCard("fast_food");
    }else if(event.getSource()==soup)

    {
        menuDisplayCard("soup");


        // Ajoutez des conditions pour les autres boutons si nécessaire
    }

}
    private ObservableList<ProductData> cardlistData = FXCollections.observableArrayList();
    public ObservableList<ProductData> menuGetDataByType(String productType) {
        System.out.println("Product:   Price: ");

        String sql = "SELECT * FROM product WHERE type = ?";
        ObservableList<ProductData> listData = FXCollections.observableArrayList();

        connect = DDBSE.connectDB();

        System.out.println("Connected to the database: " + (connect != null));
        System.out.println("Product:   Price: ");

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, productType);
            result = prepare.executeQuery();

            ProductData prod;
            while (result.next()) {
                prod = new ProductData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getDouble("price"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("type"),
                        result.getInt("stock"));

                listData.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listData;
    }
    public void menuDisplayCard(String productType) {
        System.out.println("Product:   Price: ");

        cardlistData.clear();
        cardlistData.addAll(menuGetDataByType(productType));
        int row = 0;
        int column = 0;

        menu_gridpane.getChildren().clear();
        menu_gridpane.getRowConstraints().clear();
        menu_gridpane.getColumnConstraints().clear();

        for (int q = 0; q < cardlistData.size(); q++) {
            try {
                FXMLLoader load = new FXMLLoader();

                // Utilisez une approche absolue pour charger le fichier FXML
                load.setLocation(getClass().getResource("plat.fxml"));
                AnchorPane pane = load.load();

                PlatpaimentController cardC = load.getController();
                cardC.setData(cardlistData.get(q));

                if (column == 1) {
                    column = 0;
                    row += 1;
                }

                menu_gridpane.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(5));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == Dashboard) {
            Dashboard_client.setVisible(true);
            // inventory_form.setVisible(false);
            clientinterface.setVisible(false);
            // customers_form.setVisible(false);
            Delilevrydash.setVisible(false);
             /* dashboardDisplayNC();
              dashboardDisplayTI();
              dashboardTotalI();
              dashboardNSP();
              dashboardIncomeChart();
              dashboardCustomerChart();*/

        } else if (event.getSource() == MENU) {
            Dashboard_client.setVisible(false);
            // inventory_form.setVisible(false);
            clientinterface.setVisible(true);
            // customers_form.setVisible(false);
            Delilevrydash.setVisible(false);
            menuDisplayCard();
          /*  menuDisplayCard("drinks");
            menuDisplayCard("fast_food");
            menuDisplayCard("soup");
            menuDisplayCard("dishes");*/
            menuDisplayTotal();

            menuShowOrderData();
        }else if(event.getSource()==DELIVERYORDER){
            Delilevrydash.setVisible(true);
            Dashboard_client.setVisible(false);
            clientinterface.setVisible(false);


        }else if (event.getSource() == logout2) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            URL location = getClass().getResource("firstpage.fxml");

            if (location == null) {
                System.err.println("Impossible de trouver le fichier FXML firstpage.fxml");
                return;
            }

            fxmlLoader.setLocation(location);

            try {
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);

                // Obtenez la stage existante et définissez la nouvelle scène
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("house of chef");


                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // En supposant que clientpage est un Node représentant le contenu actuel
            clientpage.setVisible(false);
        }


    }
  public ObservableList<ProductData> menuGetData() {
        System.out.println("Product:   Price: " );

        String sql = "SELECT * FROM product";
        ObservableList<ProductData> listData = FXCollections.observableArrayList();

        connect =DDBSE.connectDB();

        System.out.println("Connected to the database: " + (connect != null));
        System.out.println("Product:   Price: ");

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ProductData prod = null;
            while (result.next()) {
                prod = new ProductData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getDouble("price"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("type"),
                        result.getInt("stock"));

                listData.add(prod);
            }        System.out.println(" tyyyyyyype"+prod.getType());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listData;
    }


    public void menuDisplayCard() {
        System.out.println("Product:   Price: " );

        cardlistData.clear();
        cardlistData.addAll(menuGetData());
        int row = 0;
        int column = 0;

        menu_gridpane.getChildren().clear();
        menu_gridpane.getRowConstraints().clear();
        menu_gridpane.getColumnConstraints().clear();


        for (int q = 0; q < cardlistData.size(); q++) {

            try {
                FXMLLoader load = new FXMLLoader();

                // Utilisez une approche absolue pour charger le fichier FXML
                load.setLocation(getClass().getResource("plat.fxml"));
                AnchorPane pane = load.load();



                PlatpaimentController cardC = load.getController();
                cardC.setData(cardlistData.get(q));

                if (column == 1) {
                    column = 0;
                    row += 1;
                }

                menu_gridpane.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(5));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    private int cID;

    public void customerID() {

        String sql = "SELECT MAX(customer_id) FROM customer";
        connect = DDBSE.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                cID = result.getInt("MAX(customer_id)");
            }

            String checkCID = "SELECT MAX(customer_id) FROM receipt";
            prepare = connect.prepareStatement(checkCID);
            result = prepare.executeQuery();
            int checkID = 0;
            if (result.next()) {
                checkID = result.getInt("MAX(customer_id)");
            }

            if (cID == 0) {
                cID += 1;
            } else if (cID == checkID) {
                cID += 1;
            }

            Data.cID = cID;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ObservableList<ProductData> menuGetOrder() {
        customerID();
        ObservableList<ProductData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer WHERE customer_id = " + cID;

        connect = DDBSE.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ProductData prod;

            while (result.next()) {
                prod = new ProductData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getDouble("price"),
                        result.getString("image"),
                        result.getDate("date"),

                        result.getString("type"),
                        result.getInt("quantity")
                );
                listData.add(prod);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }
    private ObservableList<ProductData> menuOrderListData;

    /* public void menuShowOrderData() {
         menuOrderListData = menuGetOrder();

         menu_platname.setCellValueFactory(new PropertyValueFactory<>("productName"));
         menu_Quantité.setCellValueFactory(new PropertyValueFactory<>("quantity"));
         menu_pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));

         menu_table.setItems(menuOrderListData);
     }*/
    public void menuShowOrderData() {
        menuOrderListData = menuGetOrder();

        if (menu_platname != null) {
            menu_platname.setCellValueFactory(new PropertyValueFactory<>("productName"));
        } else {
          //  System.err.println("menu_platname is null");
        }

        if (menu_Quantité != null) {
            menu_Quantité.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        } else {
            //System.err.println("menu_Quantité is null");
        }

        if (menu_pricecol != null) {
            menu_pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
        } else {
          //  System.err.println("menu_pricecol is null");
        }

        if (menu_table != null) {
            menu_table.setItems(menuOrderListData);
        } else {
           // System.err.println("menu_table is null");
        }
    }
    private int getid;
    public void menuSelectOrder(){
        ProductData prod = menu_table.getSelectionModel().getSelectedItem();
        int num = menu_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        // TO GET THE ID PER ORDER
        getid = prod.getId();

    }
    public void menuRemoveBtn() {
        Alert alert;
        if ( (getid == 0) || (menu_table == null) ) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the order you want to remove");
            alert.showAndWait();
        } else {
            String deleteData = "DELETE FROM customer WHERE id = " + getid;
            connect = DDBSE.connectDB();
            try {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this order?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();
                }

                menuShowOrderData();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    private double totalP;
    public void menuGetTotal() {
        customerID();
        String total = "SELECT SUM(price) FROM customer WHERE customer_id = " + cID;

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

    public void menuDisplayTotal() {
        menuGetTotal();
        totaltaxt.setText(totalP +" MAD");
    }
    private double Amount;
    private double Change;
    public void menuRestart() {
        totalP = 0;
        Change = 0;
        Amount = 0;
        totaltaxt.setText("0.0 MAD");
        amounttext.setText("");
        changetext.setText("0.0 MAD");
    }
    public void menuAmount() {
        menuGetTotal();
        if (amounttext.getText().isEmpty() || totalP == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid :3");
            alert.showAndWait();
        } else {
            Amount = Double.parseDouble(amounttext.getText());
            if (Amount < totalP) {
                amounttext.setText("");
            } else {
                Change = (Amount - totalP);
                changetext.setText(Change + " MAD");
            }
        }
    }
    public void menuPayBtn() {

        Alert alert;
        if (totalP == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please choose your order first!");
            alert.showAndWait();
        } else {
            menuGetTotal();
            String insertPay = "INSERT INTO receipt (customer_id, total, date, em_username) "
                    + "VALUES(?,?,?,?)";

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
                        customerID();
                        menuGetTotal();
                        prepare = connect.prepareStatement(insertPay);
                        prepare.setString(1, String.valueOf(cID));
                        prepare.setString(2, String.valueOf(totalP));

                        java.util.Date date = new java.util.Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                        prepare.setString(3, String.valueOf(sqlDate));
                        prepare.setString(4, Data.username);

                        prepare.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Infomation Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successful.");
                        alert.showAndWait();

                        menuShowOrderData();

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
    public void menuReceiptBtn() {

        if (totalP == 0 ||  amounttext.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Please order first");
            alert.showAndWait();
        } else {
            HashMap map = new HashMap();
            map.put("getReceipt", (cID - 1));

            try {

                JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\user\\IdeaProjects\\demo\\src\\main\\resources\\com\\example\\demo\\recciptjava.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);

                JasperViewer.viewReport(jPrint, false);

                menuRestart();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public  ObservableList<comment> menuCommnet(){


        String sql = "SELECT * FROM `commentaire`";
        ObservableList<comment> listData = FXCollections.observableArrayList();

        connect = DDBSE.connectDB();

        System.out.println("Connected to the database: " + (connect != null));
        System.out.println("comentaire");

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            comment tab = null;
            while (result.next()) {
                tab = new comment(result.getInt("id"),
                        result.getString("comment"));

                listData.add(tab);
            }     System.out.println(" tabbbbbble idddddd"+tab.getComment());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listData;
    }
    ObservableList<comment> cardlistdata= FXCollections.observableArrayList();

    public void menuDisplaycomment(){
        System.out.println("Product:   Price: " );

        cardlistdata.clear();
        cardlistdata.addAll(menuCommnet());
        int row = 0;
        int column = 0;

        gridcomment.getChildren().clear();
        gridcomment.getRowConstraints().clear();
        gridcomment.getColumnConstraints().clear();


        for (int q = 0; q < cardlistdata.size(); q++) {

            try {
                FXMLLoader load = new FXMLLoader();

                // Utilisez une approche absolue pour charger le fichier FXML
                load.setLocation(Tableview.class.getResource("commentaire.fxml"));
                AnchorPane pane = load.load();

                commentairecontrolleur card =load.getController();

                card.setComment(cardlistdata.get(q));

                if (column == 1) {
                    column = 0;
                    row += 1;
                }

                gridcomment.add(pane, column++, row);

               // GridPane.setMargin(pane, new Insets(5));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }












    public  ObservableList<ProductData> menudash(){

        String sql = "SELECT prod_name, price/quantity AS price_per_unit, image, quantity FROM customer ORDER BY quantity DESC LIMIT 8";

        ObservableList<ProductData> listData = FXCollections.observableArrayList();

            connect = DDBSE.connectDB();

            System.out.println("Connected to the database: " + (connect != null));
            System.out.println("wxcdfvbghjklo");

            try {
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                while (result.next()) {
                    System.out.println("prod_name: " + result.getString("prod_name"));
                    System.out.println("price: " + result.getDouble("price_per_unit"));
                    System.out.println("image: " + result.getString("image"));
                    System.out.println("quantity: " + result.getInt("quantity"));

                    ProductData prod = new ProductData(
                            result.getString("prod_name"),
                            result.getDouble("price_per_unit"),
                            result.getString("image"),
                            result.getInt("quantity")
                    );
                    listData.add(prod);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (result != null) result.close();
                    if (prepare != null) prepare.close();
                    if (connect != null) connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return listData;
        }

        ObservableList< ProductData> cardlistdash= FXCollections.observableArrayList();

    public void menuDisplaydash(){
        System.out.println("Product:   Price: " );

        cardlistdash.clear();
        cardlistdash.addAll(menudash());
        int row = 0;
        int column = 0;

        griddashbord.getChildren().clear();
        griddashbord.getRowConstraints().clear();
        griddashbord.getColumnConstraints().clear();


        for (int q = 0; q < cardlistdash.size(); q++) {

            try {
                FXMLLoader load = new FXMLLoader();

                // Utilisez une approche absolue pour charger le fichier FXML
                load.setLocation(Tableview.class.getResource("produitdashbord.fxml"));
                AnchorPane pane = load.load();

            produitdashbordController card =load.getController();

                card.setdatadas( cardlistdash.get(q));

                if (column == 4) {
                    column = 0;
                    row += 1;
                }

                griddashbord.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(8));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    ObservableList< ProductData> cardlistdaD= FXCollections.observableArrayList();

    public ObservableList<ProductData> menuGetDataD() {
        System.out.println("Product:   Price: " );

        String sql = "SELECT * FROM product";
        ObservableList<ProductData> listData = FXCollections.observableArrayList();

        connect = DDBSE.connectDB();

        System.out.println("Connected to the database: " + (connect != null));
        System.out.println("Product:   Price: ");

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ProductData prod = null;
            while (result.next()) {
                prod = new ProductData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getDouble("price"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("type"),
                        result.getInt("stock"));

                listData.add(prod);
            }        System.out.println(" tyyyyyyype"+prod.getType());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listData;
    }


    public void menuDisplayCardD() {
        System.out.println("Product:   Price: " );

        cardlistdaD.clear();
        cardlistdaD.addAll(menuGetDataD());
        int row = 0;
        int column = 0;

        gridDelevery.getChildren().clear();
        gridDelevery.getRowConstraints().clear();
        gridDelevery.getColumnConstraints().clear();


        for (int q = 0; q < cardlistData.size(); q++) {

            try {
                FXMLLoader load = new FXMLLoader();

                // Utilisez une approche absolue pour charger le fichier FXML
                load.setLocation(getClass().getResource("Delivery.fxml"));
                AnchorPane pane = load.load();



                DeliveryplatController cardC = load.getController();
                cardC.setdat(cardlistData.get(q));

                if (column == 2) {
                    column = 0;
                    row += 1;
                }

                gridDelevery.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(8));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


   /* public void menuReceiptBtndelivery() {

        if (totalP == 0 || amounttext.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Please order first");
            alert.showAndWait();
        } else {
            HashMap map = new HashMap();
            map.put("getReceipt-delivery",(CID-1));

            try {

                JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\user\\IdeaProjects\\demo\\src\\main\\resources\\com\\example\\demo\\reciptdelivery.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);

                JasperViewer.viewReport(jPrint, false);

                menuRestart();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }*/


    public void paychamps(ActionEvent event){
        if(event.getSource()==payDelivery){
            FXMLLoader fxmlLoader = new FXMLLoader();
            URL location = getClass().getResource("paydelivery.fxml");
            if (location == null) {
                System.err.println("Could not find FXML file payedelivery.fxml");
                return;
            }
            fxmlLoader.setLocation(location);

            try {
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setWidth(455);
                stage.setHeight(400);

                stage.setTitle("PAY");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        WebEngine engine = web.getEngine();
        String htmlContent ="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.9.3/dist/leaflet.css\" integrity=\"sha256-kLaT2GOSpHechhsozzB+flnD+zUyjE2LlfWPgU04xyI=\" crossorigin=\"\" />\n" +
                "    <script src=\"https://unpkg.com/leaflet@1.9.3/dist/leaflet.js\" integrity=\"sha256-WBkoXOwTeyKclOHuWtc+i2uENFpDZ9YPdf5Hf+D7ewM=\" crossorigin=\"\"></script>\n" +
                "\n" +
                "    <style>\n" +
                "        #map { height: 662px; width: 100%; }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div id=\"map\"></div>\n" +
                "\n" +
                "    <script>\n" +
                "        const map = L.map('map');\n" +
                "        map.setView([31.791702, -7.092620], 6);  // Coordonnées de la maroc (latitude, longitude) et niveau de zoom\n" +
                "\n" +
                "        L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {\n" +
                "            maxZoom: 19,\n" +
                "            attribution: '&copy; <a href=\"http://www.openstreetmap.org/copyright\">OpenStreetMap</a>'\n" +
                "        }).addTo(map);\n" +
                "\n" +
                "        let marker, circle, zoomed;\n" +
                "\n" +
                "        navigator.geolocation.watchPosition(success, error);\n" +
                "\n" +
                "        function success(pos) {\n" +
                "            const lat = pos.coords.latitude;\n" +
                "            const lng = pos.coords.longitude;\n" +
                "            const accuracy = pos.coords.accuracy;\n" +
                "\n" +
                "            if (marker) {\n" +
                "                map.removeLayer(marker);\n" +
                "                map.removeLayer(circle);\n" +
                "            }\n" +
                "\n" +
                "            marker = L.marker([lat, lng]).addTo(map);\n" +
                "            circle = L.circle([lat, lng], { radius: accuracy }).addTo(map);\n" +
                "\n" +
                "            if (!zoomed) {\n" +
                "                zoomed = map.fitBounds(circle.getBounds());\n" +
                "            }\n" +
                "\n" +
                "            map.setView([lat, lng]);\n" +
                "        }\n" +
                "\n" +
                "        function error(err) {\n" +
                "            if (err.code === 1) {\n" +
                "                alert(\"Please allow geolocation access\");\n" +
                "            } else {\n" +
                "                alert(\"Cannot get current location\");\n" +
                "            }\n" +
                "        }\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";
        engine.loadContent(htmlContent);





        menuDisplayCard();
       /* menuDisplayCard("drinks");
        menuDisplayCard("fast_food");
        menuDisplayCard("soup");
        menuDisplayCard("dishes");*/
        System.out.println("HelloController initialized");
        // Dashboad_client.setVisible(true);
        menuDisplaycomment();
        menuDisplayTotal();
        menuGetTotal();
        menuShowOrderData();
       menuDisplaydash();

        menuDisplayCardD();
    }
}


