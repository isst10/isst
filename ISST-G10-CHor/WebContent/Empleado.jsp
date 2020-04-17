<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido, ${empleado.nombre}</title>
</head>
<body>

<h1>Bienvenido, ${empleado.nombre}</h1>

<h2>Horas</h2>
<table border="1">
<c:forEach items="${empleado.horas}" var="horasi">
<tr>
<td>${horasi.date}</td>
<td>${horasi.horas}</td>
<td>${horasi.proyecto}</td>
</tr>
</c:forEach>
</table>

<h2>Registrar Horas</h2>
<%@ include file = "FormRegistraHoras.jsp" %>

<h2>Salir de la aplicación</h2>
<%@ include file = "Logout.jsp" %>

</body>
</html>