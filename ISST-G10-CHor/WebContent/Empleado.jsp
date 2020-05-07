<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css">

<title>Bienvenido, ${empleado.nombre}</title>
</head>
<body>
<div class="card container container--md cd-tabs js-cd-tabs ">
		<div class="cd-tabs__panel text-component cd-tabs__panel--selected">
		<div class="container flex--center-x"><div><h1 class="text--xxl">Bienvenido, ${empleado.nombre}</h1>
			<div><%@ include file = "Logout.jsp" %></div></div>
					<h2>Tienes como proyecto seleccionado:
						<c:if test="${empleado.proyecto == null}">
					 		Ningún proyecto seleccionado
					 	</c:if>
					 	${empleado.proyecto}
					</h2>
					
					<h2>Seleccionar proyecto</h2>
					<form action="SeleccionarProyectoEmpleado">
						<select class="form-control" name="name">
					  		<c:forEach items="${proyectos}" var="proyectoi">
					  							<c:if test="${proyectoi.terminado == false}">
					  				<option>${proyectoi.name}</option>
												</c:if>
					  		</c:forEach>
						</select>
						<button type="submit">Asigna proyecto</button>
					</form>

					<h2>Registrar Horas</h2>
					<%@ include file = "FormRegistraHoras.jsp" %>
					<c:if test="${flag}">
						<p>Se han registrado sus horas correctamente</p>
					</c:if>
			</div>
		</div>
	</div>
</body>
</html>
