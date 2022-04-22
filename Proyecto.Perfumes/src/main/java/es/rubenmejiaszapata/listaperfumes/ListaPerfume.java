package es.rubenmejiaszapata.listaperfumes;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaPerfume {
    private ArrayList<Perfume> listaPerfumes = new ArrayList();
    
    public ArrayList<Perfume> getListaPerfumes(){
        return listaPerfumes;
    }
    
    @XmlElement(name = "perfume")
    public void setListaPerfumes(ArrayList<Perfume> listaPerfumes){
        this.listaPerfumes = listaPerfumes;
    }
    
    
    public void fusionarPerfumes(ListaPerfume listaPerfumeNueva){
        this.getListaPerfumes().addAll(listaPerfumeNueva.getListaPerfumes());
    }
    
}
