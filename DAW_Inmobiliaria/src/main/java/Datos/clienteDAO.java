package Datos;

import Tablas.cliente;
import java.sql.*;
import java.util.*;

public class clienteDAO {
    Conexion con = new Conexion();
    private Connection connection;
    private PreparedStatement ps = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private List<cliente> lista = new ArrayList<>();

    public clienteDAO(Connection connection) {
        this.connection = connection;
    }

    private static final String insertSQL = "INSERT INTO cliente " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String selectSQL = "SELECT * FROM cliente ORDER BY id_cliente;";
    private static final String searchSQL = "SELECT * FROM cliente WHERE id_cliente = ?;";
    private static final String updateSQL = "UPDATE cliente SET nombre_cliente=?, a_paterno=?, a_materno=?, telefono=?, celular=?, email=? WHERE id_cliente=?";
    private static final String deleteSQL = "UPDATE cliente WHERE id_cliente=?;";


    public void Insertar(cliente persona) {
        try {
            ps = connection.prepareStatement(insertSQL);
            ps.setInt(1, persona.getId_cliente());
            ps.setString(2, persona.getNombre_cliente());
            ps.setString(3, persona.getA_paterno());
            ps.setString(4, persona.getA_materno());
            ps.setString(5, persona.getTelefono());
            ps.setString(6, persona.getCelular());
            ps.setString(7, persona.getEmail());

            ps.executeUpdate();
            System.out.println("REGISTRO COMPLETADO");

            con.close(ps);
            con.close(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<cliente> Consulta(cliente persona) {
        try {
            connection = con.getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery(selectSQL);
            while (rs.next()) {
                persona.setId_cliente(rs.getInt("id_cliente"));
                persona.setNombre_cliente(rs.getString("Nombre"));
                persona.setA_paterno(rs.getString("a_paterno"));
                persona.setA_materno(rs.getString("a_materno"));
                persona.setTelefono(rs.getString("Telefono"));
                persona.setCelular(rs.getString("Celular"));
                persona.setEmail(rs.getString("Email"));

                lista.add(persona);
                persona = new cliente();
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

    public cliente getCliente(int id_cliente) {
        cliente persona = null;
        try {
            ps = connection.prepareStatement(searchSQL);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();

            if (!rs.next()) {
                con.close(rs);
                con.close(ps);
                return null;
            }

            persona = new cliente(rs.getInt("id_cliente"),
                    rs.getString("Nombre"),
                    rs.getString("a_paterno"),
                    rs.getString("a_materno"),
                    rs.getString("Telefono"),
                    rs.getString("Celular"),
                    rs.getString("Email"));
            con.close(rs);
            con.close(ps);
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("id_cliente: " + persona.getId_cliente() + "\nNombre: " + persona.getNombre_cliente() + "\nApellido Paterno: " + persona.getA_paterno() + "\nApellido Materno: " + persona.getA_materno() + "\nTelefono: " + persona.getTelefono() + "\nCelular: " + persona.getCelular() + "\nEmail: " + persona.getEmail());

        return persona;
    }

    public int Actualizar(cliente persona) {
        int registros = 0;
        try {
            connection = con.getConnection();
            ps = connection.prepareStatement(updateSQL);
            ps.setInt(7, persona.getId_cliente());
            ps.setString(1, persona.getNombre_cliente());
            ps.setString(2, persona.getA_paterno());
            ps.setString(3, persona.getA_materno());;
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getCelular());
            ps.setString(6, persona.getEmail());


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

    public cliente Eliminar (int id_cliente) {
        cliente persona = getCliente(id_cliente);
        if (persona == null)
            return null;
        try {
            ps = connection.prepareStatement (deleteSQL);
            ps.setInt(1, id_cliente);
            ps.executeUpdate();

            System.out.println("REGISTRO ELIMINADO");
            con.close(ps);
            con.close(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return persona;
    }
}