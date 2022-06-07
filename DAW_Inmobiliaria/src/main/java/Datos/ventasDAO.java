package Datos;

import Tablas.ventas;
import Tablas.cliente;
import Tablas.inmuebles;
import Tablas.agenteinmo;

import java.sql.*;
import java.util.*;

public class ventasDAO {
    Conexion con = new Conexion();
    private Connection connection;
    private PreparedStatement ps = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private final List<ventas> lista = new ArrayList<>();

    public ventasDAO(Connection connection) {
        this.connection = connection;
    }

    private static final String insertSQL = "INSERT INTO ventas " +
            "VALUES (?, ?, ?, ?, ?);";
    private static final String selectSQL = "SELECT ventas.id_venta, inmuebles.id_inmueble AS Venta, ventas.fecha_venta AS Fecha, ventas.idCliente, ventas.idAgente " +
            "FROM ventas " +
            "JOIN inmuebles " +
            "ON ventas.idInmuebles = inmuebles.id_inmuebles " +
            "JOIN cliente " +
            "ON ventas.idCliente = cliente.id_cliente " +
            "JOIN agenteinmo " +
            "ON ventas.idAgente = agenteinmo.id_agente " +
            "ORDER BY ventas.id_venta;";
    private static final String searchSQL = "SELECT ventas.id_venta, agenteinmo.id_agente AS Vendedor " +
            "FROM ventas " +
            "JOIN agenteinmo " +
            "ON ventas.idAgente = agenteinmo.id_agente " +
            "WHERE id_venta=?;";
    private static final String updateSQL = "UPDATE ventas " +
            "SET id_venta=?, idInmuebles=?, fecha_venta=?, idCliente=?, idAgente=? " +
            "WHERE id_venta=?;";
    private static final String deleteSQL = "UPDATE ventas WHERE id_venta=?;";

    public void Insertar(ventas venta) {
        try {
            ps = connection.prepareStatement(insertSQL);
            ps.setInt(1, venta.getId_venta());
            ps.setInt(2, venta.getIdInmuebles());
            ps.setString(3, venta.getFecha_venta());
            ps.setInt(4, venta.getIdCliente());
            ps.setInt(5, venta.getIdAgente());

            ps.executeUpdate();
            System.out.println("REGISTRO COMPLETADO");

            con.close(ps);
            con.close(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ventas> Consulta(ventas venta) {
        try {
            connection = con.getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery(selectSQL);
            while (rs.next()) {
                venta.setId_venta(rs.getInt("id_venta"));
                venta.setIdInmuebles(rs.getInt("idInmuebles"));
                venta.setFecha_venta(rs.getString("fecha_venta"));
                venta.setIdCliente(rs.getInt("idClente"));
                venta.setIdAgente(rs.getInt("idAgente"));

                lista.add(venta);
                venta = new ventas(rs.getInt("id_venta"), rs.getInt("idInmuebles"), rs.getString("fecha_venta"), rs.getInt("idCliente"), rs.getInt("idAgente"));
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

    public ventas getVentas(int id_venta) {
        ventas venta = null;
        try {
            ps = connection.prepareStatement(searchSQL);
            ps.setInt(1, id_venta);
            rs = ps.executeQuery();

            if (!rs.next()) {
                con.close(rs);
                con.close(ps);
                return null;
            }

            venta = new ventas(rs.getInt("id_venta"),
                    rs.getInt("idInmuebles"),
                    rs.getString("fecha_venta"),
                    rs.getInt("idCliente"),
                    rs.getInt("idAgente"));

            con.close(rs);
            con.close(ps);
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("id_venta: " + venta.getId_venta() + "\nidInmuebles: " + venta.getIdAgente() + "\nfecha_venta: " + venta.getFecha_venta() + "\nidCliente: " + venta.getIdCliente() + "\nidAgente: " + venta.getIdAgente());

        return venta;
    }

    public int Actualizar(ventas venta) {
        int registros = 0;
        try {
            connection = con.getConnection();
            ps = connection.prepareStatement(updateSQL);
            ps.setInt(4, venta.getId_venta());
            ps.setInt(4, venta.getIdInmuebles());
            ps.setString(3, venta.getFecha_venta());
            ps.setInt(3, venta.getIdCliente());
            ps.setInt(3, venta.getIdAgente());

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

    public ventas Eliminar (int id_venta) {
        ventas venta = getVentas(id_venta);
        if (venta == null)
            return null;
        try {
            ps = connection.prepareStatement (deleteSQL);
            ps.setInt(1, id_venta);
            ps.executeUpdate();

            System.out.println("REGISTRO ELIMINADO");
            con.close(ps);
            con.close(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return venta;
    }
}
