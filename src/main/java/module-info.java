module com.example.todoquest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.todoquest to javafx.fxml;
    exports com.example.todoquest;
}