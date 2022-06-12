package Datos;

import Tablas.inmuebles;
import java.sql.*;


public class inmueblesDAO {

    private Conexion con = null;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public inmueblesDAO(Connection connection) {
        con = new Conexion();
        this.connection = con.getConnection();
    }

    // REGISTROS

    public void insertarRegistro(inmuebles inmueble) {
        String sql = null;
        try {
            sql = "INSERT INTO inmuebles(INSERT INTO inmuebles" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, inmueble.getId_inmueble());
            ps.setInt(2, inmueble.getTipoinmueble());
            ps.setInt(3, inmueble.getTipoperacion());
            ps.setInt(4, inmueble.getNum_recamaras());
            ps.setInt(5, inmueble.getNum_banos());
            ps.setInt(6, inmueble.getNum_medbanos());
            ps.setInt(7, inmueble.getNum_garage());
            ps.setBoolean(8, inmueble.getJardin());
            ps.setBoolean(9, inmueble.getAlberca());
            ps.setString(10, inmueble.getUbicacion());
            ps.setString(11, String.valueOf(inmueble.getObservaciones()));
            ps.setString(12, inmueble.getPrecio());

            ps.executeUpdate();
            System.out.println("REGISTRO COMPLETADO");

            con.close(ps);
            con.close(connection);

        }catch (Exception e) {
            System.out.println("ERROR DE CONEXION: " + e);
        }
    }

    public inmuebles seleccionarRegistro(inmuebles inmueble){
        String sql = null;
        try {
            sql = "SELECT * FROM inmuebles " +
                    "WHERE inmuebles.Id_inmueble = " + inmueble.getId_inmueble() + ";";
            rs = connection.createStatement().executeQuery(sql);
            if (!rs.next())
                System.out.println("INMUEBLE NO REGISTRADO");
            else
                return new inmuebles(rs.getInt("ID_Inmueble"), rs.getInt("Tipo_Inmueble"), rs.getInt("Tipo_Operacion "), rs.getInt("Num_Recamaras"), rs.getInt("Num_Banos"), rs.getInt("Num_MedBanos"), rs.getInt("Num_Garage"), rs.getBoolean("Jardin"), rs.getBoolean("Alberca"), rs.getString("Ubicacion"), rs.getString("Observaciones"), rs.getString("Precio"));
            con.close(rs);
            con.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarRegistro(inmuebles inmueble){
        String sql = null;
        try {
            sql = "UPDATE inmuebles "+
                    "SET ID_Inmueble = ?, Tipo_Inmueble = ?, Tipo_Operacion = ?, Num_Recamaras = ?, Num_Banos = ?, Num_MedBanos = ?, Num_Garage = ?, Jardin  = ?, Alberca = ?, Ubicacion = ?, Observaciones = ?,  Precio = ? "+
                    "WHERE inmuebles.Id_inmueble = ?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, inmueble.getId_inmueble());
            ps.setInt(2, inmueble.getTipoinmueble());
            ps.setInt(3, inmueble.getTipoperacion());
            ps.setInt(4, inmueble.getNum_recamaras());
            ps.setInt(5, inmueble.getNum_banos());
            ps.setInt(6, inmueble.getNum_medbanos());
            ps.setInt(7, inmueble.getNum_garage());
            ps.setBoolean(8, inmueble.getJardin());
            ps.setBoolean(9, inmueble.getAlberca());
            ps.setString(10, inmueble.getUbicacion());
            ps.setString(11, String.valueOf(inmueble.getObservaciones()));
            ps.setString(12, inmueble.getPrecio());

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

    public void eliminarRegistro(inmuebles inmueble){
        String sql = null;
        try {
            sql = "DELETE * FROM inmuebles "+
                    "WHERE inmuebles.inmueble = " + inmueble.getId_inmueble()+";";
            rs = connection.createStatement().executeQuery(sql);
            if (!rs.next())
                System.out.println("INMUEBLE NO ENCONTRADO");
            con.close(rs);
            con.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
