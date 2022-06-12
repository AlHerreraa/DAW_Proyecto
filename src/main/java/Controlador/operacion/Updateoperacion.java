package Controlador.operacion;

import Datos.operacionDAO;
import Tablas.operacion;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Updateoperacion", urlPatterns = {"/Updateoperacion"})
public class Updateoperacion extends HttpServlet {

    private int tipo_operacion;
    private String desc_operacion;

    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        tipo_operacion = Integer.parseInt(req.getParameter("tipo_operacion"));
        desc_operacion = req.getParameter("desc_operacion");

        try{
            Connection connection = conexion.getConnection();
            operacionDAO OperacionDAO = new operacionDAO(connection);
            operacion op = new operacion(tipo_operacion, desc_operacion);
            OperacionDAO.actualizarRegistro(op);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/LibreriaCientifica/update_almacen.jsp"); //CHECAR
    }
}