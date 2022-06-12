<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 02:29 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Tablas.operacion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
    <title>Insertar Cliente</title>
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
        <form method="post" action="/DAW_Inmobiliaria/Insertaoperacion">
            <p>Tipo de Operación (ID)<input type="text" name = "tipo_operacion"> </p>
            <p>Descripcion <input type="text" name = "desc_operacion"> </p>
            <p class="center-content">
                <input type="submit" value="Ingresar"/>
            </p>
        </form>

        <form action="/DAW_Inmobiliaria/Operacion/Menu_operacion.jsp">
            <input type="submit" value="Regresar"/>
        </form>
    </div>
</main>
</body>
</html>