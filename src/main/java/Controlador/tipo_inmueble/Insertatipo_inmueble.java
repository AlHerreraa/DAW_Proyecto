package Controlador.tipo_inmueble;

import Datos.tipo_inmuebleDAO;
import Tablas.tipo_inmueble;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Insertatipo_inmueble", urlPatterns = {"/Insertatipo_inmueble"})
public class Insertatipo_inmueble extends HttpServlet {

    private int id_tipoinm;
    private String desc_inmueble;
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id_tipoinm = Integer.parseInt(req.getParameter("id_tipoinm"));
        desc_inmueble = req.getParameter("desc_inmueble");

        try{
            Connection connection = conexion.getConnection();
            tipo_inmuebleDAO tiDAO = new tipo_inmuebleDAO(connection);
            tipo_inmueble tipo = new tipo_inmueble(id_tipoinm, desc_inmueble);
            tiDAO.insertarRegistro(tipo);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/LibreriaCientifica/inserta_almacen.jsp"); // CHECAAAAAR
    }
}