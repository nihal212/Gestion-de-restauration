package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController3 implements Initializable
{

    @FXML
    private AnchorPane main_form;


    @FXML
    private Button addEmployee_addBtn;

    @FXML
    private TextField addEmployee_adress;

    @FXML
    private Button addEmployee_btn;

    @FXML
    private Button addEmployee_clearBtn;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_adress;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_date;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_email;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_employeeID;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_firstName;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_gender;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_lastName;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_phoneNum;

    @FXML
    private TextField addEmployee_date;

    @FXML
    private Button addEmployee_deleteBtn;

    @FXML
    private TextField addEmployee_email;

    @FXML
    private TextField addEmployee_employeeID;

    @FXML
    private TextField addEmployee_firstName;

    @FXML
    private AnchorPane addEmployee_form;

    @FXML
    private ComboBox<?> addEmployee_gender;

    @FXML
    private ImageView addEmployee_image;

    @FXML
    private Button addEmployee_importBtn;

    @FXML
    private TextField addEmployee_lastName;

    @FXML
    private TextField addEmployee_phoneNum;

    @FXML
    private TextField addEmployee_search;

    @FXML
    private TableView<employeeData> addEmployee_tableView;

    @FXML
    private Button addEmployee_updateBtn;

    @FXML
    private Button close;

    @FXML
    private Button home_btn;

    @FXML
    private BarChart<?, ?> home_chart;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEmployees;

    @FXML
    private Label home_totalInactiveEm;

    @FXML
    private Label home_totalPresents;

    @FXML
    private Button logout;

    @FXML
    private Button menu_btn;

    @FXML
    private Button minimize;

    @FXML
    private Button salary_btn;

    @FXML
    private Button salary_clearBtn;

    @FXML
    private TableColumn<employeeData, String> salary_col_employeeID;

    @FXML
    private TableColumn<employeeData, String> salary_col_firstName;

    @FXML
    private TableColumn<employeeData, String> salary_col_lastName;

    @FXML
    private TableColumn<employeeData, String> salary_col_phone;

    @FXML
    private TableColumn<employeeData, String> salary_col_salary;

    @FXML
    private TextField salary_employeeID;

    @FXML
    private Label salary_firstName;

    @FXML
    private AnchorPane salary_form;

    @FXML
    private Label salary_lastName;

    @FXML
    private Label salary_phone;

    @FXML
    private TextField salary_salary;

    @FXML
    private TableView<employeeData> salary_tableView;

    @FXML
    private Button salary_updateBtn;

    @FXML
    private AnchorPane inventory_form;
    @FXML
    private TableView<ProductData1> inventory_tableView;
    @FXML
    private TableColumn<ProductData1, String> inventory_col_productID;

    @FXML
    private TableColumn<ProductData1, String> inventory_col_productName;
    @FXML
    private TableColumn<ProductData1, String> inventory_col_type;
    @FXML
    private TableColumn<ProductData1, String> inventory_col_stock;
    @FXML
    private TableColumn<ProductData1, String> inventory_col_price;
    @FXML
    private TableColumn<ProductData1, String> inventory_col_status;
    @FXML
    private TableColumn<ProductData1, String> inventory_col_date;
    @FXML
    private Button inventory_addBtn;
    @FXML
    private Button inventory_clearBtn;
    @FXML
    private Button inventory_deleteBtn;
    @FXML
    private Button inventory_updateBtn;
    @FXML
    private ImageView inventory_imageView;
    @FXML
    private Button inventory_importBtn;
    @FXML
    private TextField inventory_productID;

    @FXML
    private TextField inventory_productName;
    @FXML
    private ComboBox<?> inventory_type;
    @FXML
    private TextField inventory_stock;
    @FXML
    private TextField inventory_price;
    @FXML
    private ComboBox<?> inventory_status;


    @FXML
    private Label username;

    private Alert alert;
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    private Image image;

    public void homeTotalEmployees() {

        String sql = "SELECT COUNT(id) FROM empll";

        connect = database.getConnection();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }

            home_totalEmployees.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void homeEmployeeTotalPresent() {

        String sql = "SELECT COUNT(id) FROM employee_info WHERE salary != '0.0'";

        connect = database.getConnection();
        int countData = 0;
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }
            home_totalPresents.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeTotalInactive() {

        String sql = "SELECT COUNT(id) FROM employee_info WHERE salary = '0.0'";

        connect = database.getConnection();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }
            home_totalInactiveEm.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void homeChart() {

        home_chart.getData().clear();

        String sql = "SELECT salary, COUNT(id) FROM employee_info GROUP BY salary ORDER BY salary ASC LIMIT 7";

        connect = database.getConnection();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addEmployeeAdd() {

        //Date date = new Date();
        //java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "INSERT INTO empll "
                + "(id_emp,first_name,last_name,gender,phone,address,email,date_naissance,photo) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        connect = database.getConnection();

        try {
            Alert alert;
            if (addEmployee_employeeID.getText().isEmpty()
                    || addEmployee_firstName.getText().isEmpty()
                    || addEmployee_lastName.getText().isEmpty()
                    || addEmployee_gender.getSelectionModel().getSelectedItem() == null
                    || addEmployee_phoneNum.getText().isEmpty()
                    || addEmployee_adress.getText().isEmpty()
                    || addEmployee_email.getText().isEmpty()
                    || addEmployee_date.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                String check = "SELECT id_emp FROM empll WHERE id_emp = '"
                        + addEmployee_employeeID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee ID: " + addEmployee_employeeID.getText() + " was already exist!");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addEmployee_employeeID.getText());
                    prepare.setString(2, addEmployee_firstName.getText());
                    prepare.setString(3, addEmployee_lastName.getText());
                    prepare.setString(4, (String) addEmployee_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(5, addEmployee_phoneNum.getText());
                    prepare.setString(6, addEmployee_adress.getText());
                    prepare.setString(7, addEmployee_email.getText());
                    prepare.setString(8, addEmployee_date.getText());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");

                    prepare.setString(9, uri);
                    //prepare.setString(8, String.valueOf(sqlDate));
                    prepare.executeUpdate();

                    String insertInfo = "INSERT INTO employee_info "
                            + "(id_emp,first_name,last_name,phone,salary) "
                            + "VALUES(?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertInfo);
                    prepare.setString(1, addEmployee_employeeID.getText());
                    prepare.setString(2, addEmployee_firstName.getText());
                    prepare.setString(3, addEmployee_lastName.getText());
                    prepare.setString(4, addEmployee_phoneNum.getText());
                    prepare.setString(5, "0.0");

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void addEmployeeUpdate() {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        //Date date = new Date();
        //java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "UPDATE empll SET first_name = '"
                + addEmployee_firstName.getText() + "', last_name = '"
                + addEmployee_lastName.getText() + "', gender = '"
                + addEmployee_gender.getSelectionModel().getSelectedItem() + "', phone = '"
                + addEmployee_phoneNum.getText() + "', address = '"
                + addEmployee_adress.getText() + "', email = '"
                + addEmployee_email.getText() + "', date_naissance = '"
                + addEmployee_date.getText() + "', photo = '"
                +uri+"'WHERE id_emp='"
                + addEmployee_employeeID.getText() + "'";

        connect = database.getConnection();

        try {
            Alert alert;
            if (addEmployee_employeeID.getText().isEmpty()
                    || addEmployee_firstName.getText().isEmpty()
                    || addEmployee_lastName.getText().isEmpty()
                    || addEmployee_gender.getSelectionModel().getSelectedItem() == null
                    || addEmployee_phoneNum.getText().isEmpty()
                    || addEmployee_adress.getText().isEmpty()
                    || addEmployee_email.getText().isEmpty()
                    || addEmployee_date.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Employee ID: " + addEmployee_employeeID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    double salary = 0;

                    String checkData = "SELECT * FROM employee_info WHERE id_emp = '"
                            + addEmployee_employeeID.getText() + "'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();

                    while (result.next()) {
                        salary = result.getDouble("salary");
                    }

                    String updateInfo = "UPDATE employee_info SET first_name = '"
                            + addEmployee_firstName.getText() + "', last_name = '"
                            + addEmployee_lastName.getText() + "', phone = '"
                            + addEmployee_phoneNum.getText()
                            + "' WHERE id_emp = '"
                            + addEmployee_employeeID.getText() + "'";

                    prepare = connect.prepareStatement(updateInfo);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addEmployeeDelete() {

        String sql = "DELETE FROM empll WHERE id_emp = '"
                + addEmployee_employeeID.getText() + "'";

        connect = database.getConnection();

        try {

            Alert alert;
            if (addEmployee_employeeID.getText().isEmpty()
                    || addEmployee_firstName.getText().isEmpty()
                    || addEmployee_lastName.getText().isEmpty()
                    || addEmployee_gender.getSelectionModel().getSelectedItem() == null
                    || addEmployee_phoneNum.getText().isEmpty()
                    || addEmployee_adress.getText().isEmpty()
                    || addEmployee_email.getText().isEmpty()
                    || addEmployee_date.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Employee ID: " + addEmployee_employeeID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    String deleteInfo = "DELETE FROM employee_info WHERE id_emp = '"
                            + addEmployee_employeeID.getText() + "'";

                    prepare = connect.prepareStatement(deleteInfo);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void addEmployeeReset() {
        addEmployee_employeeID.setText("");
        addEmployee_firstName.setText("");
        addEmployee_lastName.setText("");
        addEmployee_gender.getSelectionModel().clearSelection();
        addEmployee_phoneNum.setText("");
        addEmployee_adress.setText("");
        addEmployee_email.setText("");
        addEmployee_date.setText("");
        addEmployee_image.setImage(null);
        getData.path = "";
    }

    public void addEmployeeInsertImage() {

        FileChooser open = new FileChooser();
        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            getData.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 101, 127, false, true);
            addEmployee_image.setImage(image);
        }
    }

    private String[] listGender = {"Male", "Female", "Others"};

    public void addEmployeeGendernList() {
        List<String> listG = new ArrayList<>();

        for (String data : listGender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        addEmployee_gender.setItems(listData);
    }



    public void addEmployeeSearch() {

        FilteredList<employeeData> filter = new FilteredList<>(addEmployeeList, e -> true);

        addEmployee_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateEmployeeData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateEmployeeData.getEmployeeId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getPhoneNum().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getAddress().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateEmployeeData.getEmail().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getDate().contains(searchKey)) {
                    return true;
                } else return false;

            });
        });

        SortedList<employeeData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addEmployee_tableView.comparatorProperty());
        addEmployee_tableView.setItems(sortList);
    }

    public ObservableList<employeeData> addEmployeeListData() {

        ObservableList<employeeData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM empll";

        connect = database.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            employeeData employeeD;

            while (result.next()) {
                employeeD = new employeeData(result.getInt("id_emp"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("gender"),
                        result.getString("phone"),
                        result.getString("address"),
                        result.getString("email"),
                        result.getString("photo"),
                        result.getString("date_naissance"));
                listData.add(employeeD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<employeeData> addEmployeeList;
    public void addEmployeeShowListData() {
        addEmployeeList = addEmployeeListData();

        addEmployee_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        addEmployee_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addEmployee_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addEmployee_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addEmployee_col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        addEmployee_col_adress.setCellValueFactory(new PropertyValueFactory<>("address"));
        addEmployee_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        addEmployee_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addEmployee_tableView.setItems(addEmployeeList);

    }

    public void addEmployeeSelect() {
        employeeData employeeD = addEmployee_tableView.getSelectionModel().getSelectedItem();
        int num = addEmployee_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addEmployee_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
        addEmployee_firstName.setText(employeeD.getFirstName());
        addEmployee_lastName.setText(employeeD.getLastName());
        addEmployee_phoneNum.setText(employeeD.getPhoneNum());
        addEmployee_adress.setText(employeeD.getAddress());
        addEmployee_email.setText(employeeD.getEmail());
        addEmployee_date.setText(employeeD.getDate());
        getData.path = employeeD.getImage();

        String uri = "file:" + employeeD.getImage();

        image = new Image(uri, 116, 147, false, true);
        addEmployee_image.setImage(image);
    }

    public void salaryUpdate() {

        String sql = "UPDATE employee_info SET salary = '" + salary_salary.getText()
                + "' WHERE id_emp = '" + salary_employeeID.getText() + "'";

        connect = database.getConnection();

        try {
            Alert alert;

            if (salary_employeeID.getText().isEmpty()
                    || salary_firstName.getText().isEmpty()
                    || salary_lastName.getText().isEmpty()
                    || salary_phone.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select item first");
                alert.showAndWait();
            } else {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                salaryShowListData();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salaryReset() {
        salary_employeeID.setText("");
        salary_firstName.setText("");
        salary_lastName.setText("");
        salary_phone.setText("");
        salary_salary.setText("");
    }

    public ObservableList<employeeData> salaryListData() {

        ObservableList<employeeData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM employee_info";

        connect = database.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            employeeData employeeD;

            while (result.next()) {
                employeeD = new employeeData(result.getInt("id_emp"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("phone"),
                        result.getDouble("salary"));

                listData.add(employeeD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<employeeData> salaryList;

    public void salaryShowListData() {
        salaryList = salaryListData();

        salary_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        salary_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        salary_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        salary_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        salary_col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        salary_tableView.setItems(salaryList);

    }

    public void salarySelect() {

        employeeData employeeD = salary_tableView.getSelectionModel().getSelectedItem();
        int num = salary_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        salary_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
        salary_firstName.setText(employeeD.getFirstName());
        salary_lastName.setText(employeeD.getLastName());
        salary_phone.setText(employeeD.getPhoneNum());
        salary_salary.setText(String.valueOf(employeeD.getSalary()));

    }
    public void defaultNav() {
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ff3547, #ff3547);");
    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    public void inventoryAddBtn() {

        if (inventory_productID.getText().isEmpty()
                || inventory_productName.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null
                || inventory_stock.getText().isEmpty()
                || inventory_price.getText().isEmpty()
                || inventory_status.getSelectionModel().getSelectedItem() == null
                || getData.path == null) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {

            // CHECK PRODUCT ID
            String checkProdID = "SELECT prod_id FROM product WHERE prod_id = '"
                    + inventory_productID.getText() + "'";

            connect = database.getConnection();

            try {


                statement = connect.createStatement();
                result = statement.executeQuery(checkProdID);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(inventory_productID.getText() + " is already taken");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, type, stock, price, status, image, date) "
                            + "VALUES(?,?,?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, inventory_productID.getText());
                    prepare.setString(2, inventory_productName.getText());
                    prepare.setString(3, (String) inventory_type.getSelectionModel().getSelectedItem());
                    prepare.setString(4, inventory_stock.getText());
                    prepare.setString(5, inventory_price.getText());
                    prepare.setString(6, (String) inventory_status.getSelectionModel().getSelectedItem());

                    String path = getData.path;
                    path = path.replace("\\", "\\\\");

                    prepare.setString(7, path);

                    // TO GET CURRENT DATE
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(8, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    inventoryShowData();
                    inventoryClearBtn();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inventoryUpdateBtn() {

        if (inventory_productID.getText().isEmpty()
                || inventory_productName.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null
                || inventory_stock.getText().isEmpty()
                || inventory_price.getText().isEmpty()
                || inventory_status.getSelectionModel().getSelectedItem() == null
                || getData.path == null || getData.id == 0) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {

            String path = getData.path;
            path = path.replace("\\", "\\\\");

            String updateData = "UPDATE product SET "
                    + "prod_id = '" + inventory_productID.getText() + "', prod_name = '"
                    + inventory_productName.getText() + "', type = '"
                    + inventory_type.getSelectionModel().getSelectedItem() + "', stock = '"
                    + inventory_stock.getText() + "', price = '"
                    + inventory_price.getText() + "', status = '"
                    + inventory_status.getSelectionModel().getSelectedItem() + "', image = '"
                    + path + "', date = '"
                    + getData.date + "' WHERE id = " + getData.id;

            connect = database.getConnection();

            try {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE PRoduct ID: " + inventory_productID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE YOUR TABLE VIEW
                    inventoryShowData();
                    // TO CLEAR YOUR FIELDS
                    inventoryClearBtn();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inventoryDeleteBtn() {
        if (getData.id == 0) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Product ID: " + inventory_productID.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                String deleteData = "DELETE FROM product WHERE id = " + getData.id;
                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("successfully Deleted!");
                    alert.showAndWait();

                    // TO UPDATE YOUR TABLE VIEW
                    inventoryShowData();
                    // TO CLEAR YOUR FIELDS
                    inventoryClearBtn();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();
            }
        }
    }

    public void inventoryClearBtn() {

        inventory_productID.setText("");
        inventory_productName.setText("");
        inventory_type.getSelectionModel().clearSelection();
        inventory_stock.setText("");
        inventory_price.setText("");
        inventory_status.getSelectionModel().clearSelection();
        getData.path = "";
        getData.id = 0;
        inventory_imageView.setImage(null);

    }

    // LETS MAKE A BEHAVIOR FOR IMPORT BTN FIRST
    public void inventoryImportBtn() {

        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new ExtensionFilter("Open Image File", "*png", "*jpg"));

        File file = openFile.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            getData.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 135, 139, false, true);

            inventory_imageView.setImage(image);
        }
    }


    // MERGE ALL DATAS
    public ObservableList<ProductData1> inventoryDataList() {

        ObservableList<ProductData1> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM product";


        connect = database.getConnection();
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ProductData1 prodData;

            while (result.next()) {

                prodData = new ProductData1(result.getInt("id"),
                                result.getString("prod_id"),
                                result.getString("prod_name"),
                                result.getString("type"),
                                result.getInt("stock"),
                                result.getDouble("price"),
                                result.getString("status"),
                                result.getString("image"),
                                result.getDate("date"));



                listData.add(prodData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    // TO SHOW DATA ON OUR TABLE
    private ObservableList<ProductData1> inventoryListData;

    public void inventoryShowData() {
        inventoryListData = inventoryDataList();

        inventory_col_productID.setCellValueFactory(new PropertyValueFactory<>("productId"));
        inventory_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        inventory_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        inventory_col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventory_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        inventory_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        inventory_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        inventory_tableView.setItems(inventoryListData);

    }

    public void inventorySelectData() {

        ProductData1 prodData = inventory_tableView.getSelectionModel().getSelectedItem();
        int num = inventory_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        inventory_productID.setText(prodData.getProductId());
        inventory_productName.setText(prodData.getProductName());
        inventory_stock.setText(String.valueOf(prodData.getStock()));
        inventory_price.setText(String.valueOf(prodData.getPrice()));

        getData.path = prodData.getImage();

        String path = "File:" + prodData.getImage();
        getData.date = String.valueOf(prodData.getDate());
        getData.id = prodData.getId();

        image = new Image(path, 135, 139, false, true);
        inventory_imageView.setImage(image);
    }


    private String[] typeList = {"dishes", "soup","fast_food", "drinks", "others"};

    public void inventoryTypeList() {

        List<String> typeL = new ArrayList<>();

        for (String data : typeList) {
            typeL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(typeL);
        inventory_type.setItems(listData);
    }

    private String[] statusList = {"Available", "Unavailable"};

    public void inventoryStatusList() {

        List<String> statusL = new ArrayList<>();

        for (String data : statusList) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(statusL);
        inventory_status.setItems(listData);

    }
    public void switchForm(ActionEvent event) {

        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            addEmployee_form.setVisible(false);
            salary_form.setVisible(false);
            inventory_form.setVisible(false);

            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ff3547, #ff3547);");
            addEmployee_btn.setStyle("-fx-background-color:transparent");
            salary_btn.setStyle("-fx-background-color:transparent");
            menu_btn.setStyle("-fx-background-color:transparent");

            homeTotalEmployees();
            homeEmployeeTotalPresent();
            homeTotalInactive();
            homeChart();

        }else if (event.getSource() == addEmployee_btn) {
            home_form.setVisible(false);
            addEmployee_form.setVisible(true);
            salary_form.setVisible(false);
            inventory_form.setVisible(false);


            addEmployee_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ff3547, #ff3547);");
            home_btn.setStyle("-fx-background-color:transparent");
            salary_btn.setStyle("-fx-background-color:transparent");
            menu_btn.setStyle("-fx-background-color:transparent");

            addEmployeeGendernList();
            addEmployeeSearch();

        } else if (event.getSource() == salary_btn) {
            home_form.setVisible(false);
            addEmployee_form.setVisible(false);
            salary_form.setVisible(true);
            inventory_form.setVisible(false);


            salary_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ff3547, #ff3547);");
            addEmployee_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            menu_btn.setStyle("-fx-background-color:transparent");

            salaryShowListData();

        }else if (event.getSource() == menu_btn) {
            home_form.setVisible(false);
            addEmployee_form.setVisible(false);
            salary_form.setVisible(false);
            inventory_form.setVisible(true);


            menu_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ff3547, #ff3547);");
            home_btn.setStyle("-fx-background-color:transparent");
            addEmployee_btn.setStyle("-fx-background-color:transparent");
            salary_btn.setStyle("-fx-background-color:transparent");



        }

    }
    private double x = 0;
    private double y = 0;
    public void logout() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {
                //hide the MAIN form
                logout.getScene().getWindow().hide();
                //link your login form and show it
                Parent root = FXMLLoader.load(getClass().getResource("firstpage.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsername();
        inventoryTypeList();
        inventoryStatusList();
        inventoryShowData();

        defaultNav();
        homeTotalEmployees();
        homeEmployeeTotalPresent();
        homeTotalInactive();
        homeChart();


        addEmployeeShowListData();
        addEmployeeGendernList();
        salaryShowListData();
    }
}