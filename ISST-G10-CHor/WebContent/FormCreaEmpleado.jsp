<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script>
	function usuarioRegistrado(){
		alert("Introduce tus credenciales");
	}
</script>


<form action="CreaEmpleado">
	<input type="text" name="email" placeholder="Email">
	<input type="password" name="password" placeholder="Password">
	<input type="text" name="name" placeholder="Nombre y apellidos">
	<button type="submit" onCLick ="return usuarioRegistrado()">Registrar empleado</button>
</form>