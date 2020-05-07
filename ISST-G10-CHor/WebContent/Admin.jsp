<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css">
<title>Admin</title>
</head>
<body>
<div class="card container container--md cd-tabs js-cd-tabs ">
		<div class="cd-tabs__panel text-component cd-tabs__panel--selected">
		<div class="container flex--center-x"><div><h1 class="text--xxl">ADMIN</h1>
			<div><%@ include file = "Logout.jsp" %></div></div>

			<p><b>Número de empleados activos: </b>${fn:length(empleados)}</p>
			<p><b>Número de jefes activos: </b>${fn:length(jefes)}</p>
			<p><b>Número de proyectos activos: </b>${fn:length(proyectos)}</p>

				<h2>Jefes</h2>
				<table class="items-table">
				<tr>
					<th style="width:45%">NOMBRE</th>
					<th style="width:45%">EMAIL</th>
					<th style="width:10%"></th>
				</tr>
				<c:forEach items="${jefes}" var="jefei">
				<tr>
					<td>${jefei.nombre}</td>
					<td><form action="verUsuario">
						<input type="hidden" name="email" value='${jefei.email}'>
						<button type="submit">${jefei.email}</button>
					</form></td>
					<td>
					<form action="EliminaUsuario" method="post">
			     		 <input type=hidden name="email" value="${jefei.email}"  />
						 <input type="image" style="height:25px; width:25px;padding:0px;border:none;margin:0px;"  src="images/trash_icon.png" id="deleteproyecto"  />
					</form>
				</td>
				</tr>
				</c:forEach>
				</table>

				<h2>Empleados</h2>
				<table class="items-table">
				<tr>
					<th style="width:45%">NOMBRE</th>
					<th style="width:45%">EMAIL</th>
					<th style="width:10%"></th>
				</tr>
				<c:forEach items="${empleados}" var="empleadoi">
				<tr>
					<td><form action="verUsuario">
						<input type="hidden" name="email" value='${empleadoi.email}'>
						<button type="submit">${empleadoi.nombre}</button>
					</form></td>
					<td>${empleadoi.email}</td>
					<td>
					<form action="EliminaUsuario" method="post">
			     		 <input type=hidden name="email" value="${empleadoi.email}"  />
						 <input type="image" style="height:25px; width:25px;padding:0px;border:none;margin:0px;"  src="images/trash_icon.png" id="deleteproyecto"  />
					</form>
					</td>
				</tr>
				</c:forEach>
				</table>


				<h2>Proyectos</h2>
				<table class="items-table">
				<tr>
					<th style="width:45%">Proyecto</th>
					<th style="width:15%">Desde</th>
					<th style="width:15%">Hasta</th>
					<th style="width:20%">Finalizar</th>
					<th style="width:5%"></th>
				</tr>
				<c:forEach items="${proyectos}" var="proyectoi">
				<tr>
				<td>
					<form action="VerProyecto">
						<input type="hidden" name="name" value='${proyectoi.name}'>
						<button type="submit">${proyectoi.name}</button>
					</form>
				</td>
				<td>
					<jsp:useBean id="formDateInicio" class="java.util.Date"/>
					<fmt:formatDate value="${proyectoi.fechaInicio}" type="date" pattern="dd-MM-yyyy"/>
				</td>
				<td>
					<jsp:useBean id="formDateFin" class="java.util.Date"/>
							<fmt:formatDate value="${proyectoi.fechaFin}" type="date" pattern="dd-MM-yyyy"/>
				</td>
				<td>
					<form action="FinalizarProyecto">
						<input type=hidden name="name" value="${proyectoi.name}"  />
						<button type="submit">Finalizar proyecto</button>
					</form>
				</td>
				<td>
					<form action="EliminarProyecto" method="post">
			     		 <input type=hidden name="name" value="${proyectoi.name}"  />
						 <input type="image" style="height:25px; width:25px;padding:0px;border:none;margin:0px;"  src="images/trash_icon.png" id="deleteproyecto"  />
					</form>
				</td>
				</tr>
				</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
