<!doctype html>
<html lang="es">
<head>
</head>
<body class="text-center">
	<form class="form-signin" action="LoginServlet" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Ingresar al sistema</h1>
		<label for="inputEmail" class="sr-only">Correo Electr�nico</label> <input
			type="email" id="inputEmail" name="login" class="form-control"
			placeholder="Correo electr�nico" required autofocus> <label
			for="inputPassword" class="sr-only">Contrase�a</label> <input
			type="password" id="inputPassword" name="password"
			class="form-control" placeholder="Contrase�a" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
	</form>
</body>
</html>
