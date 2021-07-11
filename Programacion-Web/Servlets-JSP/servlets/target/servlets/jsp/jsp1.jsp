<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.0">
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
<title>Ejemplo JSP</title>
</head>
<body>
	<h1>Consulta a base de datos con JSP</h1>
	<c:set var="personas" value="${requestScope['personas']}"/>
	Numero de personas registradas: <c:out value="${fn:length(personas)}"/>
	<table>
		<thead> 
			<tr> 
				<th>Nombre</th>
				<th>Primer apellido</th>
				<th>Segundo apellido</th>
				<th>CURP</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach items="${personas}" var="persona">
			<tr> 
				<td>${persona.nombre}</td>
				<td>${persona.primerApellido}</td>
				<td>${persona.segundoApellido}</td>
				<td>${persona.curp}</td>
				<td> </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href ="ServletJSP2">Registrar</a>
</body>
</html>
</jsp:root>