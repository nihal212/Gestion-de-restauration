package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Tableview implements Initializable {
    @FXML
    private GridPane gridtable;
    @FXML
    private Button CLOSE;
    @FXML
    private ScrollBar scrool_table;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private  ResultSet result;
    private Table table;
    private String tableid;

    public  ObservableList<Table> menuGetable(){


        String sql = "SELECT * FROM `table` where etat='release' ";
        ObservableList<Table> listData = FXCollections.observableArrayList();

        connect = DDBSE.connectDB();

        System.out.println("Connected to the database: " + (connect != null));
        System.out.println("table_id ");

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Table  tab = null;
            while (result.next()) {
              tab = new Table(result.getInt("Numtab"),
                        result.getString("etat"),
                      result.getInt("nbreDePlace"));

                listData.add(tab);
            }     System.out.println(" tabbbbbble idddddd"+tab.getNbreplace());

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
    ObservableList<Table> cardlistData= FXCollections.observableArrayList();

    public void menuDisplaytable() {
        System.out.println("Product:   Price: " );

        cardlistData.clear();
        cardlistData.addAll(menuGetable());
        int row = 0;
        int column = 0;

        gridtable.getChildren().clear();
        gridtable.getRowConstraints().clear();
        gridtable.getColumnConstraints().clear();


        for (int q = 0; q < cardlistData.size(); q++) {

            try {
                FXMLLoader load = new FXMLLoader();

                // Utilisez une approche absolue pour charger le fichier FXML
                load.setLocation(Tableview.class.getResource("idtable.fxml"));
                AnchorPane pane = load.load();

              Idtable cardC =load.getController();

                cardC.setdata(cardlistData.get(q));

                if (column == 1) {
                    column = 0;
                    row += 1;
                }

                gridtable.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(5));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    public  void Close(ActionEvent e){
        if(e.getSource()==CLOSE){
            Stage stage = (Stage) CLOSE.getScene().getWindow();

            stage.close();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuDisplaytable();
    }
}
