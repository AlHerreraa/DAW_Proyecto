package Tablas;

import java.io.Serializable;

public class cliente implements Serializable {

    private int id_cliente;
    private String nombre_cliente;
    private String a_paterno;
    private String a_materno;
    private String telefono;
    private String celular;
    private String email;

    public cliente(){ }

    public cliente (int id_cliente){ this.id_cliente = id_cliente; }

    public cliente(int id_cliente, String nombre_cliente, String a_paterno, String a_materno, String telefono, String celular, String email) {

        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getA_paterno() {
        return a_paterno;
    }

    public void setA_paterno(String a_paterno) {
        this.a_paterno = a_paterno;
    }

    public String getA_materno() {
        return a_materno;
    }

    public void setA_materno(String a_materno) {
        this.a_materno = a_materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre_cliente='" + nombre_cliente + '\'' +
                ", a_paterno='" + a_paterno + '\'' +
                ", a_materno='" + a_materno + '\'' +
                ", telefono='" + telefono + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
