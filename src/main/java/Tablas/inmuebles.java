package Tablas;

import javax.swing.text.StyledEditorKit;
import java.io.Serializable;

public class inmuebles implements Serializable {

    private int id_inmueble;
    private int tipoinmueble;
    private int tipoperacion;
    private int num_recamaras;
    private int num_banos;
    private int num_medbanos;
    private int num_garage;
    private Boolean jardin;
    private Boolean alberca;
    private String ubicacion;
    private String observaciones;
    private String precio;

    public inmuebles() { }

    public inmuebles(int id_inmueble) { this.id_inmueble = id_inmueble; }

    public inmuebles(int id_inmueble, int tipoinmueble, int tipoperacion, int num_recamaras, int num_banos, int num_medbanos, int num_garage, boolean jardin, boolean alberca, String ubicacion, String observaciones, String precio){

        this.id_inmueble = id_inmueble;
        this.tipoinmueble = tipoinmueble;
        this.tipoperacion = tipoperacion;
        this.num_recamaras = num_recamaras;
        this.num_banos = num_banos;
        this.num_medbanos = num_medbanos;
        this.num_garage = num_garage;
        this.jardin = jardin;
        this.alberca = alberca;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
        this.precio = precio;

    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public int getTipoinmueble() {
        return tipoinmueble;
    }

    public void setTipoinmueble(int tipoinmueble) {
        this.tipoinmueble = tipoinmueble;
    }

    public int getTipoperacion() {
        return tipoperacion;
    }

    public void setTipoperacion(int tipoperacion) {
        this.tipoperacion = tipoperacion;
    }

    public int getNum_recamaras() {
        return num_recamaras;
    }

    public void setNum_recamaras(int num_recamaras) {
        this.num_recamaras = num_recamaras;
    }

    public int getNum_banos() {
        return num_banos;
    }

    public void setNum_banos(int num_banos) {
        this.num_banos = num_banos;
    }

    public int getNum_medbanos() {
        return num_medbanos;
    }

    public void setNum_medbanos(int num_medbanos) {
        this.num_medbanos = num_medbanos;
    }

    public int getNum_garage() {
        return num_garage;
    }

    public void setNum_garage(int num_garage) {
        this.num_garage = num_garage;
    }

    public Boolean getJardin() {
        return jardin;
    }

    public void setJardin(Boolean jardin) {
        this.jardin = jardin;
    }

    public Boolean getAlberca() {
        return alberca;
    }

    public void setAlberca(Boolean alberca) {
        this.alberca = alberca;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "inmuebles{" +
                "id_inmueble=" + id_inmueble +
                ", tipoinmueble=" + tipoinmueble +
                ", tipoperacion=" + tipoperacion +
                ", num_recamaras=" + num_recamaras +
                ", num_banos=" + num_banos +
                ", num_medbanos=" + num_medbanos +
                ", num_garage=" + num_garage +
                ", jardin=" + jardin +
                ", alberca=" + alberca +
                ", ubicacion='" + ubicacion + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", precio=" + precio +
                '}';
    }
}
