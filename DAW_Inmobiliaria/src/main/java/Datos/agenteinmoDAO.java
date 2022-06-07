package Datos;

import Tablas.agenteinmo;
import java.sql.*;

public class agenteinmoDAO {

    private Conexion con = null;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public agenteinmoDAO(Connection connection) {
        con = new Conexion();
        this.connection = con.getConnection();
    }

    public void insertarRegistro(agenteinmo agente) {
        String sql = null;
        try {
            sql = "INSERT INTO inmuebles(INSERT INTO inmuebles" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, agente.getId_agente());
            ps.setString(2, agente.getNombre());
            ps.setString(3, agente.getA_paterno());
            ps.setString(4, agente.getA_materno());
            ps.setInt(5, agente.getCant_inmuebles());
            ps.setString(6, agente.getTelefono());
            ps.setString(7, agente.getCelular());
            ps.setString(8, agente.getEmail());


            ps.executeUpdate();
            System.out.println("REGISTRO COMPLETADO");

            con.close(ps);
            con.close(connection);

        }catch (Exception e) {
            System.out.println("ERROR DE CONEXION: " + e);
        }
    }

    public agenteinmo seleccionarRegistro(agenteinmo agente){
        String sql = null;
        try {
            sql = "SELECT * FROM agenteinmo " +
                    "WHERE agenteinmo.Id_agente = " + agente.getId_agente() + ";";
            rs = connection.createStatement().executeQuery(sql);
            if (!rs.next())
                System.out.println("AGENTE NO REGISTRADO");
            else
                return new agenteinmo(rs.getInt("ID Agente"), rs.getString("Nombre"), rs.getString("A_Paterno "), rs.getString("A_Materno"), rs.getInt("Cant_Inmuebles"), rs.getString("Telefono"), rs.getString("Celular"), rs.getString("Email"));
            con.close(rs);
            con.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarRegistro(agenteinmo agente){
        String sql = null;
        try {
            sql = "UPDATE agenteinmo "+
                    "SET ID_Agente = ?, Nombre = ?, A_Paterno = ?, A_Materno = ?, Cant_inmueble = ?, Telefono = ?, Celular = ?, Email  = ?"+
                    "WHERE agenteinmo.ID_agente = ?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, agente.getId_agente());
            ps.setString(2, agente.getNombre());
            ps.setString(3, agente.getA_paterno());
            ps.setString(4, agente.getA_materno());
            ps.setInt(5, agente.getCant_inmuebles());
            ps.setString(6, agente.getTelefono());
            ps.setString(7, agente.getCelular());
            ps.setString(8, agente.getEmail());

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

    public void eliminarRegistro(agenteinmo agente){
        String sql = null;
        try {
            sql = "DELETE * FROM agenteinmo "+
                "WHERE agenteinmo.Id_agente = " + agente.getId_agente()+";";
            rs = connection.createStatement().executeQuery(sql);
            if (!rs.next())
                System.out.println("AGENTE NO ENCONTRADO");
            con.close(rs);
            con.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}