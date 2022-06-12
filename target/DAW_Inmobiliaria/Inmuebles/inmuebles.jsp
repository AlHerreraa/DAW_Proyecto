<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 01:33 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Tablas.inmuebles" %>

<html>
<head>
    <title>Inmuebles</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/Diseno.css">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/style.css">
    <link rel="icon" href="/DAW_Inmobiliaria/Maco.png">
    <script src="https://kit.fontawesome.com/0458944bda.js" crossorigin="anonymous"></script>
</head>

<body background="fondodaw.jpg">

<header class="header">
    <div class="container logo-nav-container">
        <nav class="navigation">
            <ul class="show">
                <a href="#" class="logo"><img src="../logo.png" style="width: 150px; height: 43px;"/></a>
                <li><a href="/DAW_Inmobiliaria">Inicio</a></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Agente/Menu_agente.jsp">Agentes</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Cliente JSP/Menu_cliente.jsp">Clientes</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Inmuebles/Menu_inmuebles.jsp">Inmuebles</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Operacion/Menu_operacion.jsp">Operación</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Rentas/Menu_renta.jsp">Rentas</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Tipo_Inmueble/Menu_tipoinmu.jsp">Tipo Inmuebles</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Ventas/Menu_venta.jsp">Ventas</a></font></li>
            </ul>
        </nav>
    </div>
</header>

<main class="main">
    <div class="container">
        <center><h1>Lista de Inmuebles</h1></center>
        <table align="center">
            <thead>
            <tr>
                <th>ID Inmueble </th>
                <th>Tipo Inmueble </th>
                <th>Tipo Operacion  </th>
                <th>Número de recamaras </th>
                <th>Número de banos </th>
                <th>Número de medios banos </th>
                <th>Espacio de Garaje </th>
                <th>Jardin </th>
                <th>Alberca </th>
                <th>Ubicación</th>
                <th>Observaciones</th>
                <th>Precio </th>
            </tr>
            </thead>
            <%
                ArrayList<inmuebles> lista = (ArrayList) session.getAttribute("Datos");
                if (lista != null){
                    for (inmuebles inmu : lista){
            %><tr>
            <td><%out.print(inmu.getId_inmueble()); %></td>
            <td><%out.print(inmu.getTipoinmueble());%></td>
            <td><%out.print(inmu.getTipoperacion());%></td>
            <td><%out.print(inmu.getNum_recamaras());%></td>
            <td><%out.print(inmu.getNum_banos());%></td>
            <td><%out.print(inmu.getNum_medbanos());%></td>
            <td><%out.print(inmu.getNum_garage());%></td>
            <td><%out.print(inmu.getJardin());%></td>
            <td><%out.print(inmu.getAlberca());%></td>
            <td><%out.print(inmu.getUbicacion());%></td>
            <td><%out.print(inmu.getObservaciones());%></td>
            <td><%out.print(inmu.getPrecio());%></td>
        </tr><%
                }
            }
            else
                response.sendRedirect("/DAW_Inmobiliaria/Servletinmuebles");
            session.removeAttribute("Datos");
        %>
        </table>
        <br/><form action="/DAW_Inmobiliaria/Operacion/Menu_inmuebles.jsp">
        <input type="submit" value="Regresar"/>
    </form>
    </div>
</main>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>
</html>