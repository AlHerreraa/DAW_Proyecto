package Controlador.rentas;

import Datos.rentasDAO;
import Tablas.rentas;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Updaterentas", urlPatterns = {"/Updaterentas"})
public class Updaterentas extends HttpServlet {

    private int id_renta;
    private int id_Inmueble;
    private String fecha_renta;
    private int id_Cliente;
    private int id_Agente;

    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        id_renta = Integer.parseInt(req.getParameter("id_renta"));
        id_Inmueble = Integer.parseInt(req.getParameter("id_Inmueble"));
        fecha_renta = req.getParameter("fecha_renta");
        id_Cliente = Integer.parseInt(req.getParameter("id_Cliente"));
        id_Agente = Integer.parseInt(req.getParameter("id_Agente"));

        try{
            Connection connection = conexion.getConnection();
            rentasDAO RentasDAO = new rentasDAO(connection);
            rentas renta = new rentas(id_renta, id_Inmueble, fecha_renta, id_Cliente, id_Agente);
            RentasDAO.Actualizar(renta);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/LibreriaCientifica/update_almacen.jsp"); //CHECAR
    }
}