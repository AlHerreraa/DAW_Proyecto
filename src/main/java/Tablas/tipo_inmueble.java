package Tablas;

import java.io.Serializable;

public class tipo_inmueble implements Serializable {

    private int id_tipoinm;
    private String desc_inmueble;

    public tipo_inmueble () { }

    public tipo_inmueble (int id_tipoinm) { this.id_tipoinm = id_tipoinm; }

    public tipo_inmueble(int id_tipoinm, String desc_inmueble) {

        this.id_tipoinm = id_tipoinm;
        this.desc_inmueble = desc_inmueble;
    }

    public int getId_tipoinm() {
        return id_tipoinm;
    }

    public void setId_tipoinm(int id_tipoinm) {
        this.id_tipoinm = id_tipoinm;
    }

    public String getDesc_inmueble() {
        return desc_inmueble;
    }

    public void setDesc_inmueble(String desc_inmueble) {
        this.desc_inmueble = desc_inmueble;
    }

    @Override
    public String toString() {
        return "tipo_inmueble{" +
                "id_tipoinm=" + id_tipoinm +
                ", desc_inmueble='" + desc_inmueble + '\'' +
                '}';
    }
}
