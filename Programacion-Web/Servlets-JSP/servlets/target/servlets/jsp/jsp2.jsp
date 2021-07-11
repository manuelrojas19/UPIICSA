<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
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
<title>Registrar</title>
</head>
<body>
	<form action="ServletJSP2" method="post">
		<h1>Registro a base de datos con JSP</h1>
		Nombre: <input id="txNombre" name="nombre" value=""/><br/>
		Primer apellido: <input id="txPrimerApellido" name="primerApellido" value=""/><br/>
		Segundo apellido: <input id="txSegundoApellido" name="segundoApellido" value=""/><br/>
		CURP: <input id="txCurp" name="curp" value=""/><br/>
		<input type="submit" value="Aceptar" /> <a href="ServletJSP1">Cancelar</a>
	</form>
</body>
</html>
</jsp:root>