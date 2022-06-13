package Datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    private static final String BD = "Inmobiliaria";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + BD;
    private static final String USER = "postgres";
    private static final String PASSWORD = "alfredo";
    private static final String DRIVER = "org.postgresql.Driver";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("ERROR AL CONECTAR... " + e);
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