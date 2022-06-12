<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 01:15 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Tablas.cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
    <title>Actualiza Cliente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/Diseno.css">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/style.css">
    <link rel="icon" href="/DAW_Inmobiliaria/Maco.png">
</head>
<body background="../fondo.jpg">

<header class="header">
    <div class="container logo-nav-container">
        <nav class="navigation">
            <ul class="show">
                <a href="#" class="logo"><img src="../logo.png" style="width: 150px; height: 43px;"/></a>
                <li><a href="/LibreriaCientifica">Inicio</a></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Agente/menu_almacen.jsp">Agente</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Cliente JSP/menu_autores.jsp">Autor</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Cargo/menu_cargo.jsp">Cargo</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Cliente/menu_cliente.jsp">Cliente</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Editorial/menu_editorial.jsp">Editorial</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Empleado/menu_empleado.jsp">Empleado</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Estante/menu_estante.jsp">Estante</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Idioma/menu_idioma.jsp">Idioma</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Libros/menu_libros.jsp">Libros</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/Materia/menu_materia.jsp">Materia</a></font></li>
                <li><font face="times new roman" size="5px"><a href="/DAW_Inmobiliaria/NotaVenta/menu_notaventa.jsp">Nota</a></font></li>

            </ul>
        </nav>
    </div>
</header>

<main class="main">
    <div class="container">
        <br/><br/><form method="post" action="/LibreriaCientifica/UpdateCliente">
        <p>Código Cliente <input type="text" name = "codCliente"> </p>
        <p>Nombre <input type="text" name = "nombre"> </p>
        <p>Apellido Paterno <input type="text" name = "aPaterno"> </p>
        <p>Apellido Materno <input type="text" name = "aMaterno"> </p>
        <p>Correo <input type="text" name = "correo"> </p>
        <p>Telefono <input type="text" name = "telefono"> </p>
        <p>Status <input type="text" name = "status"> </p>
        <p class="center-content">
            <input type="submit" value="Actualizar"/>
        </p>
    </form>

        <form action="/LibreriaCientifica/Cliente/menu_cliente.jsp">
            <input type="submit" value="Regresar"/>
        </form>
    </div>
</main>
</body>
</html>