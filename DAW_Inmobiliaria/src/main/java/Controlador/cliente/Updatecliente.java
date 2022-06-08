package Controlador.cliente;

import Datos.clienteDAO;
import Tablas.cliente;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Updatecliente", urlPatterns = {"/Updatecliente"})
public class Updatecliente extends HttpServlet {

    private int id_cliente;
    private String nombre_cliente;
    private String a_paterno;
    private String a_materno;
    private String telefono;
    private String celular;
    private String email;

    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id_cliente = Integer.parseInt(req.getParameter("id_cliente"));
        nombre_cliente = req.getParameter("nombre_cliente");
        a_paterno = req.getParameter("a_paterno");
        a_materno = req.getParameter("a_materno");
        telefono = req.getParameter("telefono");
        celular = req.getParameter("celular");
        email = req.getParameter("email");

        try{
            Connection connection = conexion.getConnection();
            clienteDAO ClienteDAO = new clienteDAO(connection);
            cliente persona = new cliente(id_cliente, nombre_cliente, a_paterno,a_materno, telefono, celular, email);
            ClienteDAO.Actualizar(persona);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/LibreriaCientifica/update_almacen.jsp"); //CHECAR
    }
}