<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
</head>
<body>

<h1>${proyecto.name}</h1>

<p><b>Fecha de inicio: </b>${proyecto.fechaInicio}</p>
<p><b>Fecha de Finalización: </b>${proyecto.fechaFin}</p>
<h2>Extraer horas trabajadas por los empleados</h2>
<!-- <form action="ExtraerHorasProyecto">
	<button type="submit">Ver horas dedicadas</button>
</form> -->









<input type="button"
value="Volver"
id="Back"
name="Volver"
onclick= "history.back()" />
</body>
</html>