package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Firstpage {

    @FXML
    private Button waiterbtn;
    @FXML
    private Button clientBtn;

    @FXML
    private Button adminbtn;

    private Scene helloViewScene;
    private Scene helloViewScene2;
    private Scene helloViewScene3;




    @FXML
    public void initialize() {
        // Vous pouvez initialiser les scènes ici, par exemple, en les chargeant depuis les fichiers FXML
        try {
            FXMLLoader helloViewLoader = new FXMLLoader(getClass().getResource("hello-view1.fxml"));
            helloViewScene = new Scene(helloViewLoader.load());

            FXMLLoader helloViewLoader2 = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            helloViewScene2 = new Scene(helloViewLoader2.load());

            FXMLLoader helloViewLoader3 = new FXMLLoader(getClass().getResource("FXMLDocument1.fxml"));
            helloViewScene3 = new Scene(helloViewLoader3.load());
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer les erreurs de chargement des scènes
        }
    }


    public void setHelloViewScene(Scene helloViewScene) {
        this.helloViewScene = helloViewScene;
    }
    public void setHelloViewScene2(Scene helloViewScene2) {
        this.helloViewScene2 = helloViewScene2;
    }
    public void setHelloViewScene3(Scene helloViewScene3) {
        this.helloViewScene3 = helloViewScene3;
    }



    @FXML
    private void switchToHelloView(ActionEvent event) throws IOException {
        if(event.getSource()==waiterbtn) {

            // Switch to the hello-view scene when the button is clicked
            switchScene(helloViewScene);
        }else if(event.getSource()==clientBtn){
            switchScene2(helloViewScene2);

        }else if(event.getSource()==adminbtn)
        {
            switchScene3(helloViewScene3);
        }
    }

    private void switchScene(Scene scene) {
        // Create a new StackPane for the second scene
        StackPane newRoot = new StackPane();
        newRoot.getChildren().addAll(scene.getRoot());

        // Set the new StackPane as the root of the current scene
        waiterbtn.getScene().setRoot(newRoot);
    }

    private void switchScene2(Scene scene) {
        // Create a new StackPane for the second scene
        StackPane newRoot = new StackPane();
        newRoot.getChildren().addAll(scene.getRoot());

        // Set the new StackPane as the root of the current scene
       clientBtn.getScene().setRoot(newRoot);
    }
    private void switchScene3(Scene scene) {
        // Create a new StackPane for the second scene
        StackPane newRoot = new StackPane();
        newRoot.getChildren().addAll(scene.getRoot());

        // Set the new StackPane as the root of the current scene
        adminbtn.getScene().setRoot(newRoot);
    }

}
