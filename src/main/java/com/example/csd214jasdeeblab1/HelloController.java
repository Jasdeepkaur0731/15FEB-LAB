package com.example.csd214jasdeeblab1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
public class HelloController implements Initializable {
    @FXML
    private TableView<Table> tableView;
    @FXML
    private TableColumn<Table, Integer> ID;
    @FXML
    private TableColumn<Table, String> Name;
    @FXML
    private TableColumn<Table, String> Subject;
    @FXML
    private TableColumn<Table, Integer> ExaminationHall;
    ObservableList<Table> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new
                PropertyValueFactory<Table, Integer>("ID"));
        Name.setCellValueFactory(new
                PropertyValueFactory<Table, String>("Name"));
        Subject.setCellValueFactory(new
                PropertyValueFactory<Table, String>("Subject"));
        ExaminationHall.setCellValueFactory(new
                PropertyValueFactory<Table, Integer>("ExaminationHall"));
        tableView.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }

    public void populateTable() {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab1";
        String dbUser = "root";


        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM `Table`";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String Name = resultSet.getString("Name");
                String Subject = resultSet.getString("Subject");
                int ExaminationHall = resultSet.getInt("ExaminationHall");
                tableView.getItems().add(new Table(ID, Name, Subject, ExaminationHall));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}