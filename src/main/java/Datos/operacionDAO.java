package Datos;

import Tablas.operacion;
import java.sql.*;

public class operacionDAO {

    private Conexion con = null;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public operacionDAO(Connection connection) {
        con = new Conexion();
        this.connection = con.getConnection();
    }

    public void insertarRegistro(operacion op) {
        String sql = null;
        try {
            sql = "INSERT INTO operacion(INSERT INTO operacion" +
                    "VALUES(?, ?)";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, op.getTipo_operacion());
            ps.setString(2, String.valueOf(op.getDesc_operacion()));

            ps.executeUpdate();
            System.out.println("REGISTRO COMPLETADO");

            con.close(ps);
            con.close(connection);

        }catch (Exception e) {
            System.out.println("ERROR DE CONEXION: " + e);
        }
    }

    public operacion seleccionarRegistro(operacion op){
        String sql = null;
        try {
            sql = "SELECT * FROM operacion " +
                    "WHERE operacion.Tipo_operacion = " + op.getTipo_operacion() + ";";
            rs = connection.createStatement().executeQuery(sql);
            if (!rs.next())
                System.out.println("INMUEBLE NO REGISTRADO");
            else
                return new operacion(rs.getInt("Tipo_operacion"), rs.getString("Desc_operacion"));
            con.close(rs);
            con.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarRegistro(operacion op){
        String sql = null;
        try {
            sql = "UPDATE operacion "+
                    "SET Tipo_operacion = ?, Desc_operacion = ?" +
                    "WHERE operacion.Tipo_operacion = ?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, op.getTipo_operacion());
            ps.setString(2, String.valueOf(op.getDesc_operacion()));

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

    public void eliminarRegistro(operacion op){
        String sql = null;
        try {
            sql = "DELETE * FROM operacion"+
                    "WHERE operacion.op = " + op.getTipo_operacion()+";";
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