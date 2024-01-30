package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.sql.*;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


  public class HelloController implements mainController {
    @FXML
    private Label welcomeText;

    public HelloController() {
    }


    @FXML
    private CheckBox chekboxitem;



    @FXML
    private Label amount;

    @FXML
    private TextField amounttext;

    @FXML
    private Label change;

    @FXML
    private TextField changetext;

    @FXML
    private AnchorPane clientinterface;

    @FXML
    private TableColumn<?, ?> menu_Quantité;

    @FXML
    private TableColumn<?, ?> menu_platname;

    @FXML
    private TableColumn<?, ?> menu_pricecol;

    @FXML
    private ScrollPane menu_scroll;

    @FXML
    private TableView<?> menu_table;

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
    private TextField totaltaxt;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;
    private AnchorPane home;

    private ObservableList<ProductData> cardlistData = FXCollections.observableArrayList();


      public ObservableList<ProductData> menuGetData() {
          System.out.println("Product:   Price: " );

          String sql = "SELECT prod_name, price, image FROM product";
          ObservableList<ProductData> listData = FXCollections.observableArrayList();

          connect = Database.connectDB();

          System.out.println("Connected to the database: " + (connect != null));
          System.out.println("Product:   Price: ");

          try {
              prepare = connect.prepareStatement(sql);
              result = prepare.executeQuery();

              ProductData prod;
              while (result.next()) {
                  prod = new ProductData(result.getString("prod_name"),
                          result.getInt("price"),
                          result.getString("image"));

                  listData.add(prod);
              }
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              // Close resources (Connection, PreparedStatement, ResultSet) in a finally block.
              // This ensures that resources are closed even if an exception occurs.
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

      /*private void setNode(Node node){
        menu_gridpane.getChildren().clear();
        menu_gridpane.getChildren().add((Node) node);
        FadeTransition ft =new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setAutoReverse(false);
        ft.play();
}
private void createPage(){
        try{
            home=FXMLLoader.load(getClass().getResource("plat.fxml"));
           // setNode(home);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
}*/
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
                load.setLocation(getClass().getResource("plat.fxml"));
                AnchorPane pane = load.load();
                ImageView imageView = new ImageView(new Image(cardlistData.get(q).getImage()));

                //  setNode(pane);

                PlatpaimentController cardC = load.getController();
                cardC.setData(cardlistData.get(q));

                if (column == 1) {
                    column = 0;
                    row += 1;
                }

                menu_gridpane.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //  createPage();
        menuDisplayCard();
        System.out.println("HelloController initialized");

    }
    }


