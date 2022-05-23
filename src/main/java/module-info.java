module ru.avevdokimov.fxmaven11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens ru.avevdokimov.fxmaven11 to javafx.fxml;
    exports ru.avevdokimov.fxmaven11;
}