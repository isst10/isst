<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="CreaProyecto">
	<input type="text" name="name" placeholder="Nombre proyecto">
		<input type="text" name="cliente" placeholder="Nombre del cliente">
<input type="date" name="fechaFin"
       value="2020-07-22"
       min="2020-01-01" max="2020-12-31">
	<button type="submit">Registrar proyecto</button>
</form>