<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <!DOCTYPE html"> ]]>
	</jsp:text>
	<html lang="es">
<head>

</head>
<body class="text-center">

	<c:set var="user" value="${sessionScope['session_user']}" />
	<h1>Welcome</h1>
	${user.name} ${user.lastName}
</body>
	</html>
</jsp:root>