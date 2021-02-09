<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script type="text/javascript">
function validate() {
	var email=document.forgot.email.value;
	var regex=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
	if(email==null||email==""){
		document.getElementById("err_email").innerHTML="*Email field can't be left blank"
		return false;
	}
	if(!(email==null||email=="")){
		document.getElementById("err_email").innerHTML=""
		
	}
	if(!email.match(regex)){
		document.getElementById("err_email").innerHTML="*Invalid Email "
			return false;
	}
	if(email.match(regex)){
		document.getElementById("err_email").innerHTML=" "
			
	}
}
</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">E-Commerce</a> <a class="navbar-brand"
		href="LandingPage.jsp">Register</a> <a class="navbar-brand"
		href="Login.jsp">Login</a> </nav>
	${message}

	<div class="container">
		<form action="forgot.do" method="post" onsubmit="return validate() " name="forgot">

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Email </label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" placeholder="Email" name="email">
					<span id="err_email" style=" color: red "></span>
				</div>
			</div>


			<button type="submit" class="btn btn-primary">Reset</button>
		</form>
	

	<nav
		class="navbar fixed-bottom navbar-dark bg-dark justify-content-center">
	<a class="navbar-brand " href="#"><small>&copyCopyright
			good-old-days 2021</small></a> 
	</nav>

</body>
</html>