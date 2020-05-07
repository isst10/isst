<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css">
<link href="css/estilos.css" rel= "stylesheet" type= "text/css"/>

<title>Proyecto</title>
</head>
<body>
<div class="card container container--md cd-tabs js-cd-tabs ">
		<div class="cd-tabs__panel text-component cd-tabs__panel--selected">
			<h1 class="text--xxl">${proyecto.name}</h1>

					<h2><b>Fecha de inicio: </b>${proyecto.fechaInicio}</h2>
					<h2><b>Fecha de Finalizaci�n: </b>${proyecto.fechaFin}</h2>
					<form action="ExtraerHorasProyecto" >
						<input style="height:45px; margin-top:5px;" type="submit" value="Ver horas registrdas"/>
					</form>

					<c:if test="${horasProyecto != null}">
					<table class="items-table">
				<tr>
					<th style="width:40%">EMPLEADO</th>
					<th style="width:30%">HORAS</th>
					<th style="width:30%">POYECTO</th>
				</tr>

					<c:forEach items="${horasProyecto}" var="horasi">
					<tr>
						<td>${horasi.getEmpleado().getNombre()}</td>
						<td>${horasi.horas}</td>
						<td>${horasi.proyecto}</td>
						<td>${horasi.date}</td>
					</tr>
					</c:forEach>

					<tr>
					<td><form action="FiltraEmpleado">
						<select class="form-control" name="name">
					  		<c:forEach items="${horasProyecto}" var="horasi">
					  				<option>${horasi.getEmpleado().getNombre()}</option>
					  		</c:forEach>
						</select>
						<button type="submit">Filtra</button>
					</form></td>
					</tr>

					</table>
					</c:if>


					<table>
					<form action="GenerarPDF">
						<input style="height:45px; margin-top:5px;" type="submit" value="Generar informe"/>
					</form>
					</table>


					<form action="volverAJefe">
						<input style="height:45px; margin-top:5px;" type="submit" value="Volver"/>
					</form>

					<!-- <input type="button"
					value="Volver"
					id="Back"
					name="Volver"
					onclick= "history.back()" /> -->


</body>
</html>
