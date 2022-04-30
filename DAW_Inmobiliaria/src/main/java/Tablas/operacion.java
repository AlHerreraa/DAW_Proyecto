package Tablas;

import java.io.Serializable;

public class operacion implements Serializable {

    private int tipo_operacion;
    private String desc_operacion;

    public operacion () { }

    public operacion (int tipo_operacion) { this.tipo_operacion = tipo_operacion; }

    public operacion(int tipo_operacion, String desc_operacion) {
        this.tipo_operacion = tipo_operacion;
        this.desc_operacion = desc_operacion;
    }

    public int getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(int tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public String getDesc_operacion() {
        return desc_operacion;
    }

    public void setDesc_operacion(String desc_operacion) {
        this.desc_operacion = desc_operacion;
    }

    @Override
    public String toString() {
        return "operacion{" +
                "tipo_operacion=" + tipo_operacion +
                ", desc_operacion='" + desc_operacion + '\'' +
                '}';
    }
}
