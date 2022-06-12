package Controlador.tipo_inmueble;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import Tablas.tipo_inmueble;
import Datos.tipo_inmuebleDAO;

@WebServlet(name = "Servlettipo_inmueble", urlPatterns = {"/Servlettipo_inmueble"})
public class Servlettipo_inmueble extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Connection connection = conexion.getConnection();
            tipo_inmuebleDAO tiDAO = new tipo_inmuebleDAO(connection);
            tipo_inmueble tipo = new tipo_inmueble();
            req.getSession().setAttribute("Datos", tiDAO.seleccionarRegistro(tipo));
            connection.close();
        } catch (Exception e){
            req.getSession().setAttribute("Datos", new ArrayList<tipo_inmueble>());
            e.printStackTrace();
        }
        resp.sendRedirect("/DAW_Inmobiliaria/almacen.jsp"); // CHECAAAAAAAR
    }
}