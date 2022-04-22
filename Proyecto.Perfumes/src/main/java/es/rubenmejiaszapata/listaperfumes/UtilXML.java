package es.rubenmejiaszapata.listaperfumes;

import java.io.File;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    static public void guardarFicheroXML(Stage stage, ListaPerfume listaPerfume){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialFileName("fichero.xml");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichero XML ",".xml"));
        
            JAXBContext contexto;
                try {
                    File file = fileChooser.showSaveDialog(stage);
                    contexto = JAXBContext.newInstance(ListaPerfume.class);
                    Marshaller marshaller = contexto.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
                    marshaller.marshal(listaPerfume, System.out);
                    marshaller.marshal(listaPerfume, file);
                } catch (JAXBException ex) {
                    System.out.println("Se ha producido un error");
                    ex.printStackTrace();
                }
        
    }
    
    public static ListaPerfume ImportDatosXML(Stage stage) {
           try {
           
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Import XML en");
            File fileListaPerfumes = fileChooser.showOpenDialog(stage);
           
            JAXBContext context = JAXBContext.newInstance( ListaPerfume.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            ListaPerfume listaPerfumeNuevas = new ListaPerfume();
            listaPerfumeNuevas = (ListaPerfume)unmarshaller.unmarshal(fileListaPerfumes);
             
        return listaPerfumeNuevas;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setTitle("Error");
           alert.setContentText("El archivo XML no es valido");
           alert.showAndWait();
        return null;         
    }
}
