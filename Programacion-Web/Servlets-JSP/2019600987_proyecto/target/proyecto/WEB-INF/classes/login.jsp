<!doctype html>
<html lang="es">
<head>
</head>
<body class="text-center">
	<form class="form-signin" action="LoginServlet" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Ingresar al sistema</h1>
		<label for="inputEmail" class="sr-only">Correo Electrónico</label> <input
			type="email" id="inputEmail" name="login" class="form-control"
			placeholder="Correo electrónico" required autofocus> <label
			for="inputPassword" class="sr-only">Contraseña</label> <input
			type="password" id="inputPassword" name="password"
			class="form-control" placeholder="Contraseña" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
	</form>
</body>
</html>
