<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel= "stylesheet" type= "text/css"/>
 

<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>

<div class= "form-div container--md">
<h2>Registrar un nuevo jefe</h2>
<%@ include file = "FormCreaJefe.jsp" %>

<h2>Registrar un nuevo empleado</h2>
<%@ include file = "FormCreaEmpleado.jsp" %>

<h2>Volver</h2>
<%@ include file = "Logout.jsp" %>
</div>
</body>
</html>