<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <!DOCTYPE html> ]]>
	</jsp:text>
	<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Bootstrap CSS  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
	<!--//--></link>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css">
	<!--//--></link>
<!-- Sidebar CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/sidebar.css"
	rel="stylesheet">
	<!--//--></link>
<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous">
<!--//-->
	
</script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous">
<!--//-->
	
</script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
	integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
	crossorigin="anonymous">
<!--//-->
	
</script>
<script
	src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js">
<!--//-->
	
</script>
<script
	src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js">
<!--//-->
	
</script>
<!-- Menu Toggle Script -->
<script>
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});
</script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous">
	<!--//--></link>

<decorator:head></decorator:head>
</head>
<title>Programación Web</title>
<body>

	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<div class="bg-light border-right" id="sidebar-wrapper">
			<a class="sidebar-heading navbar-brand" href="welcome.jsp">Social
				Web</a>
			<div class="list-group list-group-flush">
				<a href="FriendsServlet"
					class="list-group-item list-group-item-action bg-light">Contacts</a>
				<!--/
				<a href="#" class="list-group-item list-group-item-action bg-light">Shortcuts</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">Overview</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">Events</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">Profile</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">Status</a>
				/-->
			</div>
		</div>

		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<!--/	<a class="navbar-brand" href="welcome.jsp">Social Web</a> /-->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="welcome.jsp">Home <span class="sr-only">(current)</span>
						</a></li>
						<!--/
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Dropdown </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Action</a> <a
									class="dropdown-item" href="#">Another action</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Something else here</a>
							</div></li>
						<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
						
						</li>/-->
					</ul>
				</div>
			</nav>
			<main role="main">
				<div class="container">
					<decorator:body></decorator:body>
				</div>
			</main>
		</div>
		<!-- /#wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS 
	<script src="${pageContext.request.contextPath}/resources/components/jquery/3.5.1/jquery-3.5.1.js"></script>
	<script	src="${pageContext.request.contextPath}/resources/components/popper/1.16.0/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/components/bootstrap-4.5.3/js/bootstrap.min.js"></script>
-->
</body>
	</html>
</jsp:root>