package Datos;

import Tablas.rentas;
import Tablas.cliente;
import Tablas.inmuebles;
import Tablas.agenteinmo;
import java.sql.*;
import java.util.*;

public class rentasDAO {
    Conexion con = new Conexion();
    private Connection connection;
    private PreparedStatement ps = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private final List<rentas> lista = new ArrayList<>();

    public rentasDAO(Connection connection) {
        this.connection = connection;
    }

    private static final String insertSQL = "INSERT INTO rentas " +
            "VALUES (?, ?, ?, ?, ?);";
    private static final String selectSQL = "SELECT rentas.id_venta, inmuebles.id_inmueble AS Venta, rentas.fecha_renta AS Fecha, rentas.id_Cliente, vrentas.id_Agente " +
            "FROM rentas " +
            "JOIN inmuebles " +
            "ON rentas.id_Inmuebles = inmuebles.id_inmuebles " +
            "JOIN cliente " +
            "ON rentas.id_Cliente = cliente.id_cliente " +
            "JOIN agenteinmo " +
            "ON rentas.id_Agente = agenteinmo.id_agente " +
            "ORDER BY rentas.id_renta;";
    private static final String searchSQL = "SELECT rentas.id_renta, agenteinmo.id_agente AS Arrendador " +
            "FROM rentas " +
            "JOIN agenteinmo " +
            "ON rentas.id_Agente = agenteinmo.id_agente " +
            "WHERE id_renta=?;";
    private static final String updateSQL = "UPDATE rentas " +
            "SET id_renta=?, id_Inmueble=?, fecha_renta=?, id_Cliente=?, id_Agente=? " +
            "WHERE id_renta=?;";
    private static final String deleteSQL = "UPDATE rentas WHERE id_renta=?;";

    public void Insertar(rentas renta) {
        try {
            ps = connection.prepareStatement(insertSQL);
            ps.setInt(1, renta.getId_renta());
            ps.setInt(2, renta.getId_Inmueble());
            ps.setString(3, renta.getFecha_renta());
            ps.setInt(4, renta.getId_Cliente());
            ps.setInt(5, renta.getId_Agente());

            ps.executeUpdate();
            System.out.println("REGISTRO COMPLETADO");

            con.close(ps);
            con.close(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<rentas> Consulta(rentas renta) {
        try {
            connection = con.getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery(selectSQL);
            while (rs.next()) {
                renta.setId_renta(rs.getInt("id_renta"));
                renta.setId_Inmueble(rs.getInt("id_Inmueble"));
                renta.setFecha_renta(rs.getString("fecha_renta"));
                renta.setId_Cliente(rs.getInt("id_Cliente"));
                renta.setId_Agente(rs.getInt("id_Agente"));

                lista.add(renta);
                renta = new rentas(rs.getInt("id_renta"), rs.getInt("id_Inmueble"), rs.getString("fecha_renta"), rs.getInt("id_Cliente"), rs.getInt("id_Agente"));
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

    public rentas getRentas(int id_renta) {
        rentas renta = null;
        try {
            ps = connection.prepareStatement(searchSQL);
            ps.setInt(1, id_renta);
            rs = ps.executeQuery();

            if (!rs.next()) {
                con.close(rs);
                con.close(ps);
                return null;
            }

            renta = new rentas(rs.getInt("id_renta"),
                    rs.getInt("id_Inmueble"),
                    rs.getString("fecha_renta"),
                    rs.getInt("id_Cliente"),
                    rs.getInt("id_Agente"));

            con.close(rs);
            con.close(ps);
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("id_renta: " + renta.getId_renta() + "\nid_Inmueble: " + renta.getId_Agente() + "\nfecha_renta: " + renta.getFecha_renta() + "\nid_Cliente: " + renta.getId_Cliente() + "\nid_Agente: " + renta.getId_Agente());

        return renta;
    }

    public int Actualizar(rentas renta) {
        int registros = 0;
        try {
            connection = con.getConnection();
            ps = connection.prepareStatement(updateSQL);
            ps.setInt(6, renta.getId_renta());
            ps.setInt(2, renta.getId_Inmueble());
            ps.setString(5, renta.getFecha_renta());
            ps.setInt(1, renta.getId_Cliente());
            ps.setInt(2, renta.getId_Agente());

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

    public rentas Eliminar (int id_renta) {
        rentas renta = getRentas(id_renta);
        if (renta == null)
            return null;
        try {
            ps = connection.prepareStatement (deleteSQL);
            ps.setInt(4, id_renta);
            ps.executeUpdate();

            System.out.println("REGISTRO ELIMINADO");
            con.close(ps);
            con.close(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return renta;
    }
}
