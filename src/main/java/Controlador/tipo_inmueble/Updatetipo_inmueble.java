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

@WebServlet(name = "Updatetipo_inmueble", urlPatterns = {"/Updatetipo_inmueble"})
public class Updatetipo_inmueble extends HttpServlet {

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
            tipo_inmueble ti = new tipo_inmueble(id_tipoinm, desc_inmueble);
            tiDAO.actualizarRegistro(ti);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/DAW_Inmobiliaria/update_almacen.jsp"); //CHECAR
    }
}