<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page errorPage="404.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Reset Password</title>

<script type="text/javascript">
function validate(){
	var otp=document.reset.password.value;
	var newP=document.reset.newPassword.value;
	var cP=document.reset.cPassword.value;
	
	if(otp==null||otp==""){
		document.getElementById("otp").innerHTML="*OTP can't be blank"
		return false;
	}
	if(!(otp==null||otp=="")){
		document.getElementById("otp").innerHTML=""
		
	}
	if((newP==null||newP=="")){
		document.getElementById("newP").innerHTML="*password can't be blank"
			return false;
	}
	if(!((newP==null||newP==""))){
		document.getElementById("newP").innerHTML=""
		
	}if((cP==null||cP=="")){
		document.getElementById("cP").innerHTML="*confirm password can't be blank"
			return false;
	}
	if(!(cP==null||cP=="")){
		document.getElementById("cP").innerHTML=""
			
	}
	if(newP!=cP){
		document.getElementById("cP").innerHTML="*password and confirm are not same"
			return false;
	}
	if(newP==cP){
		document.getElementById("cP").innerHTML=""
	}
	
}
</script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">E-Commerce</a> <a class="navbar-brand"
		href="Login.jsp">Login</a> </nav>
	
	${reset}

	<div class="container">
		<form action="reset.do" method="post" name="reset" onsubmit="return validate()" >

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Enter OTP </label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" placeholder="OTP" name="password" >
					<span id="otp" style=" color: red "></span>
				</div>
			</div>

			<div class="row"> 
				<div class="col-sm-3 mt-3">
					<label>New Password </label>
				</div>
				<div class="col-sm-6">
					<input type="password" class="form-control mt-3" placeholder="Enter New Password" name="newPassword" >
					<span id="newP" style=" color: red "></span>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Confirm Password </label>
				</div>
				<div class="col-sm-6">
					<input type="password" class="form-control mt-3" placeholder="Confirm Password" name="cPassword" >
					<span id="cP" style=" color: red "></span>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Save</button>
			<button type="reset" class="btn btn-danger">Cancel</button>
			
		</form> 
	
	
	<nav
		class="navbar fixed-bottom navbar-dark bg-dark justify-content-center">
	<a class="navbar-brand " href="#"><small>&copyCopyright
			good-old-days 2021</small></a> </nav>
</body>
</html>