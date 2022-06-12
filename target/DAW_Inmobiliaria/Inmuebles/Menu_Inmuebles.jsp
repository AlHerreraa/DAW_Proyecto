<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 01:34 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menú Cliente</title>
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
        <br/><h1>Cliente</h1>
        <p>Maravillosos inmuebles que posee nuestro país. Están a la espera de un cliente.</p>
        <br>
        <form class="center" action="/DAW_Inmobiliaria/Inmuebles/inmuebles.jsp">
            <input type="submit" class=" opc opc-green" value="Lista de Clientes">
        </form><br>
        <form class="center" action="/DAW_Inmobiliaria/Inmuebles/Inserta_inmuebles.jsp">
            <input type="submit" class=" opc opc-green" value="Inserta Cliente">
        </form><br>
        <form class="center" action="/DAW_Inmobiliaria/Inmuebles/Update_inmuebles.jsp">
            <input type="submit" class=" opc opc-green" value="Actualiza Cliente">
        </form><br>
    </div><br>
</main>

<!-- <script src="../js/jquery-3.5.0.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/XMenWebProject/javaS1.js"></script>
</body>
</html>