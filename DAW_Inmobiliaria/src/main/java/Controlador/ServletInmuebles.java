package Controlador;

import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletInmuebles", urlPatterns = {"/ServletInmuebles"})
public class ServletInmuebles extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public ServletInmuebles() {
        super();
    }

    @Override
    protected void doGet(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().append("Served at: ").append(req.getContextPath());
        String Insertar = req.getParameter("Insertar");
        if ("Insertar".equals(Insertar)) {
            System.out.println("Opcion insertar seleccionada");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/webapp/Insertar.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
