<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido, ${empleado.nombre}</title>
<h1>Tienes como proyecto seleccionado:
	<c:if test="${empleado.proyecto == null}">
 		Ning�n proyecto seleccionado
 	</c:if>
 	${empleado.proyecto}
</h1>

</head>
<body>

<h1>Bienvenido, ${empleado.nombre}</h1>

<h2>Cambiar/Seleccionar proyecto</h2>
<form action="SeleccionarProyectoEmpleado">
	<select class="form-control" name="name">
  		<c:forEach items="${proyectos}" var="proyectoi">
  				<option>${proyectoi.name}</option>
  		</c:forEach>
	</select>
	<button type="submit">Asigna proyecto</button>
</form>

<h2>Registrar Horas</h2>
<%@ include file = "FormRegistraHoras.jsp" %>

<h2>Salir de la aplicaci�n</h2>
<%@ include file = "Logout.jsp" %>

</body>
</html>
