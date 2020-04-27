<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Bienvenido, ${jefe.nombre}</title>
</head>
<body>
<h1>Bienvenido, ${jefe.nombre}</h1>

<p><b>Número de proyectos activos: </b>${fn:length(jefe.proyectosJefe)}</p>

<h2>Proyectos</h2>
<table border="1">
<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
<tr>
<td>${proyectoi.name}</td>
<td>${proyectoi.fechaInicio}</td>
<td>${proyectoi.fechaFin}</td>
</tr>
</c:forEach>
</table>


<h2>Registrar un nuevo proyecto</h2>
<%@ include file = "FormCreaProyecto.jsp" %>

<h2>Finalizar proyecto</h2>
<form action="FinalizarProyecto">
	<!-- <input type="text" name="name" placeholder="Nombre proyecto"> -->
	
	<select class="form-control" name="name">
  		<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
  			<option>${proyectoi.name}</option>
  		</c:forEach>	
	</select>
	<button type="submit">Finalizar proyecto</button>
</form>

<h2>Borrar proyecto</h2>
<form action="EliminarProyecto">
	<!-- <input type="text" name="name" placeholder="Nombre proyecto"> -->
	
	<select class="form-control" name="name">
  		<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
  			<option>${proyectoi.name}</option>
  		</c:forEach>	
	</select>
	<button type="submit">Borrar proyecto</button>
</form>

<!-- <h2>Registrar Horas</h2> -->
<%-- <%@ include file = "FormRegistraHoras.jsp" %> --%>

<h2>Salir de la aplicación</h2>
<%@ include file = "Logout.jsp" %>


</body>
</html>