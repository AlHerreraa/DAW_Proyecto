<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 01:28 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menú Almacén</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/Diseno.css">
    <link rel="stylesheet" href="/DAW_Inmobiliaria/Opcion.css">
    <link rel="icon" href="../Maco.png"/>
    <script src="https://kit.fontawesome.com/0458944bda.js" crossorigin="anonymous"></script>
</head>
<body background="/DAW_Inmobiliaria/fondodaw.jpg">
<header class="header">
    <div class="container logo-nav-container">
        <nav class="navigation">
            <ul class="show">
                <a href="#" class="logo"><img src="../logo.png" style="width: 150px; height: 43px;"/></a>
                <li><a href="/DAW_Inmobiliaria">Inicio</a></li>
                <li><a href="/DAW_Inmobiliaria/Agente/Menu_agente.jsp">Agentes</a></li>
                <li><a href="/DAW_Inmobiliaria/Cliente JSP/Menu_cliente.jsp">Clientes</a></li>
                <li><a href="/DAW_Inmobiliaria/Inmuebles/Menu_inmuebles.jsp">Inmuebles</a></li>
                <li><a href="/DAW_Inmobiliaria/Operacion/Menu_operacion.jsp">Operaaciones</a></li>
                <li><a href="/DAW_Inmobiliaria/Rentas/Menu_rentas.jsp">Rentas</a></li>
                <li><a href="/DAW_Inmobiliaria/Tipo_Inmueble/Menu_tipoinmu.jsp">Tipo Inmuebles</a></li>
                <li><a href="/DAW_Inmobiliaria/Ventas/Menu_ventas.jsp">Ventas</a></li>
            </ul>
        </nav>
    </div>
</header>

<main class="main">
    <div class="container">
        <br/><h1>Almacen</h1>
        <p>Persona especializada en el ambito inmobiliario. Puede tener muchos inmuebles para distintas operaciones </p>
        <br>
        <form class="center" action="/DAW_Inmobiliaria/Agente/agente.jsp">
            <input type="submit" class=" opc opc-green" value="Lista de Almacen">
        </form><br>

        <form class="center" action="/DAW_Inmobiliaria/Agente/Inserta_agente.jsp">
            <input type="submit" class=" opc opc-green" value="Inserta Almacen">
        </form><br>
        <form class="center" action="/DAW_Inmobiliaria/Agente/Update_agente.jsp">
            <input type="submit" class=" opc opc-green" value="Actualiza Almacen">
        </form>

    </div><br>
</main>

<!-- <script src="../js/jquery-3.5.0.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/XMenWebProject/javaS1.js"></script>
</body>
</html>
