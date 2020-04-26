<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Bienvenido, ${jefe.nombre}</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>  
</head>
<body>
<h1>Bienvenido, ${jefe.nombre}</h1>

<p><b>Número de proyectos activos: </b>${fn:length(jefe.proyectosJefe)}</p>

<h2>Proyectos</h2>
<table border="1">
<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
<tr>
<td>
<button>${proyectoi.name}</button>
</td>
<td>
<button ><span class="glyphicon glyphicon-remove-circle"></span></button>
</td>
</tr>
</c:forEach>
</table>

<h2>Registrar un nuevo proyecto</h2>
<%@ include file = "FormCreaProyecto.jsp" %>

<h2>Registrar Horas</h2>
<%@ include file = "FormRegistraHoras.jsp" %>

<h2>Salir de la aplicación</h2>
<%@ include file = "Logout.jsp" %>


</body>
</html>