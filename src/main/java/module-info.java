module dam2.amv {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	requires dom4j;
	requires jdom2;

    opens dam2.amv to javafx.fxml;
    exports dam2.amv;
    exports model;
}