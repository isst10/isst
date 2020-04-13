<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<h2>Admin</h2>
<p><b>Número de empleados activos: </b>${fn:length(empleados)}</p>
<p><b>Número de jefes activos: </b>${fn:length(jefes)}</p>
<p><b>Número de proyectos activos: </b>${fn:length(proyectos)}</p>

<h2>Jefes</h2>
<table border="1">
<c:forEach items="${jefes}" var="jefei">
<tr>
<td>${jefei.nombre}</td>
<td>${jefei.email}</td>
</tr>
</c:forEach>
</table>

<h2>Empleados</h2>
<table border="1">
<c:forEach items="${empleados}" var="empleadoi">
<tr>
<td>${empleadoi.nombre}</td>
<td>${empleadoi.email}</td>
</tr>
</c:forEach>
</table>


<h2>Proyectos</h2>
<table border="1">
<c:forEach items="${proyectos}" var="proyectoi">
<tr>
<td>${proyectoi.name}</td>
</tr>
</c:forEach>
</table>

<h2>Registrar un nuevo jefe</h2>
<%@ include file = "FormCreaJefe.jsp" %>

<h2>Registrar un nuevo empleado</h2>
<%@ include file = "FormCreaEmpleado.jsp" %>

<h2>Eliminar un usuario</h2>
<%@ include file = "FormEliminaUsuario.jsp" %>

<h2>Salir de la aplicacion</h2>
<%@ include file = "Logout.jsp" %>

</body>
</html>