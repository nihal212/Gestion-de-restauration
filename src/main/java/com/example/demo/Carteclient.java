package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class Carteclient  implements Initializable {

    @FXML
    private Button CLOSE;

    @FXML
    private TextField adress;

    @FXML
    private TextField contact;

    @FXML
    private TextField name;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    public void close(ActionEvent e) {
        if (e.getSource() == CLOSE) {
            Stage stage = (Stage) CLOSE.getScene().getWindow();
            stage.close();
        }
    }
    static public String nom;
    static public String phone;
    static public String ads;

    public TextField getAdress() {
        return adress;
    }

    public TextField getContact() {
        return contact;
    }

    public TextField getName() {
        return name;
    }

    public  void Name() {

      nom= name.getText();

    }

    public void Contact() {
      phone= contact.getText();
    }

    public void Address() {
      ads= adress.getText();
    }

    public void regBtn() {
        // Vérifier si les champs sont vides
        Alert alert;
        if (adress.getText().isEmpty() || contact.getText().isEmpty() || name.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message d'Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();
        } else {
            // Requête d'insertion des données dans la base de données
            String regData = "INSERT INTO delivery (client_name, client_address, client_contact) "
                    + "VALUES(?,?,?)";
            connect = DDBSE.connectDB();

            try {
                // Vérifier si le nom est déjà enregistré
                String checkName = "SELECT client_name FROM delivery WHERE client_name = '"
                        + name.getText() + "'";

                prepare = connect.prepareStatement(checkName);
                result = prepare.executeQuery();

                // Si le nom est déjà pris, afficher un message d'erreur
                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Message d'Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText(name.getText() + " est déjà pris");
                    alert.showAndWait();
                } else {
                    // Préparer la requête d'insertion
                    prepare = connect.prepareStatement(regData);
                    prepare.setString(1, name.getText());
                    prepare.setString(2, adress.getText());
                    prepare.setString(3, contact.getText());




                    // Exécuter la requête d'inscription
                    prepare.executeUpdate();

                    // Afficher un message de succès
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message d'Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Employé enregistré avec succès !");
                    alert.showAndWait();

                    // Effacer les champs de saisie
                    name.setText("");
                    adress.setText("");
                    contact.setText("");

                    // Éventuellement, vous pouvez effectuer des transitions d'interface utilisateur ou d'autres actions ici
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
