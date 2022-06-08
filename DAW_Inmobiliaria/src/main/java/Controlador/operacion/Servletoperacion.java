package Controlador.operacion;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import Tablas.operacion;
import Datos.operacionDAO;

@WebServlet(name = "Servletoperacion", urlPatterns = {"/Servletoperacion"})
public class Servletoperacion extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Connection connection = conexion.getConnection();
            operacionDAO OperacionDAO = new operacionDAO(connection);
            operacion inmu = new operacion();
            req.getSession().setAttribute("Datos", OperacionDAO.seleccionarRegistro(inmu));
            connection.close();
        } catch (Exception e){
            req.getSession().setAttribute("Datos", new ArrayList<operacion>());
            e.printStackTrace();
        }
        resp.sendRedirect("/LibreriaCientifica/almacen.jsp"); // CHECAAAAAAAR
    }
}