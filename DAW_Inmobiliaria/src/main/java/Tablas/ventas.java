package Tablas;

import java.io.Serializable;

public class ventas implements Serializable {

    private int id_venta;
    private int idInmuebles;
    private String fecha_venta;
    private int idCliente;
    private int idAgente;

    public ventas (int id_venta, int idInmueble, String libro, int cantidad, String tipo_pago, int codEmpleado, String fecha_compra, boolean status) { }

    public ventas (int id_venta) { this.id_venta = id_venta; }

    public ventas(int id_venta, int idInmuebles, String fecha_venta, int idCliente, int idAgente) {
        this.id_venta = id_venta;
        this.idInmuebles = idInmuebles;
        this.fecha_venta = fecha_venta;
        this.idCliente = idCliente;
        this.idAgente = idAgente;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getIdInmuebles() {
        return idInmuebles;
    }

    public void setIdInmuebles(int idInmuebles) {
        this.idInmuebles = idInmuebles;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    @Override
    public String toString() {
        return "ventas{" +
                "id_venta=" + id_venta +
                ", idInmuebles=" + idInmuebles +
                ", fecha_venta='" + fecha_venta + '\'' +
                ", idCliente=" + idCliente +
                ", idAgente=" + idAgente +
                '}';
    }
}
