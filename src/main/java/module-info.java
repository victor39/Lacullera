module dam2.amv {
    requires javafx.controls;
    requires javafx.fxml;

    opens dam2.amv to javafx.fxml;
    exports dam2.amv;
}