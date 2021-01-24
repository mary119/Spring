<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">E-Commerce</a> <a class="nav-link"
			href="Landing.jsp">Home</a>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="Login.jsp">Login <span class="sr-only">(current)</span>
				</a>
			</ul>
		</div>
	</nav>
	<form action="index.jsp">
		<div class="container" style="margin-top: 50px">
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-6">
					<input type="email" class="form-control" id="email"
						placeholder="Enter valid Email">
				</div>
			</div>
			<div>
				<input class="btn btn-primary" type="submit" value="Reset">
			</div>
		</div>
	</form>
	<nav
		class="navbar fixed-bottom navbar-dark bg-dark justify-content-center">
		<a class="navbar-brand" href=#><small>@CopyRight 2021</small></a>
	</nav>

</body>
</html>