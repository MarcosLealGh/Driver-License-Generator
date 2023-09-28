<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> 	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Licencia</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
	<form:form method="post" modelAttribute="licencia" action="/crear/licencia">
	    <!-- Otros campos de licencia -->
	    
	    <!-- Selector desplegable para personas -->
			<div class="mb-3">
	        <label for="persona" class="form-label">Personas</label>
	        <form:select path="persona" class="form-select" id="persona" required="true">
	            <form:options items="${personas}" itemValue="id" itemLabel="nombre" />
	        </form:select>
	        <div class="invalid-feedback">
	            <form:errors path="persona" cssClass="text-danger" />
	        </div>
	    </div>
	
	    <!-- Selector desplegable para estados -->
	    <div class="mb-3">
	        <label for="estado" class="form-label">Estado</label>
	        <form:select path="estado" class="form-select" id="estado" required="true">
	            <form:options items="${estados}" />
	        </form:select>
	        <div class="invalid-feedback">
	            <form:errors path="estado" cssClass="text-danger" />
	        </div>
	    </div>
	    
		<div class="mb-3">
		    <label for="fechaCaducidad" class="form-label">Fecha de Caducidad</label>
		    <input type="date" class="form-control" id="fechaCaducidad" name="fechaCaducidad" required>
		    <div class="invalid-feedback">
		        Por favor, ingrese una fecha de caducidad válida.
		    </div>
		</div>
	
	
	    <!-- Otros campos y botón de enviar -->
	    <button type="submit" class="btn btn-primary">Crear Licencia</button>
	</form:form>

    </div>
</body>
</html>