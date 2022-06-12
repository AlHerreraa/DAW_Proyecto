package Controlador.inmuebles;

import Datos.inmueblesDAO;
import Tablas.inmuebles;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Updateinmuebles", urlPatterns = {"/Updateinmuebles"})
public class Updateinmuebles extends HttpServlet {

    private int id_inmueble;
    private int tipoinmueble;
    private int tipoperacion;
    private int num_recamaras;
    private int num_banos;
    private int num_medbanos;
    private int num_garage;
    private Boolean jardin;
    private Boolean alberca;
    private String ubicacion;
    private String observaciones;
    private String precio;

    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        id_inmueble = Integer.parseInt(req.getParameter("id_inmueble"));
        tipoinmueble = Integer.parseInt(req.getParameter("tipoinmueble"));
        tipoperacion = Integer.parseInt(req.getParameter("tipoperacion"));
        num_recamaras = Integer.parseInt(req.getParameter("num_recamaras"));
        num_banos = Integer.parseInt(req.getParameter("num_banos"));
        num_medbanos = Integer.parseInt(req.getParameter("num_medbanos"));
        num_garage = Integer.parseInt(req.getParameter("num_garage"));
        jardin = Boolean.parseBoolean(req.getParameter("jardin"));
        alberca = Boolean.parseBoolean(req.getParameter("alberca"));
        ubicacion = req.getParameter("ubicacion");
        observaciones = req.getParameter("observaciones");
        precio = req.getParameter("precio");

        try{
            Connection connection = conexion.getConnection();
            inmueblesDAO InmueblesDAO = new inmueblesDAO(connection);
            inmuebles persona = new inmuebles(id_inmueble, tipoinmueble, tipoperacion,num_recamaras, num_banos, num_medbanos, num_garage, jardin, alberca, ubicacion, observaciones, precio);
            InmueblesDAO.actualizarRegistro(persona);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/LibreriaCientifica/update_almacen.jsp"); //CHECAR
    }
}