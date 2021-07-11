<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">

	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Editar</title>
</head>
<body>
	<h1>Update a base de datos con JSP</h1>
	<c:set var="persona" value="${requestScope['persona']}" />
	<form action="ServletJSP3" method="post">
		<input type="hidden" name="idPersona" value="${persona.id}"/>
		Nombre: <input id="txNombre" name="nombre" value="${persona.nombre}" /><br />
		Primer apellido: <input id="txPrimerApellido" name="primerApellido"
			value="${persona.primerApellido}" /><br /> Segundo apellido: <input
			id="txSegundoApellido" name="segundoApellido"
			value="${persona.segundoApellido}" /><br /> CURP: <input
			id="txCurp" name="curp" value="${persona.curp}" /><br /> <input
			type="submit" value="Aceptar" /> <a href="ServletJSP1">Cancelar</a>
	</form>
</body>
	</html>
</jsp:root>