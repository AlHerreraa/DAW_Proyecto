<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 10:42 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Tablas.ventas" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<html>
<head>
    <title>Inserta Venta</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/Diseno.css">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/style.css">
    <link rel="icon" href="/DAW_Inmobiliaria/Maco.png">
</head>

<body background="/DAW_Inmobiliaria/fondodaw.jpg">

<header class="header">
    <div class="container logo-nav-container">
        <nav class="navigation">
            <ul class="show">
                <a href="#" class="logo"><img src="DAW_Inmobiliaria/Maco.png" style="width: 150px; height: 43px;"/></a>
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
        <form method="post" action="/DAW_Inmobiliaria/Insertaoperacion">
            <p>ID Venta<input type="text" name = "id_venta"> </p>
            <p>ID Inmueble <input type="text" name = "idInmuebles"> </p>
            <p>Fecha de venta <input type="text" name = "fecha_venta"> </p>
            <p>ID Cliente <input type="text" name = "idCliente"> </p>
            <p>ID Agente <input type="text" name = "idAgente"> </p>
            <p class="center-content">
                <input type="submit" value="Ingresar"/>
            </p>
        </form>

        <form action="/DAW_Inmobiliaria/Operacion/Menu_ventas.jsp">
            <input type="submit" value="Regresar"/>
        </form>
    </div>
</main>
</body>
</html>
