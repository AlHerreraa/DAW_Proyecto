package Datos;

import Tablas.agenteinmo;
import java.sql.*;
import java.util.*;
// -------------------- dbcp2 data sources
public class agenteinmoDAO {
    Conexion con = new Conexion();
    private Connection connection;
    private PreparedStatement ps = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private List<agenteinmo> lista = new ArrayList<>();

    public agenteinmoDAO(Connection connection) {
        this.connection = connection;
    }

    private static final String insertSQL = "INSERT INTO agenteinmo " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String selectSQL = "SELECT * FROM agenteinmo ORDER BY id_agente;";
    private static final String searchSQL = "SELECT * FROM agenteinmo WHERE id_agente = ?;";
    private static final String updateSQL = "UPDATE agenteinmo SET nombre=?, a_paterno=?, a_materno=?, cant_inmuebles=?, Telefono=?, Celular=?, email=? WHERE id_agente=?";
    private static final String deleteSQL = "UPDATE agenteinmo SET cant_inmuebles = 4 WHERE id_agente=?;";


    public void Insertar(agenteinmo agente) {
        try {
            ps = connection.prepareStatement(insertSQL);
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
            e.printStackTrace();
        }
    }

    public List<agenteinmo> Consulta(agenteinmo agente) {
        try {
            connection = con.getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery(selectSQL);
            while (rs.next()) {
                agente.setId_agente(rs.getInt("id_agente"));
                agente.setNombre(rs.getString("nombre"));
                agente.setA_paterno(rs.getString("a_paterno"));
                agente.setA_materno(rs.getString("a_materno"));
                agente.setCant_inmuebles(rs.getInt("cant_inmuebles"));
                agente.setTelefono(rs.getString("telefono"));
                agente.setCelular(rs.getString("celular"));
                agente.setEmail(rs.getString("email"));

                lista.add(agente);
                agente = new agenteinmo();
            }

            con.close(rs);
            con.close(stm);
            con.close(connection);

            lista.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public agenteinmo getAgenteinmo(int id_agente) {
        agenteinmo agente = null;
        try {
            ps = connection.prepareStatement(searchSQL);
            ps.setInt(1, id_agente);
            rs = ps.executeQuery();

            if (!rs.next()) {
                con.close(rs);
                con.close(ps);
                return null;
            }

            agente = new agenteinmo(rs.getInt("id_agente"),
                    rs.getString("nombre"),
                    rs.getString("a_paterno"),
                    rs.getString("a_materno"),
                    rs.getInt("cant_inmuebles"),
                    rs.getString("telefono"),
                    rs.getString("celular"),
                    rs.getString("email"));
            con.close(rs);
            con.close(ps);
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("id_agente: " + agente.getId_agente() + "\nNombre: " + agente.getNombre() + "\nApellido Paterno: " + agente.getA_paterno() + "\nApellido Materno: " + agente.getA_materno() + "\nCant_inmuebles: " + agente.getCant_inmuebles() + "\nTelefono: " + agente.getTelefono() + "\nCelular: " + agente.getCelular() + "\nEmail: " + agente.getEmail());

        return agente;
    }

    public int Actualizar(agenteinmo agente) {
        int registros = 0;
        try {
            connection = con.getConnection();
            ps = connection.prepareStatement(updateSQL);
            ps.setInt(8, agente.getId_agente());
            ps.setString(1, agente.getNombre());
            ps.setString(2, agente.getA_paterno());
            ps.setString(3, agente.getA_materno());;
            ps.setInt(4, agente.getCant_inmuebles());
            ps.setString(5, agente.getTelefono());
            ps.setString(6, agente.getCelular());
            ps.setString(7, agente.getEmail());


            registros = ps.executeUpdate();
            if (registros > 0)
                System.out.println("REGISTRO ACTUALIZADO");

            con.close(ps);
            con.close(connection);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }

    public agenteinmo Eliminar (int id_agente) {
        agenteinmo agente = getAgenteinmo(id_agente);
        if (agente == null)
            return null;
        try {
            ps = connection.prepareStatement (deleteSQL);
            ps.setInt(1, id_agente);
            ps.executeUpdate();

            System.out.println("REGISTRO ELIMINADO");
            con.close(ps);
            con.close(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return agente;
    }
}
