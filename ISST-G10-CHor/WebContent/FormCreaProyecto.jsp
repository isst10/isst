<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="CreaProyecto">
	<input type="text" name="name" placeholder="Nombre proyecto">
	<input type="date" name="fechaFin">
	<%-- <p>Selecciona empleados</p>
	    <select class="form-control" name="employees[]" multiple>
  			<c:forEach items="${empleados}" var="empleadoi">
  				<option>${empleadoi.email}</option>
  			</c:forEach>	
		</select> --%>
	<button type="submit">Registrar proyecto</button>
</form>