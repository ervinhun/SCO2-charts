module dk.easv.charts {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.charts to javafx.fxml;
    exports dk.easv.charts;
}