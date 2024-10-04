module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens es.aketzagonzalez.aeropuertosB to javafx.fxml;
    exports es.aketzagonzalez.aeropuertosB;
}