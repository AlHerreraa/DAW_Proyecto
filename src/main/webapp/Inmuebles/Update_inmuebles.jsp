<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 01:34 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Tablas.inmuebles" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
    <title>Actualiza Inmuebles</title>
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
                <a href="#" class="logo"><img src="/DAW_Inmobiliaria/Maco.png" style="width: 150px; height: 43px;"/></a>
                <li><a href="/DAW_Inmobiliaria">Inicio</a></li>
                <li><a href="/DAW_Inmobiliaria/Agente/Menu_agente.jsp">Agentes</a></li>
                <li><a href="/DAW_Inmobiliaria/Cliente JSP/Menu_cliente.jsp">Clientes</a></li>
                <li><a href="/DAW_Inmobiliaria/Inmuebles/Menu_inmuebles.jsp">Inmuebles</a></li>
                <li><a href="/DAW_Inmobiliaria/Operacion/Menu_operacion.jsp">Operación</a></li>
                <li><a href="/DAW_Inmobiliaria/Rentas/Menu_rentas.jsp">Rentas</a></li>
                <li><a href="/DAW_Inmobiliaria/Tipo_Inmueble/Menu_tipoinmu.jsp">Tipo Inmuebles</a></li>
                <li><a href="/DAW_Inmobiliaria/Ventas/Menu_ventas.jsp">Ventas</a></li>
            </ul>
        </nav>
    </div>
</header>

<main class="main">
    <div class="container">
        <br/><br/><form method="post" action="/DAW_Inmobiliaria/Updateinmuebles">
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
            <input type="submit" value="Actualizar"/>
        </p>
    </form>

        <form action="/DAW_Inmobiliaria/Agente/Menu_inmuebles.jsp">
            <input type="submit" value="Regresar"/>
        </form>
    </div>
</main>
</body>
</html>