module es.iesfranciscodelosrios {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.iesfranciscodelosrios to javafx.fxml;
    exports es.iesfranciscodelosrios;
    exports es.iesfranciscodelosrios.currency;
}