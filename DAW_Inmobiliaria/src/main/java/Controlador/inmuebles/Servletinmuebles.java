package Controlador.inmuebles;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import Tablas.inmuebles;
import Datos.inmueblesDAO;

@WebServlet(name = "Servletinmuebles", urlPatterns = {"/Servletinmuebles"})
public class Servletinmuebles extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Connection connection = conexion.getConnection();
            inmueblesDAO InmueblesDAO = new inmueblesDAO(connection);
            inmuebles inmu = new inmuebles();
            req.getSession().setAttribute("Datos", InmueblesDAO.seleccionarRegistro(inmu));
            connection.close();
        } catch (Exception e){
            req.getSession().setAttribute("Datos", new ArrayList<inmuebles>());
            e.printStackTrace();
        }
        resp.sendRedirect("/LibreriaCientifica/almacen.jsp"); // CHECAAAAAAAR
    }
}