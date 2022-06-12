package Controlador.ventas;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import Tablas.ventas;
import Datos.ventasDAO;

@WebServlet(name = "Servletventas", urlPatterns = {"/Servletventas"})
public class Servletventas extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Connection connection = conexion.getConnection();
            ventasDAO VentaDAO = new ventasDAO(connection);
            ventas venta = new ventas();
            req.getSession().setAttribute("Datos", VentaDAO.Consulta(venta));
            connection.close();
        } catch (Exception e){
            req.getSession().setAttribute("Datos", new ArrayList<ventas>());
            e.printStackTrace();
        }
        resp.sendRedirect("/LibreriaCientifica/almacen.jsp"); // CHECAAAAAAAR
    }
}