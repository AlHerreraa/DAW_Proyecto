<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 01:33 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Tablas.inmuebles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
    <title>Insertar Inmueble</title>
</head>
<body background="../fondodaw.jpg">

<header class="header">
    <div class="container logo-nav-container">
        <nav class="navigation">
            <ul class="show">
                <a href="#" class="logo"><img src="../logo.png" style="width: 150px; height: 43px;"/></a>
                <li><a href="/DAW_Inmobiliaria">Inicio</a></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Agente/menu_almacen.jsp">Agentes</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Cliente JSP/menu_autores.jsp">Clientes</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Inmuebles/menu_cargo.jsp">Inmuebles</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Operacion/menu_cliente.jsp">Operación</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Rentas/menu_editorial.jsp">Rentas</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Tipo_Inmueble/Menu_tipoinmu.jsp">Tipo Inmuebles</a></font></li>
                <li><font face="Arial" size="5px"><a href="/DAW_Inmobiliaria/Ventas/Menu_ventas.jsp">Ventas</a></font></li>
            </ul>
        </nav>
    </div>
</header>

<main class="main">
    <div class="container">
        <form method="post" action="/DAW_Inmobiliaria/Insertainmuebles">
            <p>ID Inmueble <input type="text" name = "id_inmueble"> </p>
            <p>Tipo inmueble <input type="text" name = "tipo_inmuele"> </p>
            <p>Tipo Operacion <input type="text" name = "tipo_operacion"> </p>
            <p>Número de recamaras <input type="text" name = "num_recamaras"> </p>
            <p>Número de banos <input type="text" name = "num_banos"> </p>
            <p>Número de medios banos <input type="text" name = "num_medbanos"> </p>
            <p>Espacio de Garaje <input type="text" name = "num_garage"> </p>
            <p>Jardin <input type="text" name = "jardin"> </p>
            <p>Alberca <input type="text" name = "alberca"> </p>
            <p>Ubicación <input type="text" name = "ubicacion"> </p>
            <p>Observaciones <input type="text" name = "observaciones"> </p>
            <p>Precio <input type="text" name = "precio"> </p>

            <p class="center-content">
                <input type="submit" value="Ingresar"/>
            </p>
        </form>

        <form action="/DAW_Inmobiliaria/Inmuebles/Menu_inmuebles.jsp">
            <input type="submit" value="Regresar"/>
        </form>
    </div>
</main>
</body>
</html>
