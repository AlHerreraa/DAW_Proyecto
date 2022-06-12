<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 08:18 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Tablas.agenteinmo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agentes</title>
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
        <center><h1>Lista de Agentes Inmobiliarios</h1></center>
        <table align="center">
            <thead>
            <tr>
                <th>ID Agente </th>
                <th>Nombre agente </th>
                <th>Apellido paterno </th>
                <th>Apellido materno </th>
                <th>Cantidad de inmuebles </th>
                <th>Telefono </th>
                <th>Celular </th>
                <th>Email </th>
            </tr>
            </thead>
            <%
                ArrayList<agenteinmo> lista = (ArrayList) session.getAttribute("Datos");
                if (lista != null){
                    for (agenteinmo agente : lista){
            %><tr>
            <td><%out.print(agente.getId_agente()); %></td>
            <td><%out.print(agente.getNombre());%></td>
            <td><%out.print(agente.getA_paterno());%></td>
            <td><%out.print(agente.getA_materno());%></td>
            <td><%out.print(agente.getCant_inmuebles());%></td>
            <td><%out.print(agente.getTelefono());%></td>
            <td><%out.print(agente.getCelular());%></td>
            <td><%out.print(agente.getEmail());%></td>

        </tr><%
                }
            }
            else{
                response.sendRedirect("/DAW_Inmobiliaria/Servletagenteinmo");
            }
            session.removeAttribute("Datos");
        %>
        </table>
        <br/><form action="/DAW_Inmobiliaria/Operacion/Menu_agente.jsp">
        <input type="submit" value="Regresar"/>
    </form>
    </div>
</main>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>