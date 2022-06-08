package Controlador.rentas;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import Tablas.rentas;
import Datos.rentasDAO;

@WebServlet(name = "Servletrentas", urlPatterns = {"/Servletrentas"})
public class Servletrentas extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Connection connection = conexion.getConnection();
            rentasDAO RentasDAO = new rentasDAO(connection);
            rentas renta = new rentas();
            req.getSession().setAttribute("Datos", RentasDAO.Consulta(renta));
            connection.close();
        } catch (Exception e){
            req.getSession().setAttribute("Datos", new ArrayList<rentas>());
            e.printStackTrace();
        }
        resp.sendRedirect("/LibreriaCientifica/almacen.jsp"); // CHECAAAAAAAR
    }
}