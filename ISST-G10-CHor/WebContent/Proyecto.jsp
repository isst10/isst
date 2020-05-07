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
<form action="ExtraerHorasProyecto">
	<button type="submit">Ver horas dedicadas</button>
</form>

<c:if test="${horasProyecto != null}">
<table border="1">
<tr>
	<th>Empleado</th>
	<th>Horas</th>
	<th>proyecto</th>
	<th>Fecha</th>
	
</tr>
<c:forEach items="${horasProyecto}" var="horasi">
<tr>
	<td>${horasi.getEmpleado().getNombre()}</td>
	<td>${horasi.horas}</td>
	<td>${horasi.proyecto}</td>
	<td>${horasi.date.getDay()}</td>
</tr>
</c:forEach>

<tr>
<td><p>Filtrar por empleado</p></td>
<td><form action="FiltraEmpleado">
	<select class="form-control" name="name">
  		<c:forEach items="${horasProyecto}" var="horasi">
  				<option>${horasi.getEmpleado().getNombre()}</option>
  		</c:forEach>
	</select>
	<button type="submit">Filtra</button>
</form></td>
<td><p>Exportar ("No pulsar aún sin hacer")</p></td>
<td><form action="ExportarDatos">
	<button type="submit">Exportar</button>
</form></td>
</tr>

</table>
</c:if>
<script>
	function usuarioRegistrado(){
		alert("Introduce tus credenciales");
	}
</script>

<table>
<form action="GenerarPDF">
	<button type="submit" name="generarpdf" onCLick ="return usuarioRegistrado()">Generar PDF</button>
</form>
</table>



<input type="button"
value="Volver"
id="Back"
name="Volver"
onclick= "history.back()" /> 


</body>
</html>