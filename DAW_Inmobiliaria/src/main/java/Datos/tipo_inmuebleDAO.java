package Datos;

import Tablas.tipo_inmueble;
import java.sql.*;

public class tipo_inmuebleDAO {

    private Conexion con = null;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public tipo_inmuebleDAO() {
        con = new Conexion();
        this.connection = con.getConnection();
    }

    public void insertarRegistro(tipo_inmueble TI) {
        String sql = null;
        try {
            sql = "INSERT INTO operacion(INSERT INTO tipo_inmueble" +
                    "VALUES(?, ?)";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, TI.getId_tipoinm());
            ps.setString(2, String.valueOf(TI.getDesc_inmueble()));

            ps.executeUpdate();
            System.out.println("REGISTRO COMPLETADO");

            con.close(ps);
            con.close(connection);

        }catch (Exception e) {
            System.out.println("ERROR DE CONEXION: " + e);
        }
    }

    public tipo_inmueble seleccionarRegistro(tipo_inmueble TI){
        String sql = null;
        try {
            sql = "SELECT * FROM tipo_inmueble " +
                    "WHERE tipo_inmueble.id_tipoinm = " + TI.getId_tipoinm() + ";";
            rs = connection.createStatement().executeQuery(sql);
            if (!rs.next())
                System.out.println("INMUEBLE NO REGISTRADO");
            else
                return new tipo_inmueble(rs.getInt("tipo_inmueble"), rs.getString("desc_inmueble"));
            con.close(rs);
            con.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarRegistro(tipo_inmueble TI){
        String sql = null;
        try {
            sql = "UPDATE operacion "+
                    "SET tipo_inmueble = ?, desc_inmueble = ?" +
                    "WHERE tipo_inmueble.id_tipoinm = ?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, TI.getId_tipoinm());
            ps.setString(2, String.valueOf(TI.getDesc_inmueble()));

            ps.executeUpdate();
            rs = ps.getResultSet();

            if (!rs.next())
                System.out.println("NO EXISTE REGISTRO");

            con.close(rs);
            con.close(ps);
            con.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarRegistro(tipo_inmueble TI){
        String sql = null;
        try {
            sql = "DELETE * FROM tipo_inmueble"+
                    "WHERE tipo_inmueble.TI = " + TI.getId_tipoinm()+";";
            rs = connection.createStatement().executeQuery(sql);
            if (!rs.next())
                System.out.println("OPERACION NO ENCONTRADA");
            con.close(rs);
            con.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}