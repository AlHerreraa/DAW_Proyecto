<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 10:11 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Tablas.ventas" %>

<html>
<head>
    <title>Ventas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/Diseno.css">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/style.css">
    <link rel="icon" href="/DAW_Inmobiliaria/Maco.png">
    <script src="https://kit.fontawesome.com/0458944bda.js" crossorigin="anonymous"></script>
</head>

<body background="/DAW_Inmobiliaria/fondodaw.jpg">

<header class="header">
    <div class="container logo-nav-container">
        <nav class="navigation">
            <ul class="show">
                <a href="#" class="logo"><img src="/DAW_Inmobiliaria/Maco.png" style="width: 150px; height: 43px;"/></a>
                <li><a href="/DAW_Inmobiliaria">Inicio</a></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Agente/Menu_agente.jsp">Agentes</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Cliente JSP/Menu_cliente.jsp">Clientes</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Inmuebles/Menu_inmuebles.jsp">Inmuebles</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Operacion/Menu_operacion.jsp">Operación</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Rentas/Menu_rentas.jsp">Rentas</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Tipo_Inmueble/Menu_tipoinmu.jsp">Tipo Inmuebles</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Ventas/Menu_ventas.jsp">Ventas</a></font></li>
            </ul>
        </nav>
    </div>
</header>

<main class="main">
    <div class="container">
        <center><h1>Lista de Clientes</h1></center>
        <table align="center">
            <thead>
            <tr>
                <th>ID Venta </th>
                <th>ID Inmueble </th>
                <th>Fecha venta </th>
                <th>ID Cliente </th>
                <th>ID Agente </th>
            </tr>
            </thead>
            <%
                ArrayList<ventas> lista = (ArrayList) session.getAttribute("Datos");
                if (lista != null){
                    for (ventas venta : lista){
            %><tr>
            <td><%out.print(venta.getId_venta()); %></td>
            <td><%out.print(venta.getIdInmuebles());%></td>
            <td><%out.print(venta.getFecha_venta());%></td>
            <td><%out.print(venta.getIdCliente());%></td>
            <td><%out.print(venta.getIdAgente());%></td>
        </tr><%
                }
            }
            else
                response.sendRedirect("/DAW_Inmobiliaria/Servletventas");
            session.removeAttribute("Datos");
        %>
        </table>
        <br/><form action="/DAW_Inmobiliaria/Rentas/Menu_venta.jsp">
        <input type="submit" value="Regresar"/>
    </form>
    </div>
</main>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>