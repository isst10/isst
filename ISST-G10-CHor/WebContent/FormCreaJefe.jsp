<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="css/estilos.css" rel= "stylesheet" type= "text/css"/>

<form action="CreaJefe" id="registro-form">
	<input type="text" name="email" placeholder="Email">
	<input type="password" name="password" placeholder="Password">
	<input type="text" name="name" placeholder="Nombre y apellidos">
	<input style="height:45px; margin-top:5px;" type="submit" value="Registrarse"/>
</form>