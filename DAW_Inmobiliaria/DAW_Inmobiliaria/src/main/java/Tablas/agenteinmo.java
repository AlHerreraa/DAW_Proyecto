package Tablas;

import java.io.Serializable;

public class agenteinmo implements Serializable {
    private int id_agente;
    private String nombre;
    private String a_paterno;
    private String a_materno;
    private int cant_inmuebles;
    private String telefono;
    private String celular;
    private String email;

    public agenteinmo() { }

    public agenteinmo (int id_agente) { this.id_agente = id_agente; }

    public agenteinmo(int id_agente, String nombre, String a_paterno, String a_materno, int cant_inmuebles, String telefono, String celular, String email) {

        this.id_agente = id_agente;
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.cant_inmuebles = cant_inmuebles;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
    }

    public int getId_agente() {
        return id_agente;
    }

    public void setId_agente(int id_agente) {
        this.id_agente = id_agente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getCant_inmuebles() {
        return cant_inmuebles;
    }

    public void setCant_inmuebles(int cant_inmuebles) {
        this.cant_inmuebles = cant_inmuebles;
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
        return "agenteinmo{" +
                "id_agente=" + id_agente +
                ", nombre='" + nombre + '\'' +
                ", a_paterno='" + a_paterno + '\'' +
                ", a_materno='" + a_materno + '\'' +
                ", cant_inmuebles=" + cant_inmuebles +
                ", telefono='" + telefono + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
