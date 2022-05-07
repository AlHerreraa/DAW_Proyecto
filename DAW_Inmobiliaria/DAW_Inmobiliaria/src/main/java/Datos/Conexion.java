package Datos;

import javax.swing.*;
import java.sql.*;

public class Conexion {

    private static final String BD = "Immobiliaria";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + BD;
    private static final String USER = "postgres";
    private static final String PASSWORD = "alfredo";
    private static final String DRIVER = "org.postgresql.Driver";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("CONEXION ESTABLECIDA CON EXITO");
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return connection;
    }

    public void close(ResultSet rs) {
        try {
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(Statement stm) {
        try {
            stm.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(Connection connection) {
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
