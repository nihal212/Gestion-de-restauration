package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class HelloController1 implements Initializable {

    @FXML
    private Label address;

    @FXML
    private Button button_notification;

    @FXML
    private Button button_notification1;

    @FXML
    private Button button_notification11;

    @FXML
    private Button connectbuttom;

    @FXML
    private Label dateofbirth;

    @FXML
    private Label email;

    @FXML
    private Label firstname;

    @FXML
    private Label fullnamehome1;
    @FXML
    private Label fullnamehome2;
    @FXML
    private Label fullnamehome3;

    @FXML
    private Label gender;

    @FXML
    private SplitPane home;

    @FXML
    private AnchorPane homelogin;

    @FXML
    private Label id1;
    @FXML
    private Label id2;

    @FXML
    private Label idhome;

    @FXML
    private Label lastname;

    @FXML
    private AnchorPane lefthomepage;

    @FXML
    private AnchorPane leftprofil;

    @FXML
    private AnchorPane leftprofil1;

    @FXML
    private Button loginmessage;

    @FXML
    private Button modify_information;
    @FXML
    private Button previouspage;

    @FXML
    private Button savechanges;

    @FXML
    private SplitPane modifyhome;

    @FXML
    private PasswordField password;

    @FXML
    private ImageView personalPicture1;
    @FXML
    private ImageView personalPicture2;
    @FXML
    private ImageView personalPicture3;

    @FXML
    private Label phone;


    @FXML
    private Button profil;

    @FXML
    private SplitPane profilhome;

    @FXML
    private AnchorPane righthomepage;

    @FXML
    private AnchorPane rightprofil;

    @FXML
    private AnchorPane rightprofil1;

    @FXML
    private TextField username;
    @FXML
    private TextField inputaddress;

    @FXML
    private TextField inputdateofbirth;

    @FXML
    private TextField inputemail;

    @FXML
    private TextField inputphone;
    @FXML
    private ImageView personalPicture4;
    @FXML
    private Label fullnamehome4;
    @FXML
    private SplitPane modifyhomefinal;
    @FXML
    private VBox vboxorder;
    @FXML
    private ListView<order> listviewOrder;
    @FXML
    private ImageView notification1;
    @FXML
    private SplitPane notificationpage;
    @FXML
    private VBox pageorderdetails;
    @FXML
    private Label idcustomerdetails;
    @FXML
    private Label prodnamedetails;
    @FXML
    private Label quantitydetails;
    @FXML
    private Label pricedetails;
    @FXML
    private Label datedetails;
    @FXML
    private Label Numberofreleasedtables;

    @FXML
    private Label Numberofreservedtables;

    @FXML
    private Label totalnumberoftables;
    @FXML
    private TableColumn<TablesControl, Integer> Numplaces;

    @FXML
    private TableColumn<TablesControl, Integer> Numtable;

    @FXML
    private TableColumn<TablesControl, String> TableState;

    @FXML
    private TableView<TablesControl> tableviewControl;
    @FXML
    private Button ChangeStateoftable;
    @FXML
    private AnchorPane pagemodifcationtablestate;
    @FXML
    private SplitPane Controltablespage;
    @FXML
    private ChoiceBox<Integer> choicebox;
    @FXML
    private ChoiceBox<String> choicebox2;
    @FXML
    private Button Cancel;
    @FXML
    private Button Confirm;

    @FXML
    private AnchorPane Controltablespage2;
    @FXML
    private ChoiceBox<String> choiceAMPM;
    @FXML
    private RadioButton checkInRadioButton;

    @FXML
    private RadioButton checkOutRadioButton;
    @FXML
    private Button checkinoutSubmit;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField timeenter;
    @FXML
    private SplitPane pagecheckinout;
    @FXML
    private Button checkinout1;
    @FXML
    private Label idcheckinout;
    @FXML
    private Label lastnamecheck;
    @FXML
    private Label firstnamecheck;
    @FXML
    private ChoiceBox<String> choicetypereclamation;
    @FXML
    private Button uploadImageButton;

    @FXML
    private ImageView uploadedImageView;

    private String imagePath; // To store the path of the uploaded image
    @FXML
    private Button reclamationSubmit;
    @FXML
    private TextArea descriptionreclamation;
    @FXML
    private Button Complaintpage;
    @FXML
    private SplitPane PageComplaint;
    @FXML
    private Button buttontablecontrol;
    @FXML
    private Button buttonnotif2;
    @FXML
    private Button buttoncheckinout2;
    @FXML
    private Button buttontablecontrol2;
    @FXML
    private Button buttoncomplaint2;
    @FXML
    private Button button_notification3;
    @FXML
    private Button buttoncheck3;
    @FXML
    private Button buttonComplaint3;
    @FXML
    private Button buttonControls3;
    @FXML
    private Button buttonprofile4;
    @FXML
    private Button buttoncheck4;
    @FXML
    private Button buttonComplaint4;
    @FXML
    private Button buttonControls4;
    @FXML
    private Label numtablenotif;
    @FXML
    private HBox hboxorderdetails;
    @FXML
    private Button buttonnotif5;
    @FXML
    private Button buttoncheckinout5;
    @FXML
    private Button buttonComplaint5;
    @FXML
    private Button buttonprofile5;
    @FXML
    private Label fullnamehome5;
    @FXML
    private ImageView personalPicture5;
    @FXML
    private Button buttonnotif6;
    @FXML
    private Button buttonControls6;
    @FXML
    private Button buttonComplaint6;
    @FXML
    private Button buttonprofile6;
    @FXML
    private Label fullnamehome6;
    @FXML
    private ImageView personalPicture6;
    @FXML
    private Button buttonnotif7;
    @FXML
    private Button buttonControls7;
    @FXML
    private Button buttoncheckinout7;
    @FXML
    private Button buttonprofile7;
    @FXML
    private Label fullnamehome7;
    @FXML
    private ImageView personalPicture7;
    @FXML
    private Button btnCretenewAccount;
    @FXML
    private Button btnAlreadyHaveAnAccount;
    @FXML
    private AnchorPane sideform;
    @FXML
    private TextField createusername;
    @FXML
    private PasswordField createpassword;
    @FXML
    private PasswordField createpassconfirm;
    @FXML
    private Button btnchangepassword;
    @FXML
    private  HBox hbox1;
    @FXML
    private  HBox hbox2;
    @FXML
    private  HBox hbox3;
    @FXML
    private TextField inputoldpass;
    @FXML
    private TextField inputnewpass;
    @FXML
    private TextField inputconfirmnewpass;
    @FXML
    private Button logout1;
    @FXML
    private Button logout2;
    @FXML
    private Button logout3;
    @FXML
    private Button logout4;
    @FXML
    private Button logout5;
    @FXML
    private Button logout6;
    @FXML
    private Button logout7;



    public void switchprofil(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        if (event.getSource() == profil) {
            profilhome.setVisible(true);
            home.setVisible(false);

        } else if (event.getSource() == previouspage){
            profilhome.setVisible(true);
            modifyhome.setVisible(false);
        } else if (event.getSource()==button_notification) {
            notificationpage.setVisible(true);
            home.setVisible(false);
        } else if (event.getSource()==checkinout1) {
            home.setVisible(false);
            pagecheckinout.setVisible(true);
        } else if (event.getSource()==Complaintpage) {
            home.setVisible(false);
            PageComplaint.setVisible(true);

        }else if(event.getSource()==notification1){
            notificationpage.setVisible(true);
            home.setVisible(false);
        } else if (event.getSource()==buttontablecontrol) {
            Controltablespage.setVisible(true);
            home.setVisible(false);
        } else if (event.getSource()==buttonnotif2) {
            notificationpage.setVisible(true);
            profilhome.setVisible(false);
        }else if (event.getSource()==buttoncheckinout2) {
            pagecheckinout.setVisible(true);
            profilhome.setVisible(false);

        }else if (event.getSource()==buttoncomplaint2) {
            PageComplaint.setVisible(true);
            profilhome.setVisible(false);

        }else if (event.getSource()==buttontablecontrol2) {
            Controltablespage.setVisible(true);
            profilhome.setVisible(false);
        }else if (event.getSource() == modify_information) {
            modifyhome.setVisible(true);
            profilhome.setVisible(false);
        }else if (event.getSource() == button_notification3) {
            notificationpage.setVisible(true);
            modifyhome.setVisible(false);
        } else if (event.getSource() == buttoncheck3) {
            pagecheckinout.setVisible(true);
            modifyhome.setVisible(false);
        }
        else if (event.getSource() == buttonComplaint3) {
            PageComplaint.setVisible(true);
            modifyhome.setVisible(false);
        } else if (event.getSource() == buttonControls3) {
            Controltablespage.setVisible(true);
            modifyhome.setVisible(false);
        }else if (event.getSource() == modify_information) {
            modifyhome.setVisible(true);
            profilhome.setVisible(false);
        }  else if (event.getSource() == buttoncheck4) {
            pagecheckinout.setVisible(true);
            notificationpage.setVisible(false);
        }
        else if (event.getSource() == buttonComplaint4) {
            PageComplaint.setVisible(true);
            notificationpage.setVisible(false);
        } else if (event.getSource() == buttonControls4) {
            Controltablespage.setVisible(true);
            notificationpage.setVisible(false);
        }else if (event.getSource() == buttonprofile4) {
            profilhome.setVisible(true);
            notificationpage.setVisible(false);
        }
        else if (event.getSource() == buttonnotif5) {
            notificationpage.setVisible(true);
            Controltablespage.setVisible(false);
        }
        else if (event.getSource() == buttonComplaint5) {
            PageComplaint.setVisible(true);
            Controltablespage.setVisible(false);
        } else if (event.getSource() == buttoncheckinout5) {
            pagecheckinout.setVisible(true);
            Controltablespage.setVisible(false);
        }else if (event.getSource() == buttonprofile5) {
            profilhome.setVisible(true);
            Controltablespage.setVisible(false);
        }else if (event.getSource() == buttonnotif6) {
            notificationpage.setVisible(true);
            pagecheckinout.setVisible(false);
        }
        else if (event.getSource() == buttonComplaint6) {
            PageComplaint.setVisible(true);
            pagecheckinout.setVisible(false);
        } else if (event.getSource() == buttonControls6) {
            Controltablespage.setVisible(true);
            pagecheckinout.setVisible(false);
        }else if (event.getSource() == buttonprofile6) {
            profilhome.setVisible(true);
            pagecheckinout.setVisible(false);
        }else if (event.getSource() == buttonnotif7) {
            notificationpage.setVisible(true);
            PageComplaint.setVisible(false);
        }
        else if (event.getSource() == buttoncheckinout7) {
            PageComplaint.setVisible(true);
            PageComplaint.setVisible(false);
        } else if (event.getSource() == buttonControls7) {
            Controltablespage.setVisible(true);
            PageComplaint.setVisible(false);
        }else if (event.getSource() == buttonprofile7) {
            profilhome.setVisible(true);
            PageComplaint.setVisible(false);
        }else if (event.getSource()==btnCretenewAccount){
            slider.setNode(sideform);
            slider.setToX(350);
            slider.setDuration(Duration.seconds(.5));
            slider.setOnFinished((ActionEvent e) -> {
                btnCretenewAccount.setVisible(false);
                btnAlreadyHaveAnAccount.setVisible(true);
            });
            slider.play();

        }else if (event.getSource()==btnAlreadyHaveAnAccount) {
            slider.setNode(sideform);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));
            slider.setOnFinished((ActionEvent e) -> {
                btnAlreadyHaveAnAccount.setVisible(false);
                btnCretenewAccount.setVisible(true);
            });
            slider.play();
        }else if (event.getSource()==btnchangepassword){
            hbox1.setVisible(true);
            hbox2.setVisible(true);
            hbox3.setVisible(true);
        }else if (event.getSource()==logout1){
            home.setVisible(false);
            homelogin.setVisible(true);
        }
        else if (event.getSource()==logout2){
            profilhome.setVisible(false);
            homelogin.setVisible(true);
        }
        else if (event.getSource()==logout3){
            modifyhome.setVisible(false);
            homelogin.setVisible(true);
        }
        else if (event.getSource()==logout4){
            notificationpage.setVisible(false);
            homelogin.setVisible(true);
        }
        else if (event.getSource()==logout5){
            Controltablespage.setVisible(false);
            homelogin.setVisible(true);
        }
        else if (event.getSource()==logout6){
            pagecheckinout.setVisible(false);
            homelogin.setVisible(true);
        }
        else if (event.getSource()==logout7){
            PageComplaint.setVisible(false);
            homelogin.setVisible(true);
        }

    }


    //    login

    private Employe emp;
    private TablesControl table;
    private ToggleGroup toggleGroup;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emp = new Employe();
        showinformations();
        ObservableList<order> dataFromDatabase = FXCollections.observableArrayList(getOrdersFromDatabase());
        // Configure the ListView to display the data
        listviewOrder.setItems(dataFromDatabase);
        listviewOrder.setCellFactory(param -> new CustomCell());
        Numtable.setCellValueFactory(new PropertyValueFactory<>("numtab"));
        Numplaces.setCellValueFactory(new PropertyValueFactory<>("nbrplace"));
        TableState.setCellValueFactory(new PropertyValueFactory<>("etatab"));
        LoadTableControl();
        fillChoiceBoxFromDatabase(choicebox);
        fillCoiceBox2(choicebox2);
        TimeAmPm(choiceAMPM);
        toggleGroup = new ToggleGroup();
        checkInRadioButton.setToggleGroup(toggleGroup);
        checkOutRadioButton.setToggleGroup(toggleGroup);
        Choicetypereclamation(choicetypereclamation);

    }

    public void loginbutton(ActionEvent e) {
        if(e.getSource()==connectbuttom) {
            com.example.demo.database connectNow = new com.example.demo.database();
            Connection connectDB = connectNow.getConnection();

            String verifyLogin = "select * from employe where id_emp = '" + username.getText() + "' and password = '" + password.getText() + "'";
            try {
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);

                if (queryResult.next()) {
                    // Utilisateur authentifié
                    emp.setId(queryResult.getInt("id_emp"));
                    emp.setFirstName(queryResult.getString("first_name"));
                    emp.setlastname(queryResult.getString("last_name"));
                    emp.setGender(queryResult.getString("gender"));
                    emp.setPhone(queryResult.getString("phone"));
                    emp.setDateofbirth(queryResult.getString("date_naissance"));
                    emp.setAddress(queryResult.getString("address"));
                    emp.setEmail(queryResult.getString("email"));
                    emp.setPhoto(queryResult.getString("photo"));
                    emp.setPassword(queryResult.getString("password"));

                    home.setVisible(true);
                    homelogin.setVisible(false);
                    // Mise à jour des informations lors de l'authentification
                    showinformations();
                } else {
                    ShowAlert("Invalid username or password. Please try again");
                }
            } catch (Exception event) {
                event.printStackTrace();
            }

        }
    }
    public void SigneUpButton(){
        String userId = createusername.getText();
        String password = createpassword.getText();
        String confirmPassword = createpassconfirm.getText();
        com.example.demo.database connectNow = new com.example.demo.database();
        Connection connectDB = connectNow.getConnection();
        String sql = "SELECT COUNT(*) FROM employe WHERE id_emp = '" + userId + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);
            queryResult.next();
            int count = queryResult.getInt(1);
            if(count==1){
                if (password.equals(confirmPassword)) {
                    String sql2 = "UPDATE employe SET password = '" + password + "' WHERE id_emp = '" + userId + "'";
                    try {
                        Statement statement2 = connectDB.createStatement();
                        int rowsAffected = statement2.executeUpdate(sql2);
                    } catch (Exception event1) {
                        event1.printStackTrace();

                    }
                    ShowAlert("Account created successfully!");
                } else {
                    ShowAlert("Passwords do not match.");
                }
            }else{
                ShowAlert("User with ID " + userId + " does not exist.");
            }

        }catch (Exception event) {
            event.printStackTrace();
            ShowAlert("An error occurred while creating the account.");
        }
    }
    private void ShowAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void showinformations() {
        // Ne réinitialisez pas l'objet Employe ici
        id1.setText(Integer.toString(emp.getId()));
        id2.setText(Integer.toString(emp.getId()));
        firstname.setText(emp.getFirstname());
        lastname.setText(emp.getLastName());
        fullnamehome1.setText(emp.getLastName()+" "+emp.getFirstname());
        fullnamehome2.setText(emp.getLastName()+" "+emp.getFirstname());
        fullnamehome3.setText(emp.getLastName()+" "+emp.getFirstname());
        fullnamehome4.setText(emp.getLastName()+" "+emp.getFirstname());
        fullnamehome5.setText(emp.getLastName()+" "+emp.getFirstname());
        fullnamehome6.setText(emp.getLastName()+" "+emp.getFirstname());
        fullnamehome7.setText(emp.getLastName()+" "+emp.getFirstname());
        gender.setText(emp.getGender());
        address.setText(emp.getAddress());
        dateofbirth.setText(emp.getDateofbirth());
        phone.setText(emp.getPhone());
        email.setText(emp.getEmail());
        idcheckinout.setText(Integer.toString(emp.getId()));
        lastnamecheck.setText(emp.getLastName());
        firstnamecheck.setText(emp.getFirstname());
        System.out.println("wa l3adaw"+emp.getPhoto());
        if (emp.getPhoto() != null) {

            try (InputStream stream = new FileInputStream(emp.getPhoto())) {
                Image image = new Image(stream);
                personalPicture1.setImage(image);
                personalPicture2.setImage(image);
                personalPicture3.setImage(image);
                personalPicture4.setImage(image);
                personalPicture5.setImage(image);
                personalPicture6.setImage(image);
                personalPicture7.setImage(image);
            }catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Chemin d'accès à la photo est null.");
        }
        }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Set the background color to beige
        String beigeColor = "-fx-background-color: #F5F5DC;";
        alert.getDialogPane().setStyle(beigeColor);

        // Load the image
        Image image = new Image(this.getClass().getResource("verification2.png").toString());

        // Create an ImageView with the loaded image
        ImageView imageView = new ImageView(image);

        // Set the desired size of the ImageView
        imageView.setFitWidth(50);  // Set the width as needed
        imageView.setFitHeight(50); // Set the height as needed

        // Set the custom graphic
        alert.setGraphic(imageView);

        // Create custom buttons
        ButtonType homeButton = new ButtonType("Home Page", ButtonBar.ButtonData.OK_DONE);
        ButtonType backButton = new ButtonType("Go Back", ButtonBar.ButtonData.CANCEL_CLOSE);

        // Add custom buttons to the alert
        alert.getButtonTypes().setAll(homeButton, backButton);

        // Show the alert and wait for the user's choice
        Optional<ButtonType> result = alert.showAndWait();

        // Handle the button actions
        if (result.isPresent() && result.get() == homeButton) {
            home.setVisible(true);
            modifyhome.setVisible(false);

        } else if (result.isPresent() && result.get() == backButton) {
            profilhome.setVisible(true);
            modifyhome.setVisible(false);

        }
    }

    public void ModifyInformation(ActionEvent event) {
        if (event.getSource() == savechanges) {
            String Inputdateofbirth = inputdateofbirth.getText();
            String Inputaddress = inputaddress.getText();
            String Inputphone = inputphone.getText();
            String Inputemail = inputemail.getText();

            com.example.demo.database connectNow = new com.example.demo.database();
            Connection connectDB = connectNow.getConnection();
            String sql1 = "update employe set date_naissance = '" + Inputdateofbirth + "' ,address = '" + Inputaddress + "', phone = '" + Inputphone + "', email = '" + Inputemail +"', password = '" +inputnewpass.getText()+ "' where id_emp = '" + username.getText() + "'";
            try {
                if(inputoldpass.getText().equals(emp.getPassword())){
                    if(inputnewpass.getText().equals(inputconfirmnewpass.getText())){
                        Statement statement = connectDB.createStatement();
                        int rowsAffected = statement.executeUpdate(sql1);
                        if (rowsAffected > 0) {
                            showAlert("Success", "\t\t\tGreat!\nYour changes have been successfuly saved");
                            String verifyLogin = "select * from employe where id_emp = '" + username.getText() + "'";
                            try {
                                ResultSet queryResult = statement.executeQuery(verifyLogin);
                                if (queryResult.next()) {
                                    emp.setPhone(queryResult.getString("phone"));
                                    emp.setDateofbirth(queryResult.getString("date_naissance"));
                                    emp.setAddress(queryResult.getString("address"));
                                    emp.setEmail(queryResult.getString("email"));
                                    emp.setPassword(queryResult.getString("password"));
                                }
                            } catch (Exception event1) {
                                event1.printStackTrace();
                            }
                            showinformations();
                        }
                    }else{
                        ShowAlert("Passwords do not match.");
                    }

                }else {
                    ShowAlert("the old password you entered is incorrect");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static List<order> getOrdersFromDatabase() {
        com.example.demo.database connectNow = new com.example.demo.database();
        Connection connectDB = connectNow.getConnection();
        String orderListQuery = "SELECT * FROM customer where checkBox!='take it'";
        List<order> orders = new ArrayList<>();

        try (
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(orderListQuery)
        ) {
            while (queryResult.next()) {
                order Order = new order();
                Order.setOrderId(queryResult.getInt("id"));
                Order.setCustomerId(queryResult.getInt("customer_id"));
                Order.setProduitname(queryResult.getString("prod_name"));
                Order.setProduitId(queryResult.getString("prod_id"));
                Order.setQuantity(queryResult.getInt("quantity"));
                Order.setPrice(queryResult.getDouble("price"));
                Order.setDateOrder(queryResult.getString("date"));
                Order.setTypeProduit(queryResult.getString("type"));
                Order.setNumtable(queryResult.getString("checkBox"));
                orders.add(Order);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connectDB != null) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orders;
    }



    public class CustomCell extends ListCell<order> {
        private HBox content;

        public CustomCell() {
            content = new HBox();
            content.setSpacing(0);
        }

        @Override
        protected void updateItem(order item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setGraphic(null);
            } else {
                Circle circle = new Circle(20, Color.BEIGE);
                Text text = new Text(String.valueOf(item.getCustomerId()));
                Group group = new Group(circle, text);
                text.setX(circle.getCenterX() - text.getBoundsInLocal().getWidth() / 2);
                text.setY(circle.getCenterY() + text.getBoundsInLocal().getHeight() / 4);

                Button button = new Button("#Order Number: " + item.getOrderId()+ " #Product ID: " + item.getProduitId());
                content.setMargin(button, new Insets(5, 0, 0, 0)); // Marges (haut, droite, bas, gauche)
                button.setPrefWidth(230);  // Largeur préférée
                button.setPrefHeight(30);  // Hauteur préférée
                button.setStyle(
                        "-fx-background-color: transparent; " +
                                "-fx-border-color: transparent; " +
                                "-fx-border-width: 0px;");
                button.setOnAction(event -> {
                    hboxorderdetails.getChildren().clear();
                    pageorderdetails.setVisible(true);
                    idcustomerdetails.setText(Integer.toString(item.getCustomerId()));
                    prodnamedetails.setText(item.getProduitname());
                    quantitydetails.setText(Integer.toString(item.getQuantity()));
                    pricedetails.setText(Double.toString(item.getPrice()));
                    datedetails.setText(item.getDateOrder());
                    numtablenotif.setText(item.getnumtable());

                    Button confirmationbutt = new Button("Confirm");
                    confirmationbutt.setTextFill(Color.BEIGE);
                    confirmationbutt.setPrefWidth(120);  // Largeur préférée
                    confirmationbutt.setPrefHeight(60);  // Hauteur préférée
                    confirmationbutt.setStyle(
                            "-fx-background-color: #436e47; " +
                                    "-fx-border-color: transparent; " +
                                    "-fx-border-width: 0px;" +
                                    "-fx-border-radius: 10px;"+
                                    "-fx-font-size:16px;"
                    );
                    hboxorderdetails.getChildren().add(confirmationbutt);
                    hboxorderdetails.setMargin(confirmationbutt, new Insets(0, 0, 20, 40));
                    confirmationbutt.setOnAction(e -> {
                        confirmationbutt.setDisable(true);
                        circle.setFill(Color.web("#436e47"));

                    });
                });

                content.getChildren().setAll( group,button);
                setGraphic(content);
            }
        }
    }


    private void LoadTableControl() {
        ObservableList<TablesControl> data = FXCollections.observableArrayList();
        com.example.demo.database connectNow = new com.example.demo.database();
        Connection connectDB = connectNow.getConnection();

        String sqlrequete = "select * from `table` ";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sqlrequete);

            while (queryResult.next()) {
                TablesControl table = new TablesControl();  // Créez une nouvelle instance pour chaque ligne
                table.setNumtab(queryResult.getInt("Numtab"));
                table.setNbrplace(queryResult.getInt("nbreDePlace"));
                table.setEtatab(queryResult.getString("etat"));
                data.add(table);
            }
            tableviewControl.setItems(data);
            int rowCount = tableviewControl.getItems().size();
            totalnumberoftables.setText(Integer.toString(rowCount));

            String reserveQuery = "SELECT COUNT(*) FROM `table` WHERE etat = 'reserve'";
            Statement reserveStatement = connectDB.createStatement();
            ResultSet reserveResult = reserveStatement.executeQuery(reserveQuery);
            if (reserveResult.next()) {
                int reserveCount = reserveResult.getInt(1);
                Numberofreservedtables.setText(Integer.toString(reserveCount));
            }

            // Compter le nombre de lignes avec l'état 'release'
            String releaseQuery = "SELECT COUNT(*) FROM `table` WHERE etat = 'release'";
            Statement releaseStatement = connectDB.createStatement();
            ResultSet releaseResult = releaseStatement.executeQuery(releaseQuery);
            if (releaseResult.next()) {
                int releaseCount = releaseResult.getInt(1);
                Numberofreleasedtables.setText(Integer.toString(releaseCount));
            }
        } catch (Exception event) {
            event.printStackTrace();
        }
    }

    public void TableviewControl(ActionEvent event){
        if (event.getSource()==ChangeStateoftable){
            Controltablespage2.setVisible(true);
        }
    }

    public void fillChoiceBoxFromDatabase(ChoiceBox<Integer> Choicebox) {
        com.example.demo.database connectNow = new com.example.demo.database();
        Connection connectDB = connectNow.getConnection();
        String sqlrequete = "select * from `table` ";
        try  {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sqlrequete);
            ObservableList<Integer> options = FXCollections.observableArrayList();
            while (queryResult.next()) {
                Integer value = queryResult.getInt("Numtab");
                options.add(value);
            }
            Choicebox.setItems(options);
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void fillCoiceBox2(ChoiceBox<String> Choicebox){
        ObservableList<String> options = FXCollections.observableArrayList();
        options.add("release");
        options.add("reserve");
        Choicebox.setItems(options);
    }
    public void TimeAmPm(ChoiceBox<String> Choicebox){
        ObservableList<String> options = FXCollections.observableArrayList();
        options.add("AM");
        options.add("PM");
        Choicebox.setItems(options);
    }
    public void confirmcancelTablesControl(ActionEvent event){
        if (event.getSource()==Confirm){
            com.example.demo.database connectNow = new com.example.demo.database();
            Connection connectDB = connectNow.getConnection();
            String sql1 = "update `table` set etat = '" + choicebox2.getValue() + "' where Numtab = '" + choicebox.getValue()+"'";
            try {
                Statement statement = connectDB.createStatement();
                int rowsAffected = statement.executeUpdate(sql1);
            }catch (Exception event1) {
                        event1.printStackTrace();
            }
            LoadTableControl();
            Controltablespage2.setVisible(false);
        }else if (event.getSource()==Cancel){
            Controltablespage2.setVisible(false);
        }
    }
    private void showAlert2(String title, String message, SplitPane pagename) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Set the background color to beige
        String beigeColor = "-fx-background-color:  #F5F5DC;";
        alert.getDialogPane().setStyle(beigeColor);

        // Load the image
        Image image = new Image(this.getClass().getResource("verification2.png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);  // Set the width as needed
        imageView.setFitHeight(50); // Set the height as needed
        alert.setGraphic(imageView);
        ButtonType homeButton = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(homeButton);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == homeButton) {
            pagename.setVisible(true);
        }
    }
    public void submitcheckinout(ActionEvent event){
        if (event.getSource()==checkinoutSubmit) {
            LocalDate selectedDate = datePicker.getValue();
            String selecttime = timeenter.getText();
            String selectampm = choiceAMPM.getValue();
            String time = selecttime+" "+selectampm;

            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                String selectedText = selectedRadioButton.getText();
                com.example.demo.database connectNow = new com.example.demo.database();
                Connection connectDB = connectNow.getConnection();
                if ("Check In".equals(selectedText)){
                    String sqlInsertCheckin = "INSERT INTO checkinout (id, first_name, last_name, timeofcheckin, date) VALUES ('"
                            + emp.getId() + "', '" + emp.getFirstname() + "', '" + emp.getLastName() + "', '" + time + "', '" + selectedDate + "')";

                    try {
                        Statement statement = connectDB.createStatement();
                        int rowsAffected = statement.executeUpdate(sqlInsertCheckin);
                            } catch (Exception event1) {
                                event1.printStackTrace();
                    }
            }else{
                    String sql1 = "update checkinout set timeofcheckout = '" + time + "'where id = '" + emp.getId() + "'";
                    try {
                        Statement statement = connectDB.createStatement();
                        int rowsAffected = statement.executeUpdate(sql1);
                    } catch (Exception event1) {
                        event1.printStackTrace();

                }
            }
        }
            showAlert2("Success", "\t\t\tWell done!\nyour information saved successfully",pagecheckinout);

        }}


    public void Choicetypereclamation(ChoiceBox<String> Choicebox){
        ObservableList<String> options = FXCollections.observableArrayList();
        options.add("Quality Issue (quality of products or services provided:problems with taste, freshness,etc)");
        options.add("Service Complaint (negative experiences related to customer service,slow service,order errors,etc)");
        options.add("Facility Issue (physical facilities: cleanliness problems,breakages,malfunctions of equipment,etc)");
        options.add("Billing Inquiry (billing errors, unexpected charges, etc)");
        options.add("Staff Behavior:negative interactions, rude behaviors, unprofessional attitudes,etc");
        options.add("Other(use this option if your complaint doesn't match any specific category)");
        Choicebox.setItems(options);
    }
    @FXML
    void handleUploadImageButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Image");
        Stage stage = (Stage) uploadImageButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            imagePath = selectedFile.getAbsolutePath();
            Image image = new Image("file:" + imagePath);
            uploadedImageView.setImage(image);
        }
    }

public void submitreclamation(ActionEvent event) {
    if (event.getSource() == reclamationSubmit) {
        com.example.demo.database connectNow = new com.example.demo.database();
        Connection connectDB = connectNow.getConnection();
        if (imagePath != null) {
            String sqlInsert = "INSERT INTO reclamation (id, type, description, image) VALUES (?, ?, ?, ?)";

            try {
                PreparedStatement preparedStatement = connectDB.prepareStatement(sqlInsert);
                preparedStatement.setString(1, Integer.toString(emp.getId()));
                preparedStatement.setString(2, choicetypereclamation.getValue());
                preparedStatement.setString(3, descriptionreclamation.getText());
                preparedStatement.setString(4, imagePath);

                int rowsAffected = preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            String sqlInsert = "INSERT INTO reclamation (id, type, description) VALUES (?, ?, ?)";

            try {
                PreparedStatement preparedStatement = connectDB.prepareStatement(sqlInsert);
                preparedStatement.setString(1, Integer.toString(emp.getId()));
                preparedStatement.setString(2, choicetypereclamation.getValue());
                preparedStatement.setString(3, descriptionreclamation.getText());
                int rowsAffected = preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        showAlert2("Success", "\t\t\tWell done!\nyour complaint has been successfully registered",PageComplaint);


    }
}
}










