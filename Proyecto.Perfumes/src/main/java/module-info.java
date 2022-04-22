module es.rubenmejiaszapata.listaperfumes {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.rubenmejiaszapata.listaperfumes;
    opens es.rubenmejiaszapata.listaperfumes to java.xml.bind;
}
