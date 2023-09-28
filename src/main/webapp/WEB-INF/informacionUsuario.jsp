<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Informacion Licencia</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container mt-5">
        <h1>Informacion de la licencia</h1>
        <div class="row">
            <div class="col-md-6">
                <h3>Nombre de la persona:</h3>
                <p>${persona.nombre}</p> 
            </div>
           <h3>Licencias de la persona:</h3>
	<table class="table">
	    <thead>
	        <tr>
	            <th>Número de Licencia</th>
	            <th>Estado de la Licencia</th>
	            <th>Fecha de Caducidad</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${licencias}" var="licencia">
	            <tr>
	                <td>${licencia.numeroDeLicencia}</td>
	                <td>${licencia.estado}</td>
	                <td>${licencia.fechaCaducidad}</td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>

        <!-- Agrega un botón para volver a la lista de lenguajes -->
        <a href="/crear/persona" class="btn btn-primary">Volver a crear persona</a>
    </div>
</body>
</html>
