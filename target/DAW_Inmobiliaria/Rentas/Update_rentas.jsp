<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 09/06/2022
  Time: 10:37 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualiza Rentas</title>
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
        <br/><br/><form method="post" action="/DAW_Inmobiliaria/Updateoperacion">
        <p>ID Renta<input type="text" name = "id_renta"> </p>
        <p>ID Inmueble <input type="text" name = "id_Inmueble"> </p>
        <p>Fecha de renta <input type="text" name = "fecha_renta"> </p>
        <p>ID Cliente <input type="text" name = "id_Cliente"> </p>
        <p>ID Agente <input type="text" name = "id_Agente"> </p>
        <p class="center-content">
            <input type="submit" value="Actualizar"/>
        </p>
    </form>

        <form action="/DAW_Inmobiliaria/Agente/Menu_rentas.jsp">
            <input type="submit" value="Regresar"/>
        </form>
    </div>
</main>
</body>
</html>
