<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 08/06/2022
  Time: 08:13 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Tablas.agenteinmo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
  <title>Actualiza Agente Inmobiliario</title>
</head>
<body background="../fondodaw.jpg">
<main class="main">
  <div class="container">
    <form method="post" action="/DAW_Inmobiliaria/Updateagenteinmo">
      <p>ID Agente <input type="text" name = "id_agente"> </p>
      <p>Nombre agente <input type="text" name = "nombre"> </p>
      <p>Apellido paterno <input type="text" name = "a_paterno"> </p>
      <p>Apellido materno <input type="text" name = "a_materno"> </p>
      <p>Cantidad de inmuebles <input type="text" name = "cant_inmuebles"> </p>
      <p>Telefono <input type="text" name = "telefono"> </p>
      <p>Celular <input type="text" name = "celular"> </p>
      <p>Email <input type="text" name = "email"> </p>
      <p class="center-content">
        <input type="submit" value="Actualizar"/>
      </p>
    </form>

    <form action="../index.jsp">
      <input type="submit" value="Regresar"/>
    </form>
  </div>
</main>
</body>
</html>
