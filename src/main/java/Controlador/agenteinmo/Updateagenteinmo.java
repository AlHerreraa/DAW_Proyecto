package Controlador.agenteinmo;

import Datos.agenteinmoDAO;
import Tablas.agenteinmo;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Updateagenteinmo", urlPatterns = {"/Updateagenteinmo"})
public class Updateagenteinmo extends HttpServlet {
    private int id_agente;
    private String nombre;
    private String a_paterno;
    private String a_materno;
    private int cant_inmuebles;
    private String telefono;
    private String celular;
    private String email;

    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id_agente = Integer.parseInt(req.getParameter("id_agente"));
        nombre = req.getParameter("nombre");
        a_paterno = req.getParameter("a_paterno");
        a_materno = req.getParameter("a_materno");
        cant_inmuebles = Integer.parseInt(req.getParameter("cant_inmuebles"));
        telefono = req.getParameter("telefono");
        celular = req.getParameter("celular");
        email = req.getParameter("email");

        try{
            Connection connection = conexion.getConnection();
            agenteinmoDAO agenteInmoDAO = new agenteinmoDAO(connection);
            agenteinmo agente = new agenteinmo(id_agente, nombre, a_paterno,a_materno, cant_inmuebles, telefono, celular, email);
            agenteInmoDAO.Actualizar(agente);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/LibreriaCientifica/Update_agente.jsp"); //CHECAR
    }
}