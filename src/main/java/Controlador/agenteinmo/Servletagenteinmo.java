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
import java.util.ArrayList;

@WebServlet(name = "Servletagenteinmo", urlPatterns = {"/Servletagenteinmo"})
public class Servletagenteinmo extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Connection connection = conexion.getConnection();
            agenteinmoDAO AgenteDAO = new agenteinmoDAO(connection);
            agenteinmo agente = new agenteinmo();
            req.getSession().setAttribute("Datos", AgenteDAO.Consulta(agente));
        } catch (Exception e){
            req.getSession().setAttribute("Datos", new ArrayList<agenteinmo>());
            e.printStackTrace();
        }
        resp.sendRedirect("/DAW_Inmobiliaria/agenteinmo.jsp");
    }
}