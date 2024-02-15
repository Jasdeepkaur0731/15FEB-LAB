module com.example.csd214jasdeeblab1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.csd214jasdeeblab1 to javafx.fxml;
    exports com.example.csd214jasdeeblab1;
}