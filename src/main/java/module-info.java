module courses.assignment4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires junit;
    requires eu.hansolo.toolboxfx;
    requires eu.hansolo.toolbox;
    requires eu.hansolo.fx.countries;
    requires eu.hansolo.fx.heatmap;
    requires javafx.swing;

    opens courses.assignment4 to javafx.fxml;
    exports courses.assignment4;
}