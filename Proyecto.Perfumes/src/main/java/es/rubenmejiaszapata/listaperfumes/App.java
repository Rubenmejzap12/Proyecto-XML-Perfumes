package es.rubenmejiaszapata.listaperfumes;

import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    ListaPerfume listaPerfume;
    int perfumeActual = 0;
    
 
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ffff99;");
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
       
        // Posicionamiento en pantalla de los dos botones de arriba
        HBox hBoxBotonesArriba = new HBox(30);
        hBoxBotonesArriba.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(hBoxBotonesArriba);
        
        
        // Posicionamiento en pantalla del recuadro label que muestra los valores de los perfumes
        Label labelPerfumes = new Label();
        root.getChildren().add(labelPerfumes);
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color:#ffffcc");
        vbox.getChildren().addAll(labelPerfumes);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.NONE, CornerRadii.EMPTY, 
                                  new BorderWidths(8))));
        vbox.setMaxSize(300,550);
        root.getChildren().add(vbox);
        
        // Posicionamiento en pantalla de los dos botones de abajo
        HBox hBoxBotonesAbajo = new HBox(30);
        hBoxBotonesAbajo.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().add(hBoxBotonesAbajo);
        
        // Creacion Lista de Perfumes
        listaPerfume = new ListaPerfume();
        
        //Creacion Perfume 1
        Perfume perfume1 = new Perfume();
        listaPerfume.getListaPerfumes().add(perfume1);
        perfume1.setMarca("Hugo Boss");
        perfume1.setCreador("Hugo Boss");
        perfume1.setCodigoPerfume(182569);
        perfume1.setUnidades(20);
        perfume1.setPrecio(50);
        perfume1.setFechaCreacion("1995/04/12");
        System.out.println(perfume1.getMarca());
        System.out.println(perfume1.getCreador());
        System.out.println(perfume1.getFechaCreacion());
        
        
        
        //Creacion Perfume 2
        Perfume perfume2 = new Perfume();
        listaPerfume.getListaPerfumes().add(perfume2);
        perfume2.setMarca("Chanel");
        perfume2.setCreador("Ernest Beaux");
        perfume2.setCodigoPerfume(269875);
        perfume2.setUnidades(45);
        perfume2.setPrecio(60);
        perfume2.setFechaCreacion("1924/10/20");
        System.out.println(perfume2.getMarca());
        System.out.println(perfume2.getCreador());
        System.out.println(perfume1.getFechaCreacion());
       
        
        //Creacion Perfume 3
        Perfume perfume3 = new Perfume();
        listaPerfume.getListaPerfumes().add(perfume3);
        perfume3.setMarca("Dolce & Gabbana");
        perfume3.setCreador("Stefano Gabbana");
        perfume3.setCodigoPerfume(254789);
        perfume3.setUnidades(100);
        perfume3.setPrecio(70);
        perfume3.setFechaCreacion("1985/01/12");
        System.out.println(perfume3.getMarca());
        System.out.println(perfume3.getCreador());
        System.out.println(perfume1.getFechaCreacion());
        
        
        
        // MOSTAR LOS PERFUMES EN EL LABEL 
        labelPerfumes.setText(listaPerfume.getListaPerfumes().get(perfumeActual).toString()); 
        System.out.println("Número de perfumes actual: "+listaPerfume.getListaPerfumes().size());
        
        
        // Boton Exportar XML
        Button buttonExport = new Button("Exportar XML");
        buttonExport.setStyle("-fx-background-color: #cccc00;");
        buttonExport.setMinHeight(50);
        buttonExport.setMinWidth(120);
        buttonExport.setMaxHeight(50);
        buttonExport.setMaxWidth(120);
        hBoxBotonesArriba.getChildren().add(buttonExport);
        buttonExport.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("Has pulsado botón exportar");
            UtilXML.guardarFicheroXML(stage, listaPerfume);
        });
        
        
        // Boton Iportar XML
        Button buttonImport = new Button("Importar XML");
        buttonImport.setStyle("-fx-background-color: #cccc00;");
        buttonImport.setMinHeight(50);
        buttonImport.setMinWidth(120);
        buttonImport.setMaxHeight(50);
        buttonImport.setMaxWidth(120);
        hBoxBotonesArriba.getChildren().add(buttonImport);
        buttonImport.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("pulsaste botón importar");
            ListaPerfume perfumesImport = UtilXML.ImportDatosXML(stage);
            listaPerfume.fusionarPerfumes(perfumesImport);
        });
        
        
        // Boton Ver perfume anterior
        Button buttonPrevious = new Button("Perfume Anterior");
        buttonPrevious.setStyle("-fx-background-color: #cccc00;");
        buttonPrevious.setMinHeight(50);
        buttonPrevious.setMinWidth(120);
        buttonPrevious.setMaxHeight(50);
        buttonPrevious.setMaxWidth(120);
        hBoxBotonesAbajo.getChildren().add(buttonPrevious);
        buttonPrevious.setOnAction((t) -> {
        try {
            perfumeActual--;
            labelPerfumes.setText(listaPerfume.getListaPerfumes().get(perfumeActual).toString());
            System.out.println("Has pulsado el botón perfume anterior");
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("No existen mas Perfumes ");
            ButtonType buttonAccept = new ButtonType("Aceptar");
            alert.getButtonTypes().setAll(buttonAccept);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonAccept){
                perfumeActual = 0;
                labelPerfumes.setText(listaPerfume.getListaPerfumes().get(perfumeActual).toString()); 
            } 
        }
    });
        
        // Boton Siguiente perfume
        Button buttonNext = new Button("Siguiente Perfume");
        buttonNext.setStyle("-fx-background-color: #cccc00;");
        buttonNext.setMinHeight(50);
        buttonNext.setMinWidth(120);
        buttonNext.setMaxHeight(50);
        buttonNext.setMaxWidth(120);
        hBoxBotonesAbajo.getChildren().add(buttonNext);
        buttonNext.setOnAction((t) -> {
        try {
            perfumeActual++;
            labelPerfumes.setText(listaPerfume.getListaPerfumes().get(perfumeActual).toString());
            System.out.println("Has pulsado el botón Siguiente perfume");
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("No existen mas Perfumes ");
            ButtonType buttonBeginning = new ButtonType("Aceptar");
            alert.getButtonTypes().setAll(buttonBeginning);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonBeginning){
                perfumeActual = 0;
                labelPerfumes.setText(listaPerfume.getListaPerfumes().get(perfumeActual).toString()); 
            } 
        }
      });
        
    }

    public static void main(String[] args) {
        launch();
    }

}