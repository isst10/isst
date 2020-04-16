<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form action="CreaEmpleado">
	<input type="text" name="email" placeholder="Email">
	<input type="password" name="password" placeholder="Password">
	<input type="text" name="name" placeholder="Nombre y apellidos">
	<input type="text" name="empresa" placeholder="Empresa">
	<button type="submit">Registrar empleado</button>
</form>