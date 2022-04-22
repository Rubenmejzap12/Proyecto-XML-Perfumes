package es.rubenmejiaszapata.listaperfumes;

public class Perfume {
    
    private String marca;
    private String creador;
    private int codigoPerfume;
    private int unidades;
    private float precio;
    private String fechaCreacion;
    
    public Perfume() {        
    }
    
    public Perfume(String marca) {
        this.marca = marca.toUpperCase();
    }
    
    public Perfume(String marca, String creador) {
        this.marca = marca.toUpperCase();
        this.creador = creador;
    }
    
    public String getMarca() {        
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca.toUpperCase();
    }
    
    public String getCreador() {
        return creador;
    }
    
    public void setCreador(String creador) {
        this.creador = creador;
    }
    
    public int getCodigoPerfume() {
        return codigoPerfume;
    }
    
    public void setCodigoPerfume(int codigoPerfume) {
        this.codigoPerfume = codigoPerfume;
    }
    
    public int getUnidades() {
        return unidades;
    }
    
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    public float getPrecio() {
        return precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    @Override
    public String toString() {
        String r = "";
        r += "Marca: " + marca + "\n";
        r += "Creador: " + creador + "\n";
        r += "Codigo Perfume: " + codigoPerfume + "\n";
        r += "Unidades: " + unidades + "\n";
        r += "precio: " + precio + "\n";
        r += "Fecha Creacion: " + fechaCreacion + "\n";
        return r;
    }
}