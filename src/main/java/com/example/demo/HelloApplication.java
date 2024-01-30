package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader firstPageLoader = new FXMLLoader(HelloApplication.class.getResource("firstpage.fxml"));
        FXMLLoader helloViewLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view1.fxml"));
        FXMLLoader helloViewLoader2 = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader helloViewLoader3 = new FXMLLoader(HelloApplication.class.getResource("FXMLDocument1.fxml"));


        Scene firstPageScene = new Scene(firstPageLoader.load());
        Scene helloViewScene = new Scene(helloViewLoader.load());
        Scene helloViewScene2 = new Scene(helloViewLoader2.load());
        Scene helloViewScene3 = new Scene(helloViewLoader3.load());



        Firstpage firstPageController = firstPageLoader.getController();
        firstPageController.setHelloViewScene(helloViewScene);
        firstPageController.setHelloViewScene2(helloViewScene2);
        firstPageController.setHelloViewScene3(helloViewScene3);


        stage.setScene(firstPageScene);
        stage.setTitle("HOUSE OF CHEF");
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}