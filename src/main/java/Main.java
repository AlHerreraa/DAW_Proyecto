import Datos.Conexion;
import Datos.agenteinmoDAO;
import Tablas.agenteinmo;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        Connection connection = null;

        agenteinmo agente = new agenteinmo();
        agenteinmoDAO agenteinmoDAO = new agenteinmoDAO(connection);
        agenteinmoDAO.getAgenteinmo( 1);
    }
}
