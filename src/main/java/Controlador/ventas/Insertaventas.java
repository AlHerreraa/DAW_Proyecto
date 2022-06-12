package Controlador.ventas;

import Datos.ventasDAO;
import Tablas.ventas;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Insertaventas", urlPatterns = {"/Insertaventas"})
public class Insertaventas extends HttpServlet {

    private int id_venta;
    private int idInmuebles;
    private String fecha_venta;
    private int idCliente;
    private int idAgente;

    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id_venta = Integer.parseInt(req.getParameter("id_venta"));
        idInmuebles = Integer.parseInt(req.getParameter("idInmuebles"));
        fecha_venta = req.getParameter("fecha_venta");
        idCliente = Integer.parseInt(req.getParameter("idCliente"));
        idAgente = Integer.parseInt(req.getParameter("idAgente"));

        try{
            Connection connection = conexion.getConnection();
            ventasDAO VentaDAO = new ventasDAO(connection);
            ventas venta = new ventas(id_venta, idInmuebles, fecha_venta, idCliente, idAgente);
            VentaDAO.Insertar(venta);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/DAW_Inmobiliaria/inserta_almacen.jsp"); // CHECAAAAAR
    }
}