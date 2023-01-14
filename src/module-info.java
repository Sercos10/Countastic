module es.iesfranciscodelosrios {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens es.iesfranciscodelosrios to javafx.fxml;
    exports es.iesfranciscodelosrios;
    exports es.iesfranciscodelosrios.currency;
}