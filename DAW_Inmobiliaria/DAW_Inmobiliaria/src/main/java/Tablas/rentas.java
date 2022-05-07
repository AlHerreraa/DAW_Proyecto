package Tablas;

import java.io.Serializable;

public class rentas implements Serializable {

    private int id_renta;
    private int id_Inmueble;
    private String fecha_renta;
    private int id_Cliente;
    private int id_Agente;

    public rentas () { }

    public rentas (int id_renta) { this.id_renta = id_renta; }

    public rentas(int id_renta, int id_Inmueble, String fecha_renta, int id_Cliente, int id_Agente) {
        this.id_renta = id_renta;
        this.id_Inmueble = id_Inmueble;
        this.fecha_renta = fecha_renta;
        this.id_Cliente = id_Cliente;
        this.id_Agente = id_Agente;
    }

    public int getId_renta() {
        return id_renta;
    }

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }

    public int getId_Inmueble() {
        return id_Inmueble;
    }

    public void setId_Inmueble(int id_Inmueble) {
        this.id_Inmueble = id_Inmueble;
    }

    public String getFecha_renta() {
        return fecha_renta;
    }

    public void setFecha_renta(String fecha_renta) {
        this.fecha_renta = fecha_renta;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Agente() {
        return id_Agente;
    }

    public void setId_Agente(int id_Agente) {
        this.id_Agente = id_Agente;
    }

    @Override
    public String toString() {
        return "rentas{" +
                "id_renta=" + id_renta +
                ", id_Inmueble=" + id_Inmueble +
                ", fecha_renta='" + fecha_renta + '\'' +
                ", id_Cliente=" + id_Cliente +
                ", id_Agente=" + id_Agente +
                '}';
    }
}
