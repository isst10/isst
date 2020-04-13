<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>

<h2>Registrar un nuevo jefe</h2>
<%@ include file = "FormCreaJefe.jsp" %>

<h2>Registrar un nuevo empleado</h2>
<%@ include file = "FormCreaEmpleado.jsp" %>

<h2>Volver a inicio</h2>
<%@ include file = "Logout.jsp" %>

</body>
</html>