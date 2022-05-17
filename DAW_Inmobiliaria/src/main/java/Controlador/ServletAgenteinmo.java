package Controlador;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAgenteinmo", urlPatterns = {"/ServletAgenteinmo"})
public class ServletAgenteinmo extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public ServletAgenteinmo() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().append("Served at: ").append(req.getContextPath());
        String Insertar = req.getParameter("Insertar");
        if ("Insertar".equals(Insertar)) {
            System.out.println("Opcion insertar seleccionada");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/webapp/insertar.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}