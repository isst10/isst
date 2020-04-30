<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css">

<title>Bienvenido, ${jefe.nombre}</title>
</head>
<body>

<p><b>N�mero de proyectos: </b>${fn:length(jefe.proyectosJefe)}</p>

<h2>Proyectos Activos</h2>
<table border="1">
<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
<tr>
<c:if test="${proyectoi.fechaFin == null}">
	<td>${proyectoi.name}</td>
	<td>${proyectoi.fechaInicio}</td>
	<td>
		<form action="VerProyecto">
			<input type="hidden" name="name" value='${proyectoi.name}'>
			<button type="submit">Ver</button>
		</form>
	</td>
</c:if>
</tr>
</c:forEach>
</table>


<h2>Proyectos Terminados</h2>
<table border="1">
<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
<tr>
<c:if test="${proyectoi.fechaFin != null}">
	<td>${proyectoi.name}</td>
	<td>${proyectoi.fechaInicio}</td>
	<td>${proyectoi.fechaFin}</td>
	<td>
		<form action="VerProyecto">
			<input type="hidden" name="name" value='${proyectoi.name}'>
			<button type="submit">Ver</button>
		</form>
	</td>
</c:if>
</tr>
</c:forEach>
</table>


<h2>Registrar un nuevo proyecto</h2>
<%@ include file = "FormCreaProyecto.jsp" %>

<h2>Finalizar proyecto</h2>
<form action="FinalizarProyecto">
	<select class="form-control" name="name">
  		<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
  			<c:if test="${proyectoi.fechaFin == null}">
  				<option>${proyectoi.name}</option>
  			</c:if>
  		</c:forEach>
	</select>
	<button type="submit">Finalizar proyecto</button>
</form>

<h2>Borrar proyecto</h2>
<form action="EliminarProyecto">
	<select class="form-control" name="name">
  		<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
  			<option>${proyectoi.name}</option>
  		</c:forEach>
	</select>
	<button type="submit">Borrar proyecto</button>
</form>

<!-- <h2>Registrar Horas</h2> -->
<%-- <%@ include file = "FormRegistraHoras.jsp" %> --%>

<h2>Salir de la aplicaci�n</h2>
<%@ include file = "Logout.jsp" %>


</div>
<div class="flex--center">
<%@ include file = "Logout.jsp" %>
</div>
</div>
</body>
</html>
