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

	<div class="card container container--md cd-tabs js-cd-tabs ">
		<div class="cd-tabs__panel text-component cd-tabs__panel--selected">
			<div class="container flex--center-x"><div><h1 class="text--xxl">Bienvenido, ${jefe.nombre}</h1></div>
			<div><%@ include file = "Logout.jsp" %></div>
			
			<p><b>Número de proyectos activos: </b>${fn:length(jefe.proyectosJefe)}</p>
			
			
				<h2>Proyectos</h2><table class="items-table">
				<tr>
					<th style="width:45%">Titulación</th>
					<th style="width:15%">Desde</th>
					<th style="width:15%">Hasta</th>
					<th style="width:20%">Finalizar</th>
					<th style="width:5%"></th>
				</tr>
				<c:forEach items="${jefe.proyectosJefe}" var="proyectoi">
				<tr>
				
				<td>
					<a href="/Proyecto.jsp">
					<span>${proyectoi.name}
					</span>
					</a>
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
			
			
			<h2>Registrar un nuevo proyecto</h2>
			<%@ include file = "FormCreaProyecto.jsp" %>
			
			

<!-- <h2>Registrar Horas</h2> -->
<%-- <%@ include file = "FormRegistraHoras.jsp" %> --%>



</div>
</div>
</body>
</html>