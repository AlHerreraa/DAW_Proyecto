package Controlador.cliente;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import Tablas.cliente;
import Datos.clienteDAO;

@WebServlet(name = "Servletcliente", urlPatterns = {"/Servletcliente"})
public class Servletcliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Connection connection = conexion.getConnection();
            clienteDAO ClienteDAO = new clienteDAO(connection);
            cliente agente = new cliente();
            req.getSession().setAttribute("Datos", ClienteDAO.Consulta(agente));
            connection.close();
        } catch (Exception e){
            req.getSession().setAttribute("Datos", new ArrayList<cliente>());
            e.printStackTrace();
        }
        resp.sendRedirect("/LibreriaCientifica/almacen.jsp"); // CHECAAAAAAAR
    }
}
