module dam2.amv {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens dam2.amv to javafx.fxml;
    exports dam2.amv;
}