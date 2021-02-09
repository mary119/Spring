<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Login Page</title>
<script type="text/javascript">
function loginValidate(){
	
	var email=document.login.email.value;
	var password=document.login.password.value;
	var regex=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
	if(email ==null||email==""){
		document.getElementById("err_email").innerHTML="Email field can't be blank"
		return false;
	}
	if(!(email ==null||email=="")){
		document.getElementById("err_email").innerHTML=""
		
	}if(!(email.match(regex))){
		document.getElementById("err_email").innerHTML="Email is not valid"
		return false;
	}
	if((email.match(regex))){
		document.getElementById("err_email").innerHTML=""
	}
	if(password===null||password===""||password.trim().length==0){
		document.getElementById("err_pass").innerHTML="Password can't be null"
			return false;
	}
	if(!(password==null||password=="")){
		document.getElementById("err_pass").innerHTML=""
			
	}
	}
</script>

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">E-Commerce</a> <a class="navbar-brand"
		href="Landing.jsp">Register</a> </nav>
	

${message}
${name}
<div class="">
	<div class="container ">
		<form class="" action="login.do"  method="post" name="login" onsubmit="return loginValidate()"  id="log">
				
			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Email </label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" placeholder="Email" name="email" >
					<span id="err_email" style=" color: red"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Password </label>
				</div>
				<div class="col-sm-6">
					<input type="password" class="form-control mt-3" placeholder="Password" name="password" >
					<span id="err_pass" style=" color: red"></span>
				</div>
			</div>

			
			<button type="submit" class="btn btn-primary">Login</button><span></span>
			<button type="reset" class="btn btn-danger">Cancel</button><span></span>
			
						<a href="ForgetPassword.jsp">Forgot Password</a>
		</form> 
	</div>


	<nav
		class="navbar fixed-bottom navbar-dark bg-dark justify-content-center">
	<a class="navbar-brand " href="#"><small>&copyCopyright
			good-old-days 2021</small></a> </nav>

</body>
</html>